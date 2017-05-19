/**   
* @Title: LeaveWordsServiceImpl.java 
* @Package com.pancake.service.impl 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月19日 下午7:33:18 
* @version V1.0   
*/
package com.pancake.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pancake.dao.GoodDao;
import com.pancake.dao.LeaveWordsDao;
import com.pancake.dao.UserDao;
import com.pancake.entity.Good;
import com.pancake.entity.LeaveWords;
import com.pancake.entity.User;
import com.pancake.service.LeaveWordsService;

/**
* @ClassName: LeaveWordsServiceImpl
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chao zcsd2668@163.com
* @date 2017年5月19日 下午7:33:18
*
*/
@Service
public class LeaveWordsServiceImpl implements LeaveWordsService {
	@Autowired
	private UserDao ud;
	@Autowired
	private GoodDao gd;
	@Autowired
	LeaveWordsDao lwd;
	
	@Override
	public void addLeaveWords(String userName, String message, Long goodId) {
		Good good = gd.findById(goodId);
		User user = (User) ud.findByUserName(userName).get(0);
		LeaveWords leaveWords = new LeaveWords(good, user, message);
		lwd.save(leaveWords);
	}

}
