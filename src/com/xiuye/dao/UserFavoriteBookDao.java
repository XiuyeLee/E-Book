package com.xiuye.dao;

import java.util.List;

import com.xiuye.orm.UserFavoriteBook;

public interface UserFavoriteBookDao {

	List<UserFavoriteBook> findAll();
	List<UserFavoriteBook> findUserFavoriteBooksByUserid(String userid);
	int deleteUserFavoriteBookByUseridAndBookid(String userid,String bookid);
	UserFavoriteBook findUserFavoriteBookByUseridAndBookid(String userid,String bookid);
	int insertFavoriteBook(UserFavoriteBook ufBook);
	int updateAddFavoriteBookReadtime(UserFavoriteBook ufBook);
}
