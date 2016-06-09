package com.xiuye.views;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import com.xiuye.logger.Logger;
import com.xiuye.orm.User;
import com.xiuye.service.UserService;

@ManagedBean
@ViewScoped
public class RegisterView {

	@ManagedProperty("#{userService}")
	private UserService userService;

	
	private User user;

	@PostConstruct
	public void init(){
		user = new User();
	}
	private static Logger log = Logger.getLogger(RegisterView.class);

	
	
	public User getUser() {
		return user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private boolean checkProtocol = true;

	public boolean isCheckProtocol() {
		return checkProtocol;
	}

	public void setCheckProtocol(boolean checkProtocol) {
		this.checkProtocol = checkProtocol;
	}

	public boolean checkAgreeProtocol() {

		if (this.checkProtocol) {
			return false;
		} else {
			return true;
		}

	}

	public String register() {

		String message = this.userService.checkUserIsRepeat(user);
		if (message != null) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(message));
			return null;
		}
		int effectRows = userService.insertUser(user);
		if (effectRows >= 1) {
			log.info("成功注册用户:" + user);
			user = new User();// 相当于清空user
			return "login";
		} else {
			user = new User();// 相当于清空user
			return null;
		}

	}
	
	public void clear(){
		user = new User();
	}

}
