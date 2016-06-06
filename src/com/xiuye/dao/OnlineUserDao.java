package com.xiuye.dao;

import java.util.List;

import com.xiuye.orm.OnlineUser;

public interface OnlineUserDao {

	List<OnlineUser> findAll();
	
	String findUseridBySessionid(String sessionid);
		
	int insertSession(OnlineUser session);
	
	OnlineUser findOnlineUserBySessionid(String sessionid);
	
	int deleteOnlineUserBySessionid(String sessionid);
	
	OnlineUser findOnlineUserByUserid(String userid);
	
	List<OnlineUser> findOnlineUsersInSessionTimeout();
	
	int deleteOnlineUserByUserid(String userid);
	
}
