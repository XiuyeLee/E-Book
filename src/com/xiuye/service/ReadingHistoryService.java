package com.xiuye.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiuye.beans.ReadingHistoryBook;
import com.xiuye.dao.BookDao;
import com.xiuye.dao.ReadingHistoryDao;
import com.xiuye.orm.Book;
import com.xiuye.orm.ReadingHistory;
import com.xiuye.orm.User;

@Service
public class ReadingHistoryService {

	@Resource
	private ReadingHistoryDao rhDao;

	@Resource
	private BookDao bookDao;

	public List<ReadingHistory> getUserReadingHistorys(User user) {

		List<ReadingHistory> list = new ArrayList<ReadingHistory>();

		if (user != null) {
			// 不管取到有没有值，都会返回list的实例对象，只不过有可能是空的
			list = rhDao.findReadingHistoryBookByUserid(user.getUserid());
		}
		return list;

	}

	public List<Book> getUserBooks(User user) {

		List<Book> books = new ArrayList<Book>();

		if (user == null) {
			return books;
		}

		List<ReadingHistory> list = this.getUserReadingHistorys(user);
		for (ReadingHistory r : list) {
			books.add(this.bookDao.findBookByBookid(r.getBookid()));
		}

		return books;

	}

	public List<ReadingHistoryBook> getUserReadingHistoryBooks(User user) {
		List<ReadingHistoryBook> readHistoryBooks = new ArrayList<ReadingHistoryBook>();
		if (user == null) {
			return readHistoryBooks;
		}
		List<ReadingHistory> list = this.getUserReadingHistorys(user);
		for (ReadingHistory r : list) {

			ReadingHistoryBook rhBook = new ReadingHistoryBook();
			Book b = this.bookDao.findBookByBookid(r.getBookid());

			rhBook.setBook(b);
			rhBook.setReadingHistory(r);

			readHistoryBooks.add(rhBook);

		}
		return readHistoryBooks;
	}

}
