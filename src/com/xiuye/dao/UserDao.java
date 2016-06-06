package com.xiuye.dao;

import java.util.List;


import com.xiuye.orm.User;

public interface UserDao {

	List<User> findAll();
	
	User findUserByUserid(String userid);
	
	User findUserByNameAndPasswd(String username,String password);
	
	User findUserByEmailAndPasswd(String email,String password);
	
	User findUserByPhoneAndPasswd(String phone,String password);
	
	int insertOneUser(User user);
	
}
