/**   
* @Title: LeaveWordsController.java 
* @Package com.pancake.controller 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月19日 下午7:18:15 
* @version V1.0   
*/
package com.pancake.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pancake.service.LeaveWordsService;

/**
 * @ClassName: LeaveWordsController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chao zcsd2668@163.com
 * @date 2017年5月19日 下午7:18:15
 *
 */
@Controller
@RequestMapping(value = "/LeaveWordsController")
public class LeaveWordsController {
	private static final Logger logger = Logger.getLogger(LeaveWordsController.class);
	@Autowired
	private LeaveWordsService lws;

	@RequestMapping(value = "/addLeaveWordsController")
	public String addLeaveWords(HttpSession session, HttpServletRequest request) {
		logger.info("addLeaveWordsController called");
		String userName = (String) session.getAttribute("userName");
		String message = request.getParameter("message");
		Long goodId = Long.valueOf(request.getParameter("goodId"));
		lws.addLeaveWords(userName, message, goodId);
		return "redirect:/GoodController/goodInfoController?goodId=" + goodId;
	}
}
