package com.xiuye.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
		searchStrList = new ArrayList<String>();
		searchedBooks = new ArrayList<Book>();
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
	private static String[] AS;// 应用软件

	static {
		PL = new String[16];
		PL[0] = "C/C++";
		PL[1] = "Java";
		PL[2] = "C#";
		PL[3] = "Python";
		PL[4] = "JavaScript";
		PL[5] = "Objective-C";
		PL[6] = "Swift";
		PL[7] = "Nodejs";
		PL[8] = "Shell";
		PL[9] = "PHP";
		PL[10] = "ASP.NET";
		PL[11] = "Fortran";
		PL[12] = "Erlang";
		PL[13] = "VB";
		PL[14] = "Dephi";
		PL[15] = "Matlab";

		PA = new String[11];
		PA[0] = "PAMB";
		PA[1] = "CA";
		PA[2] = "JA";
		PA[3] = "DSAA";
		PA[4] = "DIA";
		PA[5] = "AI";
		PA[6] = "CD";
		PA[7] = "VC";
		PA[8] = "Math";
		PA[9] = "Physics";
		PA[10] = "English";

		DL = new String[7];
		DL[0] = "Boost";
		DL[1] = "MFC";
		DL[2] = "QT";
		DL[3] = "SWT";
		DL[4] = "OpenCV";
		DL[6] = "ICE";

		web = new String[2][];
		web[0] = new String[16];
		web[1] = new String[8];

		web[0][0] = "JavaEEBasic";
		web[0][1] = "Servlet";
		web[0][2] = "XML";
		web[0][3] = "Spring";
		web[0][4] = "MyBatis";
		web[0][5] = "Hibernate";
		web[0][6] = "Struts";
		web[0][7] = "JSF";
		web[0][8] = "JFinal";
		web[0][9] = "EJB";
		web[0][10] = "JNDI";
		web[0][11] = "JMS";
		web[0][12] = "RMI";
		web[0][13] = "JDBC";
		web[0][14] = "JavaMail";
		web[0][15] = "IDL/CORBA";

		JavaEE = web[0];

		web[1][0] = "Html";
		web[1][1] = "CSS";
		web[1][2] = "Ajax";
		web[1][3] = "JQuery";
		web[1][4] = "Boostrap";
		web[1][5] = "Angularjs";
		web[1][6] = "Reactjs";
		web[1][7] = "Extjs";

		BF = web[1];

		GD = new String[6];
		GD[0] = "GameBasic";
		GD[1] = "OpenGL";
		GD[2] = "DirectX";
		GD[3] = "Cocos2D";
		GD[4] = "Unity3D";
		GD[5] = "CryEngine";

		DB = new String[6];
		DB[0] = "Oracle";
		DB[1] = "Mysql";
		DB[2] = "SqlServer";
		DB[3] = "Sybase";
		DB[4] = "SQL";
		DB[5] = "BigData";

		OS = new String[2][];
		OS[0] = new String[9];
		OS[1] = new String[6];

		OS[0][0] = "Android";
		OS[0][1] = "Windows";
		OS[0][2] = "Linux";
		OS[0][3] = "Unix";
		OS[0][4] = "MacOS";
		OS[0][5] = "IPhone";
		OS[0][6] = "JVM";
		OS[0][7] = "CompilersPrinciples";
		OS[0][8] = "Media";

		OS[1][0] = "CPUParallel";
		OS[1][1] = "C++Parallel";
		OS[1][2] = "JavaParallel";
		OS[1][3] = "LinuxParallel";
		OS[1][4] = "WindowsParallel";
		OS[1][5] = "AndroidParallel";

		Parallel = OS[1];

		Network = new String[4];
		Network[0] = "NetworkBasic";
		Network[1] = "NetworkProtocol";
		Network[2] = "NetworkApplication";
		Network[3] = "NetworkProgram";

		Hardware = new String[5];
		Hardware[0] = "AssemblerBasic";
		Hardware[1] = "Intel";
		Hardware[2] = "Arm";
		Hardware[3] = "Driver";
		Hardware[4] = "Circuit";

		AS = new String[11];
		AS[0] = "PhotoShop";
		AS[1] = "Flash";
		AS[2] = "Dreamweaver";
		AS[3] = "Word";
		AS[4] = "Excel";
		AS[5] = "PPT";
		AS[6] = "Visio";
		AS[7] = "Xmind";
		AS[8] = "CAD";
		AS[9] = "3DMax";
		AS[10] = "PowerDesigner";

	}

	public void allBooksByAllCategoty(String value) {

		String searchData = value.trim();
		switch (searchData) {
		case "PLAll":// 编程语言
			log.info("搜索编程语言PLAll");
			books = this.bookService.getBooksByCategotyArray(PL);
			log.info("搜索编程语言全部书籍:"+books);
			break;
		case "PAAll"://编程进阶
			this.books = this.bookService.getBooksByCategotyArray(PA);
			break;
		case "DLAll"://开发库
			this.books = this.bookService.getBooksByCategotyArray(DL);
			break;
		case "WebAll"://Web开发
			books = new ArrayList<Book>();
			
			this.books.addAll(this.bookService.getBooksByCategotyArray(web[0]));
			this.books.addAll(this.bookService.getBooksByCategotyArray(web[1]));
			break;
		case "JavaEEBasic"://JavaEE
			
			this.books = this.bookService.getBooksByCategotyArray(JavaEE);
			break;
		case "BFAll"://浏览器前端
			this.books = this.bookService.getBooksByCategotyArray(BF);
			break;
		case "GameDevelopAll"://游戏开发
			this.books = this.bookService.getBooksByCategotyArray(GD);
			break;
		case "DBAll"://数据库
			this.books = this.bookService.getBooksByCategotyArray(DB);
			break;
		case "OSAll"://操作系统
			this.books = new ArrayList<Book>();
			this.books.addAll(this.bookService.getBooksByCategotyArray(OS[0]));
			this.books.addAll(this.bookService.getBooksByCategotyArray(OS[1]));
			break;
		case "ParallelAll"://并发|并行
			
			this.books = this.bookService.getBooksByCategotyArray(Parallel);
			
			break;
		case "NetworkAll"://网络

			this.books = this.bookService.getBooksByCategotyArray(Network);
			break;
		case "DiCengAll"://底层开发

			this.books = this.bookService.getBooksByCategotyArray(Hardware);
			break;
		case "ApplicationSoftwareAll"://应用软件
			this.books = this.bookService.getBooksByCategotyArray(AS);
			break;
		default:
			this.books = this.bookService.getAllBooks();
			break;
		}

		search[0] = true;
		search[1] = true;
	}

	private String searchContent = "";

	private List<String> searchStrList;

	public void search() {
		if (searchContent == null || this.searchContent.isEmpty()) {

			books = this.bookService.getAllBooks();
			return;

		}
		this.searchContent = this.searchContent.toLowerCase().trim();
		log.info("得到的搜索值是:" + this.searchContent);
		Iterator<Book> it = books.iterator();
		while (it.hasNext()) {
			Book b = it.next();
			String bStr = b.toString().toLowerCase().trim();
			if (bStr.contains(searchContent)) {

				continue;
			}

			it.remove();

		}
		this.searchContent = "";
		log.info("搜索完毕!");
		search[0] = true;
		search[1] = true;
	}

	public List<String> searching(String query) {

		log.info("正在搜索:" + query);
		this.searchedBooks.clear();

		if (query == null || query.isEmpty()) {
			return this.searchStrList;
		}
		query = query.toLowerCase().trim();
		log.info("所有书籍数组:" + books);
		for (Book book : books) {
			String[] split = book.toString().split("。");
			for (String s : split) {
				log.info("拆分子串为:" + s + "-------------");
			}
			log.info("拆分:" + split);
			for (String s : split) {
				String ts = s.toLowerCase().trim();
				if (ts.contains(query)) {

					this.searchStrList.add(s);
					this.searchedBooks.add(book);

					break;
				}
			}

		}
		books.clear();
		books.addAll(searchedBooks);
		return this.searchStrList;

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

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

}
