package com.xiuye.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiuye.dao.BookDao;
import com.xiuye.dao.OnlineUserDao;
import com.xiuye.dao.TestDao;
import com.xiuye.dao.UserDao;
import com.xiuye.orm.OnlineUser;
import com.xiuye.orm.Test;
import com.xiuye.service.OnlineUserService;
import com.xiuye.views.LoginView;

public class TestMybatisDB {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		OnlineUserService onlineService = ac.getBean(OnlineUserService.class);
//		onlineService.validateOnlyOneUserOneBrowser();
//		
		OnlineUserDao onlineUserDao = ac.getBean(OnlineUserDao.class);

		
		
//		System.out.println(onlineUserDao);
		
//		List<OnlineUser> list = onlineUserDao.findOnlineUsersInSessionTimeout();
//		for(OnlineUser online : list){
//			System.out.println(online.getUserid()+":"+online.getSessionid());
//		}
//		
//		OnlineUser onlineUser = new OnlineUser();
//		
//		
//		System.out.println(onlineUserDao.findUseridBySessionid("555BCEC6244FB7ED377BCBEE248643FE"));

//		Date d = new Date();
//		onlineUser.setDeletedate(new Date(d.getTime()+24*60*60*1000*5));
//		onlineUser.setCreatedate(d);
//		onlineUser.setSaveminutes(7200);
//		onlineUser.setSessionid("555BCEC6244FB7ED377BCBEE248643FE");
//		onlineUser.setUserid("12101010423");
//				
//		int effectRows = onlineUserDao.insertSession(onlineUser);
//		
//		System.out.println(effectRows);
//		
//		TestDao dao = ac.getBean(TestDao.class);
//		List<Test> ts = dao.findAll();
//		System.out.println(ts);
		
		UserDao dao1 = ac.getBean(UserDao.class);
		System.out.println(dao1);
		
//		System.out.println(dao1.findUserByPhone("18381334381"));
//		System.out.println(dao1.findUserByUsername("xiuye"));
//		System.out.println(dao1.findUserByEmail("xiuye_engineer@outlook.com"));
		System.out.println(dao1.findUserByPhone(null));
//		System.out.println(dao1.findUserByUsername(null));
//		System.out.println(dao1.findUserByEmail(null));

		
		
//		System.out.println(dao1.findUserByUserid("12101010423"));
//		
//		BookDao dao2 = ac.getBean(BookDao.class);
//		System.out.println(dao2.findAll().get(0).getBookname());
//		
//		System.out.println(dao1.findUserByNameAndPasswd("xiuye", "123456"));
//		System.out.println(dao1.findUserByEmailAndPasswd("xiuye_engineer@outlook.com", "123456"));
//		System.out.println(dao1.findUserByPhoneAndPasswd("18381334381", "123456"));
		
		//jsf的类无法让spring管理
//		LoginView login = ac.getBean(LoginView.class);
//		
//		System.out.println(login);
		
	}
}
