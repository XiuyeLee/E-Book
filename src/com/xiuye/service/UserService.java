package com.xiuye.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiuye.dao.UserDao;
import com.xiuye.orm.User;

@Service
public class UserService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4106557236366334532L;
	@Resource
	private UserDao userDao;

	public List<User> findAllUsers() {

		return userDao.findAll();

	}

	@Transactional
	public void insertUser(User user) {

		userDao.insertOneUser(user);

	}

	public User validate(String name, String password) {

		if (name != null && !name.isEmpty() && password != null
				&& !password.isEmpty()) {
			User user = userDao.findUserByPhoneAndPasswd(name, password);

			if (user != null) {
				return user;
			}
			user = userDao.findUserByEmailAndPasswd(name, password);
			if (user != null) {
				return user;
			}
			user = userDao.findUserByNameAndPasswd(name, password);
			if (user != null) {
				return user;
			}

		}
		return null;

	}

}
