package com.xiuye.orm;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserFavoriteBook implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2093832005837492645L;
	private String userid;
	private String bookid;
	private Date addDate;

	private int readtimes;

	public String getUserid() {
		return userid;
	}

	public int getReadtimes() {
		return readtimes;
	}

	public void setReadtimes(int readtimes) {
		this.readtimes = readtimes;
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

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addDate == null) ? 0 : addDate.hashCode());
		result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
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
		UserFavoriteBook other = (UserFavoriteBook) obj;
		if (addDate == null) {
			if (other.addDate != null)
				return false;
		} else if (!addDate.equals(other.addDate))
			return false;
		if (bookid == null) {
			if (other.bookid != null)
				return false;
		} else if (!bookid.equals(other.bookid))
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
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String date = "";
		if (addDate != null)
			date = format.format(addDate);
		return date;
	}

}
