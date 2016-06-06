package com.xiuye.orm;

import java.util.Date;

public class OnlineUser {

	private String userid;
	private String sessionid;
	private Date deletedate;
	private Date createdate;
	private int saveminutes;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public Date getDeletedate() {
		return deletedate;
	}
	public void setDeletedate(Date deletedate) {
		this.deletedate = deletedate;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public int getSaveminutes() {
		return saveminutes;
	}
	public void setSaveminutes(int saveminutes) {
		this.saveminutes = saveminutes;
	}
	
	
	
}
