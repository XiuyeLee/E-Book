package com.xiuye.bean;

import org.springframework.stereotype.Component;


@Component
public class TestBean {
	
	private String username;
	private String password;
	
	
	public TestBean() {
		this.username="xiuye";
		this.password="123456";
	}
	public TestBean(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
