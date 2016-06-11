package com.xiuye.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.xiuye.bean.AllThemes;
import com.xiuye.logger.Logger;
import com.xiuye.orm.Book;
import com.xiuye.orm.User;
import com.xiuye.service.BookService;
import com.xiuye.service.OnlineUserService;
import com.xiuye.service.UserService;

@ManagedBean(name = "indexView")
@RequestScoped
public class IndexView {

	private User user;

	private boolean[] search = null;

	private String category = "所有书籍";

	@ManagedProperty("#{onlineUserService}")
	private OnlineUserService onlineUserService;

	@ManagedProperty("#{userService}")
	private UserService userService;

	@ManagedProperty("#{bookService}")
	private BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	private List<Book> books;

	private List<Book> searchedBooks;

	@PostConstruct
	public void init() {

		books = this.bookService.getAllBooks();
		// 因为getBooks会被jsf页面掉2次所以设置search为2个boolean数组
		search = new boolean[2];
	}

	public List<Book> getSearchedBooks() {
		return searchedBooks;
	}

	public void setSearchedBooks(List<Book> searchedBooks) {
		this.searchedBooks = searchedBooks;
	}

	public List<Book> getBooks() {

		if (search[0] || search[1]) {
			log.info("执行getBooks:search:" + search);
			if (search[0]) {
				search[0] = false;
			} else {
				search[1] = false;
			}
			return books;
		}
		log.info("执行getBooks非分类搜索:search:" + search);
		books = this.bookService.getAllBooks();
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

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
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		if (session == null) {
			return null;
		}
		user = (User) session.getAttribute("user");
		/**
		 * JSF的机制可能会保证user序列化到磁盘 indexView 也许能持久化
		 * 如果其user还在，就保存到session中因为重启服务器可能会丢失 内容，下面机制保证再次取到，再保存在session中
		 */
		if (user != null) {
			log.info("当前会话中的用户还在线:" + user);
			// session.setAttribute("user", user);
			return user;
		}

		log.info("当前的会话的sessionid:" + session.getId() + " 其长度:"
				+ session.getId().length());
		if (user == null) {
			String userid = onlineUserService.getOnlineUseridBySession(session);
			user = userService.getUserByUserid(userid);
			log.info("重新取出在线用户:" + user);
		}
		/**
		 * 经过再次确认把数据库在线user保存在session中供页面 调用
		 */
		if (user != null) {
			session.setAttribute("user", user);
		}
		log.info("当前浏览器有没有用户在线:"
				+ (user == null ? "否" : "用户id:" + user.getUserid() + " 用户名:"
						+ user.getUsername() + " 在线"));
		return user;
	}

	public String exit() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		User user = (User) session.getAttribute("user");
		// 删除数据库中的在线用户
		int effectRows = this.onlineUserService.cancelOnlineUserByUserid(user);
		log.info(effectRows >= 1 ? "在线用户退出" + user : "没有用户退出");
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

	private String currentTheme;

	public String getCurrentTheme() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		// 保证主题一致 因为requestscope周期不太清楚
		currentTheme = (String) session.getAttribute("theme");

		if (currentTheme == null) {
			this.currentTheme = AllThemes.DEFAULT_THEME;
		}
		return currentTheme;
	}

	public void setCurrentTheme(String currentTheme) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		this.currentTheme = currentTheme;
		session.setAttribute("theme", this.currentTheme);
		log.info("当前的主题:" + currentTheme);

	}

	public String personInfo() {

		return "/pages/userinfo";

	}

	public String managerInfo() {
		ManagerView.tabTitle = "图书管理";
		return "/pages/manager";
	}

	public void getValue(String value) {
		log.info("得到值:" + value);
	}

	private static String[] PL;// 编程语言
	private static String[] PA;// 编程进阶
	private static String[] DL;// 开发库
	private static String[][] web;// web开发
	private static String[] JavaEE;
	private static String[] BF;// 前端
	private static String[] GD;// 游戏开发
	private static String[] DB;// 数据库
	private static String[][] OS;// 操作系统
	private static String[] Parallel;// 并发
	private static String[] Network;
	private static String[] Hardware;// 底层开发
	private static String[] PS;// 应用软件

	static {
		PL = new String[16];
		
		
	}

	public void allBooksByAllCategoty(String value) {

		String searchData = value.toLowerCase().trim();
		switch (searchData) {
		case "":
			break;
		default:
			break;
		}

	}

	public List<String> searching(String query){
		
		List<String> list = new ArrayList<String>();
		
		
		
		
		
		return list;
		
		
	}
	
	public void booksByCategory(String value) {

		books = this.bookService.getBooksByCategory(value);
		for (Book book : books) {
			log.info("找到分类书籍:" + book);
		}
		search[0] = true;
		search[1] = true;
		log.info("分类搜索:" + true);
	}

}
