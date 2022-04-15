package com.foodrecipe.dao;

import com.foodrecipe.entity.User;

public interface IUserDao {

	User getUserByName(String userName);

	boolean addUser(User user);

	void updateUser(User user);

}
