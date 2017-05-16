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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.Page;
import com.pancake.service.GoodService;

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
//	private static final Log logger = LogFactory.getLog(GoodController.class);
	@Autowired
	private GoodService gs;
	@RequestMapping(value = "/IndexController")
	public ModelAndView findAllGood(HttpServletRequest request, HttpServletResponse response) {
//		logger.info("FindAllGood called");
		ModelAndView mav = new ModelAndView("show_goods");
		try {
			int pageNo = 1;
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.valueOf(request.getParameter("pageNo"));
//				logger.info("pageNo: " + pageNo);
			}
			int pageSize = 8;
			Page page = gs.getAllGoodsWithPage(pageNo, pageSize);
			mav.addObject(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
