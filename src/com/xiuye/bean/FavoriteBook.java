package com.xiuye.bean;

import com.xiuye.orm.Book;
import com.xiuye.orm.UserFavoriteBook;

public class FavoriteBook {

	private Book book;
	private UserFavoriteBook ufBook;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public UserFavoriteBook getUfBook() {
		return ufBook;
	}
	public void setUfBook(UserFavoriteBook ufBook) {
		this.ufBook = ufBook;
	}
	@Override
	public String toString() {
		return  book + "。" + ufBook;
	}
	
	
	
}
