package com.foodrecipe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodrecipe.entity.User;

@Transactional
@Repository
public class UserDao implements IUserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUserByName(String userName) {
		String hql = "FROM User as user where user.userName ='" +userName+ "'";
		List<User> userList = entityManager.createQuery(hql).getResultList();
		return userList.size() > 0 ? userList.get(0) : null ;
	}

	@Override
	public boolean addUser(User user) {
		entityManager.persist(user);
		return true;
	}

	@Override
	public void updateUser(User user) {
		User userDB =  getUserByName(user.getUserName());
		userDB.setEmail(user.getEmail());
		userDB.setFirstName(user.getFirstName());
		userDB.setLastName(user.getLastName());
		userDB.setPassword(user.getPassword());
		entityManager.flush();

	}

}
