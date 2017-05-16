package com.pancake.service.impl;

import org.springframework.stereotype.Service;

import com.pancake.dao.impl.UserDaoImpl;
import com.pancake.entity.User;
import com.pancake.service.UserLogService;
@Service
public class UserLogServiceImpl implements UserLogService {
	
	private UserDaoImpl udi = new UserDaoImpl();
	@Override
	public boolean compareLoginInfo(String userName, String password) {
		// 数据库中 userName 唯一，因此该 list 只有一个元素存在。
		User user = (User) udi.findByUserName(userName).get(0);
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
