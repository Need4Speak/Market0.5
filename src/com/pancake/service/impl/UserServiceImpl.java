package com.pancake.service.impl;

import org.springframework.stereotype.Service;

import com.pancake.dao.impl.UserDaoImpl;
import com.pancake.entity.User;
import com.pancake.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserDaoImpl udi = new UserDaoImpl();

	@Override
	public User getByName(String userName) {
		// 虽然findByUserName 函数返回类型为list，但因为数据库中建了username 的唯一值索引，
		// 所以实际返回一个 User 对象。
		return (User) udi.findByUserName(userName);
	}

	@Override
	public User getById(Long userId) {
		// TODO Auto-generated method stub
		return udi.findById(userId);
	}

	@Override
	public User update(User user) {
		udi.merge(user);
		return null;
	}
	
}
