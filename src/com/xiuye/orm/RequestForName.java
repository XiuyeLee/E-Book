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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (isdeal ? 1231 : 1237);
		result = prime * result
				+ ((requestdate == null) ? 0 : requestdate.hashCode());
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
		RequestForName other = (RequestForName) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (isdeal != other.isdeal)
			return false;
		if (requestdate == null) {
			if (other.requestdate != null)
				return false;
		} else if (!requestdate.equals(other.requestdate))
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
		return  userid + "。" + content
				+ "。" + isdeal + "。" + requestdate;
	}

}
