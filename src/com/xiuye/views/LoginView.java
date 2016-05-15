package com.xiuye.views;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class LoginView {

	private boolean remember = false;

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}
	
	
	
}
