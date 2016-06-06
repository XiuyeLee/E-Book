package com.xiuye.views;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.xiuye.beans.AllThemes;
import com.xiuye.logger.Logger;
import com.xiuye.orm.User;
import com.xiuye.service.OnlineUserService;
import com.xiuye.service.UserService;



@ManagedBean(name="indexView")
@RequestScoped
public class IndexView{

	

	
	private User user;
	
	@ManagedProperty("#{onlineUserService}")
	private OnlineUserService onlineUserService;
	
	@ManagedProperty("#{userService}")
	private UserService userService;

	public void setOnlineUserService(OnlineUserService onlineUserService) {
		this.onlineUserService = onlineUserService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		/**
		 * JSF的机制可能会保证user序列化到磁盘
		 */
		if(user != null){
			log.info("当前会话中的用户还在线:"+user);
			return user;
		}
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if(session == null){
			return null;
		}
		user = (User) session.getAttribute("user");
		log.info("当前的会话的sessionid:" + session.getId() +" 其长度:" + session.getId().length());
		if(user == null){			
			String userid = onlineUserService.getOnlineUseridBySession(session);			
			user = userService.getUserByUserid(userid);
			log.info("重新取出在线用户:"+user);			
		}
		log.info("当前浏览器有没有用户在线:"+(user==null?"否":"用户id:"+ user.getUserid() +" 用户名:"+user.getUsername() + " 在线"));
		return user;
	}

	public OnlineUserService getOnlineUserService() {
		return onlineUserService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private static Logger log = Logger.getLogger(IndexView.class);
	
	
	private  String currentTheme;

	public String getCurrentTheme() {
		if(currentTheme == null){
			this.currentTheme = AllThemes.DEFAULT_THEME;
		}
		return currentTheme;
	}

	public void setCurrentTheme(String currentTheme) {
		this.currentTheme = currentTheme;
		log.info("当前的主题:"+currentTheme);
				
	}

		
	public String personInfo(){
		
		return "/WEB-INF/pages/userinfo.jsf";
		
	}
	
	public String managerInfo(){
		return "/WEB-INF/pages/manager.jsf";
	}

}
