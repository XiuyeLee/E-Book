package com.xiuye.views;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.xiuye.logger.Logger;


@ManagedBean
@RequestScoped
public class LoginView {

	private Logger log = Logger.getLogger(LoginView.class);
	
	private boolean remember = false;

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
		log.info("是否记住密码:"+remember);
	}
	
	
	
}
