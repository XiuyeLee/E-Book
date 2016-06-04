package com.xiuye.dao;

import java.util.List;


import com.xiuye.orm.User;

public interface UserDao {

	List<User> findAll();
	
	User findByUserid(String userid);
	
	User findUserByNameAndPasswd(String username,String password);
	
	User findUserByEmailAndPasswd(String email,String password);
	
	User findUserByPhoneAndPasswd(String phone,String password);
	
	void insertOneUser(User user);
	
}
