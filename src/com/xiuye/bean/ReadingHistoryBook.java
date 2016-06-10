package com.xiuye.bean;

import java.io.Serializable;

import com.xiuye.orm.Book;
import com.xiuye.orm.ReadingHistory;

public class ReadingHistoryBook implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8637423367306140157L;
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
	@Override
	public String toString() {
		return  book + "。"
				+ readingHistory ;
	}
	

}
