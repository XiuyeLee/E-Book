package com.xiuye.views;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.xiuye.logger.Logger;
import com.xiuye.orm.User;
import com.xiuye.service.UserService;

@ManagedBean
@SessionScoped
public class LoginView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4402115331782179736L;

	private Logger log = Logger.getLogger(LoginView.class);

	@ManagedProperty("#{userService}")
	private UserService userService;

	private String name;
	private String password;

	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private boolean remember = false;

	public boolean isRemember() {
		return remember;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;

		log.info("是否记住密码:" + remember);

		// log.info(""+userService);
	}

	public String validateUserAccount() {

		user = userService.validate(name, password);
		
		if (user != null) {
			
			
			if (this.remember) {
				// 强制转换以最后方法为准
				HttpSession session = (HttpSession) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSession(false);
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(7200);
			}
			return "index";
			
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("账号或者密码错误"));
			return "login";
			
		}

	}

}
