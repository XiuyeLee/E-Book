package com.xiuye.test;

import com.xiuye.dao.UserDao;
import com.xiuye.util.SpringUtil;

public class UserDaoTest {

	public static void main(String[] args) {
		
		UserDao dao = SpringUtil.getBean(UserDao.class);
		
		int i =dao.updateUserPwdByUserid("12101010411","111111");
		System.out.println(i);
	}
	
}


