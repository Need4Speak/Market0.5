package com.pancake.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pancake.dao.UserDao;
import com.pancake.entity.User;
import com.pancake.service.UserLogService;
@Service
public class UserLogServiceImpl implements UserLogService {
	@Autowired
	private UserDao ud;
	@Override
	public boolean compareLoginInfo(String userName, String password) {
		// 数据库中 userName 唯一，因此该 list 只有一个元素存在。
		User user = (User) ud.findByUserName(userName).get(0);
		if (user != null) {
			String passwordInDB = user.getPassword();
			if (passwordInDB.equals(password)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
