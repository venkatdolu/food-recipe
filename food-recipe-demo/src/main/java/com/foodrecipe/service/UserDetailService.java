package com.foodrecipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodrecipe.dao.IUserDao;
import com.foodrecipe.entity.User;

@Service
public class UserDetailService implements IUserDetailService {

	@Autowired
	private IUserDao userDao;

	@Override
	public User getUserByName(String userName) {
		return userDao.getUserByName(userName);
	}

	@Override
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);

	}

}
