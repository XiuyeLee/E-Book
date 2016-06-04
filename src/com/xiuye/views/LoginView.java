package com.xiuye.views;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.xiuye.logger.Logger;
import com.xiuye.service.UserService;


@ManagedBean
@RequestScoped
public class LoginView {

	private Logger log = Logger.getLogger(LoginView.class);
	
	@ManagedProperty("#{userService}")
	private UserService userService;
	
	private boolean remember = false;

	public boolean isRemember() {
		return remember;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
		log.info("是否记住密码:"+remember);
		log.info(""+userService);
	}
	
	
	
}
