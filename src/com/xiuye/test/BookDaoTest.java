package com.xiuye.test;


import java.util.List;

import com.xiuye.dao.BookDao;
import com.xiuye.orm.Book;
import com.xiuye.util.SpringUtil;

public class BookDaoTest {

	public static void main(String[] args) {
		
		BookDao bookDao = SpringUtil.getBean(BookDao.class);
		List<Book> books = bookDao.findByBookname("C++ Primer Plus（第6版）");
		for(Book b : books){
			System.out.println(b.getBookid()+":"+b.getBookname());
		}
	}
	
}
