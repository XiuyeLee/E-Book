package com.xiuye.test;

import com.xiuye.dao.UserFavoriteBookDao;
import com.xiuye.util.SpringUtil;

public class UserFavoriteBookDaoTest {

	public static void main(String[] args) {

		UserFavoriteBookDao dao = SpringUtil.getBean(UserFavoriteBookDao.class);
//		int i = dao.deleteUserFavoriteBookByUseridAndBookid("12101010423", "1001");
//		System.out.println(i);
		System.out.println(dao.findUserFavoriteBooksByUserid("12101010423"));
		
	}

}
