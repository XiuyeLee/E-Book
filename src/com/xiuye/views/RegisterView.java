package com.xiuye.views;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.xiuye.service.UserService;

@ManagedBean
@RequestScoped
public class RegisterView {

	@ManagedProperty("#{userService}")
	private UserService userService;
	
	//private 
	
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
	
	public boolean checkAgreeProtocol(){
		
		if(this.checkProtocol){
			return false;
		}
		else{
			return true;
		}
		
	}

	
	
	
}
