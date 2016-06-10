package com.xiuye.views;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiuye.logger.Logger;
import com.xiuye.orm.User;
import com.xiuye.service.OnlineUserService;
import com.xiuye.service.UserService;

@ManagedBean
@RequestScoped
public class LoginView {

	
	
	private static Logger log = Logger.getLogger(LoginView.class);

	public UserService getUserService() {
		return userService;
	}

	public OnlineUserService getOnlineUserService() {
		return onlineUserService;
	}

	public void setOnlineUserService(OnlineUserService onlineUserService) {
		this.onlineUserService = onlineUserService;
	}

	@ManagedProperty("#{userService}")
	private UserService userService;
	@ManagedProperty("#{onlineUserService}")
	private OnlineUserService onlineUserService;
	

	private String name;
	private String password;

	private User user;

	//该方案是否是管理员弃用
//	private boolean isAdmin = false;
//
//	public boolean isAdmin() {
//		return isAdmin;
//	}
//
//	public void setAdmin(boolean isAdmin) {
//		this.isAdmin = isAdmin;
//	}

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
	}

	
	
	public String validateUserAccount() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		
		this.onlineUserService.clearNotExistsOnlineUser();		
		user = userService.validate(name, password);
		
		if (user != null) {
			boolean onlyone = this.onlineUserService.validateOnlyOneUserOneBrowser(user,session);
			if(!onlyone){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("尊敬的用户，您在不同的客户端登录，请注意"));
			}
			
			log.info("用户名:"+user.getUsername()+" 是否是管理员:"+user.isAdmin()+" 是否记住密码:" + this.remember);
			//可以直接user就可以判断在不在线。
			//session.setAttribute("online", true);
			//this.isAdmin = user.isAdmin();//这句可以不要的			
			session.setAttribute("user", user);		
			
			if (this.remember) {
				
				session.setMaxInactiveInterval(24*60*60*5);//单位:s
				this.persistenceClientSession(response, session, 24*60*60*5);
				this.onlineUserService.addOnlineUser(user, session, 24*60*5L);
				log.info("保存在线记住密码的账户:"+user.getUsername());
				
			}else{
				session.setMaxInactiveInterval(5*60);
				this.persistenceClientSession(response, session, 5*60);
				this.onlineUserService.addOnlineUser(user, session, 5);
				log.info("保存在线不记住密码的账户:"+user.getUsername());				
			}
			return "/index";
			
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("账号或者密码错误"));
			return "login";
			
		}

	}
	
	private void persistenceClientSession(HttpServletResponse response,HttpSession session,int savedSeconds){
		
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setPath("/E-Book/");
		cookie.setMaxAge(savedSeconds);//单位:s
		response.addCookie(cookie);
	}
}
