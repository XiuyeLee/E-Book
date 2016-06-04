package com.xiuye.orm;

import java.util.Date;

public class RequestForName {

	private String userid;
	private String content;
	private boolean isdeal;
	private Date requestdate;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isIsdeal() {
		return isdeal;
	}
	public void setIsdeal(boolean isdeal) {
		this.isdeal = isdeal;
	}
	public Date getRequestdate() {
		return requestdate;
	}
	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}
	
	
	
}
