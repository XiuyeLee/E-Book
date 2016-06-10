package com.xiuye.dao;

import java.util.List;

import com.xiuye.orm.Book;

public interface BookDao {

	public List<Book> findAll();

	List<Book> findByBookname(String bookname);

	int insertBook(Book book);

	Book findBookByBookid(String bookid);

	int deleteBookByBookid(String bookid);

	int updateBookByBookid(Book book);
	
	String findBookPathByBookid(String bookid);
	int updateAddReadtime(Book book);
}
