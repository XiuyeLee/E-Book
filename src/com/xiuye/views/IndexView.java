package com.xiuye.views;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.xiuye.bean.AllThemes;
import com.xiuye.logger.Logger;
import com.xiuye.orm.User;
import com.xiuye.service.OnlineUserService;
import com.xiuye.service.UserService;



@ManagedBean(name="indexView")
@RequestScoped
public class IndexView{
	
	private User user;
	
	private String category="所有书籍";
	
	@ManagedProperty("#{onlineUserService}")
	private OnlineUserService onlineUserService;
	
	@ManagedProperty("#{userService}")
	private UserService userService;

	
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setOnlineUserService(OnlineUserService onlineUserService) {
		this.onlineUserService = onlineUserService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if(session == null){
			return null;
		}
		user = (User) session.getAttribute("user");
		/**
		 * JSF的机制可能会保证user序列化到磁盘
		 * indexView 也许能持久化
		 * 如果其user还在，就保存到session中因为重启服务器可能会丢失
		 * 内容，下面机制保证再次取到，再保存在session中
		 */
		if(user != null){
			log.info("当前会话中的用户还在线:"+user);
			//session.setAttribute("user", user);
			return user;
		}
		
		
		log.info("当前的会话的sessionid:" + session.getId() +" 其长度:" + session.getId().length());
		if(user == null){			
			String userid = onlineUserService.getOnlineUseridBySession(session);			
			user = userService.getUserByUserid(userid);
			log.info("重新取出在线用户:"+user);			
		}
		/**
		 * 经过再次确认把数据库在线user保存在session中供页面
		 * 调用
		 */
		if(user != null){
			session.setAttribute("user", user);
		}
		log.info("当前浏览器有没有用户在线:"+(user==null?"否":"用户id:"+ user.getUserid() +" 用户名:"+user.getUsername() + " 在线"));
		return user;
	}

	public String exit(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		User user = (User) session.getAttribute("user");
		//删除数据库中的在线用户
		int effectRows = this.onlineUserService.cancelOnlineUserByUserid(user);
		log.info(effectRows>=1?"在线用户退出"+user:"没有用户退出");		
		user = null;
		session.setAttribute("user", user);	
		
		return "/index";
		
		
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
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		//保证主题一致 因为requestscope周期不太清楚
		currentTheme = (String) session.getAttribute("theme");
		
		if(currentTheme == null){
			this.currentTheme = AllThemes.DEFAULT_THEME;			
		}
		return currentTheme;
	}

	public void setCurrentTheme(String currentTheme) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		this.currentTheme = currentTheme;
		session.setAttribute("theme", this.currentTheme);
		log.info("当前的主题:"+currentTheme);
				
	}

		
	public String personInfo(){
		
		return "/pages/userinfo";
		
	}
	
	public String managerInfo(){
		ManagerView.tabTitle = "图书管理";
		return "/pages/manager";
	}

	public void getValue(String value){
		log.info("得到值:"+value);
	}
	
}
