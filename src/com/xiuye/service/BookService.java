package com.xiuye.service;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiuye.dao.BookDao;
import com.xiuye.orm.Book;

@Service
public class BookService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5612807341727511600L;

	@Resource
	private BookDao bookDao;

	public List<Book> getAllBooks() {

		return this.bookDao.findAll();

	}

	@Transactional
	public int deleteBook(Book book) {

		if (book == null) {
			return 0;
		}
		return this.bookDao.deleteBookByBookid(book.getBookid());

	}

	@Transactional
	public int modifyBook(Book book){
		if (book == null) {
			return 0;
		}
		return this.bookDao.updateBookByBookid(book); 
		
	}
	
	public int addBook(Book book){
		
		if(book == null || book.getBookname()==null || book.getCategory() == null
				|| book.getPath() == null || book.getSuffix() == null ||
				book.getBookname().isEmpty() || book.getCategory().isEmpty() ||
				book.getPath().isEmpty() || book.getSuffix().isEmpty()
				){
			return 0;
		}
		book.setBookid(UUID.randomUUID().toString());		
		return this.bookDao.insertBook(book);
		
	}
	
	public String getBookPath(String bookid){
		
		if(bookid == null || bookid.isEmpty()){
			return "";
		}
		
		return this.bookDao.findBookPathByBookid(bookid);
		
	}
	
	public Book getBookByBookid(String bookid){
		
		
		
		return this.bookDao.findBookByBookid(bookid);
		
	}
	
	public int addReadtime(Book book){
		
		if(book == null){
			return 0;
		}
		return this.bookDao.updateAddReadtime(book);
	}
}
