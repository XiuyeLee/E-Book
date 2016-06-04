package com.xiuye.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiuye.controller.ManagerController;


public class TestAnnotation {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ManagerController dao = ac.getBean(ManagerController.class);
		String str = dao.manager();
		System.out.println(str);
		
		
	}
	
}
