package com.xiuye.dao;

import java.util.List;

import com.xiuye.orm.UserFavoriteBooks;

public interface UserFavoriteBooksDao {

	List<UserFavoriteBooks> findAll();
	
}
