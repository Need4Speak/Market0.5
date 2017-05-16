/**   
* @Title: GoodController.java 
* @Package com.pancake.controller 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月15日 下午7:29:07 
* @version V1.0   
*/
package com.pancake.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.Favorite;
import com.pancake.entity.Good;
import com.pancake.entity.Page;
import com.pancake.entity.User;
import com.pancake.service.FavoriteService;
import com.pancake.service.GoodService;
import com.pancake.service.UserService;

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

	@RequestMapping(value = "/IndexController")
	public ModelAndView findAllGood(HttpServletRequest request, HttpServletResponse response) {
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
	
	@RequestMapping(value = "/goodInfoController")
	public ModelAndView goodInfo(HttpServletRequest request, HttpServletResponse response) {
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
		return mav;
	}

}
