package com.pancake.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.Page;
import com.pancake.service.FavoriteService;

@Controller
@RequestMapping(value = "/FavoriteController")
public class FavoriteController {
	private static final Logger logger = Logger.getLogger(FavoriteController.class);
	@Autowired
	private FavoriteService fs;

	@RequestMapping(value = "/favoriteListController")
	public ModelAndView favoriteList(HttpSession session, HttpServletRequest request) {
		// 获取当前用户的收藏列表
		logger.info("favoriteListController called");
		String userName = ((String) session.getAttribute("userName"));
		ModelAndView mav = null;
		if (null != userName) {
			mav = new ModelAndView("favorite_list");
			try {
				int pageNo = 1;
				if (request.getParameter("pageNo") != null) {
					pageNo = Integer.valueOf(request.getParameter("pageNo"));
					logger.info("pageNo: " + pageNo);
				}
				int pageSize = 8;
				Page page = fs.GetUserFavsWithPage(pageNo, pageSize, userName);
				mav.addObject("page", page);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			mav = new ModelAndView("redirect:/UserLogController/loginBarController");
		}
		return mav;
	}
}
