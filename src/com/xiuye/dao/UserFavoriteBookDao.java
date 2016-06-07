package com.xiuye.dao;

import java.util.List;

import com.xiuye.orm.UserFavoriteBook;

public interface UserFavoriteBookDao {

	List<UserFavoriteBook> findAll();
	
}
