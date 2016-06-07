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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((fbdate == null) ? 0 : fbdate.hashCode());
		result = prime * result + (isdeal ? 1231 : 1237);
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
		Feedback other = (Feedback) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (fbdate == null) {
			if (other.fbdate != null)
				return false;
		} else if (!fbdate.equals(other.fbdate))
			return false;
		if (isdeal != other.isdeal)
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
		return userid + "。" + content + "。" + fbdate + "。" + isdeal;
	}

}
