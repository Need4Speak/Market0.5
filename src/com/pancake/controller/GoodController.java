/**   
* @Title: GoodController.java 
* @Package com.pancake.controller 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月15日 下午7:29:07 
* @version V1.0   
*/
package com.pancake.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.Classification;
import com.pancake.entity.Favorite;
import com.pancake.entity.Good;
import com.pancake.entity.GoodWithImage;
import com.pancake.entity.LeaveWords;
import com.pancake.entity.Page;
import com.pancake.entity.User;
import com.pancake.service.ClassificationService;
import com.pancake.service.FavoriteService;
import com.pancake.service.GoodService;
import com.pancake.service.LeaveWordsService;
import com.pancake.service.UserService;
import com.pancake.util.ImageProcess;
import com.pancake.util.PicFormatProcess;
import com.sun.prism.Image;

/**
 * @ClassName: GoodController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chao zcsd2668@163.com
 * @date 2017年5月15日 下午7:29:07
 *
 */
@Controller
@RequestMapping(value = "/GoodController")
public class GoodController {
	private static final Logger logger = Logger.getLogger(GoodController.class);
	@Autowired
	private GoodService gs;
	@Autowired
	private UserService us;
	@Autowired
	private FavoriteService fs;
	@Autowired
	private ClassificationService cs;
	@Autowired
	private LeaveWordsService lws;

	@RequestMapping(value = "/IndexController")
	public ModelAndView findAllGood(HttpServletRequest request) {
		// 获取所有商品的信息
		logger.info("IndexController called");
		ModelAndView mav = new ModelAndView("show_goods");
		try {
			int pageNo = 1;
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.valueOf(request.getParameter("pageNo"));
				logger.debug("pageNo: " + pageNo);
			}
			int pageSize = 8;
			Page page = gs.getAllGoodsWithPage(pageNo, pageSize);
			mav.addObject(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * 处理分类展示商品
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/goodsWithClassificationController")
	public ModelAndView goodsWithClassification(HttpServletRequest request) {
		// 获取所有商品的信息
		logger.info("IndexController called");
		Integer classificationId = Integer.valueOf(request.getParameter("classificationId"));
		ModelAndView mav = new ModelAndView("goods_with_classification");
		try {
			int pageNo = 1;
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.valueOf(request.getParameter("pageNo"));
				logger.debug("pageNo: " + pageNo);
			}
			int pageSize = 8;
			Page page = gs.getByclassification(classificationId, pageNo, pageSize);
			mav.addObject("page", page);
			mav.addObject("classificationId", classificationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/goodInfoController")
	public ModelAndView goodInfo(HttpServletRequest request) {
		// 获取 ID 为 goodId 的商品，及其是否被 session 中登录的用户收藏。
		logger.info("goodInfoController called");
		ModelAndView mav = null;
		System.out.println("goodInfoController called");
		Long goodId = Long.valueOf(request.getParameter("goodId"));
		Good good = gs.getById(goodId);
		Favorite favorite = null;
		if (request.getSession().getAttribute("userName") != null) {
			User buyer = us.getByName((String) request.getSession().getAttribute("userName"));
			favorite = fs.getFavByGoodAndBuyer(goodId, buyer);
			logger.info("Object favorite has been created");
		} else {
			logger.info("Object favorite has not been created");
		}

		if (null != good) {
			mav = new ModelAndView("good_info");
			mav.addObject("good", good);
			mav.addObject("favorite", favorite);
		} else {
			mav = new ModelAndView("good_not_ready");
		}
		
		//获取商品留言列表
		List<LeaveWords> list = lws.getByGoodId(goodId);
		mav.addObject("LeaveWordsList", list);
		return mav;
	}

	public List<LeaveWords> getGoodLeaveWords(Long goodId) {
		List<LeaveWords> list = lws.getByGoodId(goodId);
		return list;

	}

	@RequestMapping(value = "/goodAddController")
	public String goodAdd(Model model, HttpSession session) {
		logger.info("goodAddController called");
		String userName = ((String) session.getAttribute("userName"));
		if (null != userName) {
			model.addAttribute("good", new Good());
			return "good_add_form";
		} else {
			return "redirect:/UserLogController/loginBarController";
		}

	}

	@RequestMapping(value = "/goodSaveController")
	public String saveGood(@ModelAttribute GoodWithImage good, HttpSession session, HttpServletRequest request) {
		logger.info("save Good called");
		// Get user object by "userName" attr which is stored in session.
		// Then add in to object good.
		String userName = (String) session.getAttribute("userName");
		Integer classificationId = Integer.valueOf(request.getParameter("classification_id"));
		// 存储图片到image下
		List<String> picList = ImageProcess.storeImage(good, session, request);
		String picString = PicFormatProcess.ListToStr(picList);

		good.setUser(us.getByName(userName));
		good.setClassification(cs.getClassificationById(classificationId));
		// 1 means the good can be selled, by default status=1.
		good.setStatus(1);
		gs.saveGood(good, picString);

		return "redirect:/GoodController/sellerGoodListController";
	}

	@RequestMapping(value = "/sellerGoodListController")
	public String sellerGoodList(Model model, HttpSession session, HttpServletRequest request) {
		String userName = ((String) session.getAttribute("userName"));
		if (null != userName) {
			try {
				int pageNo = 1;
				if (request.getParameter("pageNo") != null) {
					pageNo = Integer.valueOf(request.getParameter("pageNo"));
					logger.info("pageNo: " + pageNo);
				}
				int pageSize = 8;
				// 用户暂时只能查看所有发布的商品，不能分类查看。
				int classificationId = -1;
				Page page = gs.getUserGoodsWithPage(pageNo, pageSize, classificationId, userName);
				model.addAttribute("page", page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "good_list";
		} else {
			return "redirect:/UserLogController/loginBarController";
		}

	}
	
	@RequestMapping(value = "/goodSearchController")
	public String goodSearch(Model model, HttpServletRequest request) {
		logger.info("goodSearchController called");
		String searchContent = request.getParameter("searchContent");
		int pageNo = 1;
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
			logger.info("pageNo: " + pageNo);
		}
		int pageSize = 8;
		Page page = gs.getLikeByName(searchContent, pageNo, pageSize);
		model.addAttribute("page", page);
		model.addAttribute("searchContent", searchContent);
		return "search_result";
	}
	
	@RequestMapping(value = "/goodDeleteController/{id}")
	public String deleteGood(Model model, @PathVariable Long id) {
		// 用户取消商品发布，并不删除，而是设 good 对象的 status 域为1.
		logger.info("goodDeleteController called");
		Good good = gs.getById(id);
		// 0: can't buy. Don't delete the good info.
		good.setStatus(0);
		gs.update(good);
		model.addAttribute("good", good);
		return "redirect:/GoodController/sellerGoodListController";
	}
	
	/**
	 * 跳转到 good_edit_form.jsp 页面
	 * @param model
	 * @param request
	 * @return good_edit_form.jsp
	 */
	@RequestMapping(value = "/goodEditController")
	public String editGood(Model model, HttpServletRequest request) {
		logger.info("goodEditController called");
		Long goodId = Long.valueOf(request.getParameter("goodId"));
		Good good = gs.getById(goodId);
		model.addAttribute("good", good);
		return "good_edit_form";
	}
	
	/**
	 * 根据从表单传过来的 good 来更新数据库中相应的good。
	 * @param good
	 * @param session
	 * @param request
	 * @return goodListController.jsp
	 */
	@RequestMapping(value = "/goodUpdateController")
	public String updateGood(HttpSession session, HttpServletRequest request) {
		// Don't no how to bound field "User user", use session temporary。
		String userName = (String) session.getAttribute("userName");
		Long goodId = Long.valueOf(request.getParameter("goodId"));	
		String name = request.getParameter("name");
		Double price = Double.valueOf(request.getParameter("price"));
		String description = request.getParameter("description");
		
		Good good = gs.getById(goodId);
		
		if(userName == null || !userName.equals(good.getUserByOwnerId().getUserName())) {
			return "non_privileged";
		}
		else {
			good.setName(name);
			good.setPrice(price);
			good.setDescription(description);
			gs.update(good);
			return "redirect:/GoodController/sellerGoodListController";
		}	
	}
}
