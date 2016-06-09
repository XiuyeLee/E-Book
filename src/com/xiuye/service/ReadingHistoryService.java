package com.xiuye.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiuye.bean.ReadingHistoryBook;
import com.xiuye.dao.BookDao;
import com.xiuye.dao.ReadingHistoryDao;
import com.xiuye.logger.Logger;
import com.xiuye.orm.Book;
import com.xiuye.orm.ReadingHistory;
import com.xiuye.orm.User;

@Service
public class ReadingHistoryService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5349990569168253452L;

	private static Logger log = Logger.getLogger(ReadingHistoryService.class);
	
	@Resource
	private ReadingHistoryDao rhDao;

	@Resource
	private BookDao bookDao;

	@Transactional
	public List<ReadingHistory> getUserReadingHistorys(User user) {

		List<ReadingHistory> list = new ArrayList<ReadingHistory>();

		if (user != null) {
			int effectRows = this.rhDao.deleteReadingHistoryBooksByUserid(user.getUserid());
			//清除历史数据成功
			if(effectRows >= 1){
				log.info("清除用户:"+user.getUsername()+"历史阅读数据");
			}
			// 不管取到有没有值，都会返回list的实例对象，只不过有可能是空的
			list = rhDao.findReadingHistoryBookByUserid(user.getUserid());
		}
		return list;

	}

	@Transactional
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

	@Transactional
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
