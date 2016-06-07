package com.xiuye.dao;

import java.util.List;

import com.xiuye.orm.ReadingHistory;

public interface ReadingHistoryDao {

	List<ReadingHistory> findAll();
	
	List<ReadingHistory> findReadingHistoryBookByUserid(String userid);
	
	int deleteReadingHistoryBookByBookid(String bookid);
	
	int insertReadingHistoryBook(ReadingHistory readingBook);
}
