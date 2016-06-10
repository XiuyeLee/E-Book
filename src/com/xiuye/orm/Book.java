package com.xiuye.orm;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8140654691676267296L;
	private String bookid = "";
	private String bookname = "";
	private String summary = "";
	private String suffix = "";
	private Date publishdate;
	private String publishhouse = "";

	private int readsum;
	private String category = "";
	private String author = "";
	private String cover = "";
	private String path = "";

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Date getPublishdate() {
		if (this.publishdate == null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				this.publishdate = format.parse("0000-00-00");
			} catch (ParseException e) {

				e.printStackTrace();
			}
		}
		return publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	public String getPublishhouse() {
		return publishhouse;
	}

	public void setPublishhouse(String publishhouse) {
		this.publishhouse = publishhouse;
	}

	public int getReadsum() {
		return readsum;
	}

	public void setReadsum(int readsum) {
		this.readsum = readsum;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
		result = prime * result
				+ ((bookname == null) ? 0 : bookname.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((cover == null) ? 0 : cover.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result
				+ ((publishdate == null) ? 0 : publishdate.hashCode());
		result = prime * result
				+ ((publishhouse == null) ? 0 : publishhouse.hashCode());
		result = prime * result + readsum;
		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookid == null) {
			if (other.bookid != null)
				return false;
		} else if (!bookid.equals(other.bookid))
			return false;
		if (bookname == null) {
			if (other.bookname != null)
				return false;
		} else if (!bookname.equals(other.bookname))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (cover == null) {
			if (other.cover != null)
				return false;
		} else if (!cover.equals(other.cover))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (publishdate == null) {
			if (other.publishdate != null)
				return false;
		} else if (!publishdate.equals(other.publishdate))
			return false;
		if (publishhouse == null) {
			if (other.publishhouse != null)
				return false;
		} else if (!publishhouse.equals(other.publishhouse))
			return false;
		if (readsum != other.readsum)
			return false;
		if (suffix == null) {
			if (other.suffix != null)
				return false;
		} else if (!suffix.equals(other.suffix))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		String date = "";
		if (publishdate != null)
			date = format.format(publishdate);
		return bookid + "。" + bookname + "。" + date + "。" + publishhouse + "。 "
				+ readsum + "。" + category + "。" + author;
	}

}
