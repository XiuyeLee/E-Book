package com.xiuye.orm;

public class Feedback {

	private String userid;
	private String content;
	private String fbdate;
	private boolean isdeal;
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
	public String getFbdate() {
		return fbdate;
	}
	public void setFbdate(String fbdate) {
		this.fbdate = fbdate;
	}
	public boolean isIsdeal() {
		return isdeal;
	}
	public void setIsdeal(boolean isdeal) {
		this.isdeal = isdeal;
	}
	
	
}
