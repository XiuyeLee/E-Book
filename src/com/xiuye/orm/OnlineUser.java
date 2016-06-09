package com.xiuye.orm;

import java.io.Serializable;
import java.util.Date;

public class OnlineUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5877496431046420774L;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdate == null) ? 0 : createdate.hashCode());
		result = prime * result
				+ ((deletedate == null) ? 0 : deletedate.hashCode());
		result = prime * result + saveminutes;
		result = prime * result
				+ ((sessionid == null) ? 0 : sessionid.hashCode());
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
		OnlineUser other = (OnlineUser) obj;
		if (createdate == null) {
			if (other.createdate != null)
				return false;
		} else if (!createdate.equals(other.createdate))
			return false;
		if (deletedate == null) {
			if (other.deletedate != null)
				return false;
		} else if (!deletedate.equals(other.deletedate))
			return false;
		if (saveminutes != other.saveminutes)
			return false;
		if (sessionid == null) {
			if (other.sessionid != null)
				return false;
		} else if (!sessionid.equals(other.sessionid))
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
		return userid + "。" + sessionid
				+ "。" + deletedate + "。" + createdate
				+ "。" + saveminutes;
	}
	
	
	
}
