package com.xiuye.dao;

import java.util.List;




import com.xiuye.orm.Book;


public interface BookDao {
	
	public List<Book> findAll();
	
	Book findByBookname(String bookname);
	
	void insertBook(Book book);
	
	
}
