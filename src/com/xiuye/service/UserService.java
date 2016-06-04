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

	@Resource
	private UserDao userDao;
	
	public List<User> findAllUsers(){
		
		return userDao.findAll();
		
	}
	
	@Transactional
	public void insertUser(User user){
		
		userDao.insertOneUser(user);
		
	}
	
	
}
