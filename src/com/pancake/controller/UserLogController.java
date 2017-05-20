package com.pancake.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pancake.service.UserLogService;

@Controller
@RequestMapping(value = "/UserLogController")
public class UserLogController {
	private static final Logger logger = Logger.getLogger(UserLogController.class);

	@Autowired
	private UserLogService uls;
	
	@RequestMapping(value = "/loginBarController")
	public String loginBar(HttpServletRequest request) {
		logger.info("loginBarController called");
		String page = request.getParameter("page");
		// 判断页面是否来自 goodinfo.jsp
		if (null!=page && page.equals("good_info")) {
			String goodId = request.getParameter("goodId");
			request.setAttribute("page", page);
			request.setAttribute("goodId", goodId);
			
		}
		return "login";
	}

	@RequestMapping(value = "/loginController")
	public String login(HttpServletRequest request) {
		logger.info("loginController called");

		String userName = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();
		
		// 对比用户名和密码
		boolean loginCondition = uls.compareLoginInfo(userName, password);

		if (loginCondition) {
			String page = request.getParameter("page");
			request.getSession().setAttribute("userName", userName);
			if (null != page && page.equals("good_info")) {
				String goodId = request.getParameter("goodId");
				return "redirect:/GoodController/goodInfoController?goodId=" + goodId;
			}
			else {
				return "redirect:/GoodController/IndexController";
			}
		} else {
			return "loginFail";
		}

	}

	@RequestMapping(value = "/logoutController")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("logoutController called");

		HttpSession session = request.getSession(false);
		String userName = request.getParameter("userName").trim();
		// preBasePath store the page path who call this servlet.
		// String preBasePath = request.getParameter("basePath");

		if (userName == null) {
			System.out.println("usrName is null in /logout.");
		} else {
			session.invalidate();
		}

		return "redirect:/GoodController/IndexController";
	}
}
