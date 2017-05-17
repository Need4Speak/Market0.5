package com.pancake.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.entity.Favorite;
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
		} else {
			mav = new ModelAndView("redirect:/UserLogController/loginBarController");
		}
		return mav;
	}

	@RequestMapping(value = "/favoriteCancelController/{favoriteId}")
	public ModelAndView favoriteCancel(Model model, @PathVariable Long favoriteId, HttpServletRequest request) {
		// 根据favoriteId，直接从数据库中删除 favorite。
		Favorite favorite = fs.getById(favoriteId);
		fs.delete(favorite);
		String page = request.getParameter("page");
		ModelAndView mav = null;
		if (null != page && page.equals("good_info")) {
			mav = new ModelAndView(
					"redirect:/GoodController/goodInfoController?goodId=" + favorite.getGood().getGoodId());
		} else if (null != page && page.equals("favorite_list")) {
			mav = new ModelAndView("redirect:/FavoriteController/favoriteListController");
		} else {
			mav = new ModelAndView("");
		}
		return mav;
	}

	@RequestMapping(value = "/addFavoriteController")
	public String addFavorite(HttpServletRequest request) {
		logger.info("addFavoriteController called");

		Long goodId = Long.valueOf(request.getParameter("goodId"));
		String buyerName = (String) request.getSession().getAttribute("userName");

		try {
			fs.createFavorite(buyerName, goodId);
			logger.info("Create collection successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/GoodController/goodInfoController?goodId=" + goodId;
	}
}
