package com.xiuye.beans;

import com.xiuye.orm.Book;
import com.xiuye.orm.ReadingHistory;

public class ReadingHistoryBook {

	private Book book;
	private ReadingHistory readingHistory;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public ReadingHistory getReadingHistory() {
		return readingHistory;
	}
	public void setReadingHistory(ReadingHistory readingHistory) {
		this.readingHistory = readingHistory;
	}

}
