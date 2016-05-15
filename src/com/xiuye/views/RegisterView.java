package com.xiuye.views;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class RegisterView {

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
