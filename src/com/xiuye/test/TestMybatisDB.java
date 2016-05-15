package com.xiuye.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiuye.dao.TestDao;
import com.xiuye.orm.Test;

public class TestMybatisDB {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestDao dao = ac.getBean(TestDao.class);
		List<Test> ts = dao.findAll();
		System.out.println(ts);
		
	}
}
