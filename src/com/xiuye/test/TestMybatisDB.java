package com.xiuye.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiuye.dao.BookDao;
import com.xiuye.dao.TestDao;
import com.xiuye.dao.UserDao;
import com.xiuye.orm.Test;
import com.xiuye.views.LoginView;

public class TestMybatisDB {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestDao dao = ac.getBean(TestDao.class);
		List<Test> ts = dao.findAll();
		System.out.println(ts);
		
		UserDao dao1 = ac.getBean(UserDao.class);
		System.out.println(dao1);
		System.out.println(dao1.findByUserid("231"));
		
		BookDao dao2 = ac.getBean(BookDao.class);
		System.out.println(dao2.findAll().get(0).getBookname());
		
		LoginView login = ac.getBean(LoginView.class);
		
		System.out.println(login);
		
	}
}
