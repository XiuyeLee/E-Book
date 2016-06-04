package com.xiuye.orm;

import java.util.Date;

public class Book {

	private String bookid;
	private String bookname;
	private String summary;
	private String suffix;
	private Date publishdate;
	private String publishhouse;
	private int readsum;
	private String category;
	private String author;
	private String cover;
	private String path;
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
	
	
}
