package com.xiuye.orm;

import java.text.SimpleDateFormat;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
		result = prime * result
				+ ((readingdate == null) ? 0 : readingdate.hashCode());
		result = prime * result + readtimes;
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReadingHistory other = (ReadingHistory) obj;
		if (bookid == null) {
			if (other.bookid != null)
				return false;
		} else if (!bookid.equals(other.bookid))
			return false;
		if (readingdate == null) {
			if (other.readingdate != null)
				return false;
		} else if (!readingdate.equals(other.readingdate))
			return false;
		if (readtimes != other.readtimes)
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");

		String date = "";
		if(readingdate != null)
			date = format.format(readingdate);
		
		return date + "。" + readtimes;
	}

}
