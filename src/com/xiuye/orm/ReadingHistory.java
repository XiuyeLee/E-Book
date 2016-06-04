package com.xiuye.orm;

import java.util.Date;

public class ReadingHistory {

	private String userid;
	private String bookid;
	private Date readingdate;
	private int readtimes;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public Date getReadingdate() {
		return readingdate;
	}
	public void setReadingdate(Date readingdate) {
		this.readingdate = readingdate;
	}
	public int getReadtimes() {
		return readtimes;
	}
	public void setReadtimes(int readtimes) {
		this.readtimes = readtimes;
	}
	
	
}
