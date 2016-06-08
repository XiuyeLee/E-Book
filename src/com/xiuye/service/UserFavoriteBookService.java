package com.xiuye.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiuye.bean.FavoriteBook;
import com.xiuye.dao.BookDao;
import com.xiuye.dao.UserFavoriteBookDao;
import com.xiuye.orm.Book;
import com.xiuye.orm.User;
import com.xiuye.orm.UserFavoriteBook;

@Service
public class UserFavoriteBookService {

	@Resource
	private UserFavoriteBookDao ufBookDao;

	@Resource
	private BookDao bookDao;

	public List<FavoriteBook> getFavoriteBooks(User user) {
		List<FavoriteBook> fbs = new ArrayList<FavoriteBook>();
		if (user == null) {
			return fbs;
		}
		List<UserFavoriteBook> ufBooks = this.getUserFavoriteBooks(user);

		for (UserFavoriteBook uf : ufBooks) {
			FavoriteBook fb = new FavoriteBook();
			
			Book b = this.bookDao.findBookByBookid(uf.getBookid());
			
			fb.setBook(b);
			fb.setUfBook(uf);
			
			fbs.add(fb);

		}

		return fbs;
	}

	public List<UserFavoriteBook> getUserFavoriteBooks(User user) {

		List<UserFavoriteBook> ufBooks = new ArrayList<UserFavoriteBook>();

		if (user == null) {
			return ufBooks;
		}

		ufBooks = this.ufBookDao
				.findUserFavoriteBooksByUserid(user.getUserid());

		return ufBooks;
	}

	public List<Book> getUserBooks(User user) {

		List<Book> list = new ArrayList<Book>();
		if (user == null) {
			return list;
		}

		List<UserFavoriteBook> ufBooks = this.getUserFavoriteBooks(user);

		for (UserFavoriteBook uf : ufBooks) {

			list.add(this.bookDao.findBookByBookid(uf.getBookid()));

		}

		return list;

	}

}
