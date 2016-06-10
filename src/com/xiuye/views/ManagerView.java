package com.xiuye.views;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.UploadedFile;

import com.xiuye.logger.Logger;
import com.xiuye.orm.Book;
import com.xiuye.orm.User;
import com.xiuye.service.BookService;
import com.xiuye.service.UserService;

@ManagedBean
@SessionScoped
public class ManagerView implements Serializable {

	private static Logger log = Logger.getLogger(ManagerView.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -3990349499570210882L;

	@ManagedProperty("#{bookService}")
	private BookService bookService;

	@ManagedProperty("#{userService}")
	private UserService userService;

	private boolean search = false;

	private List<User> users;

	private UploadedFile file;

	private Book addBook;

	private List<Book> books;

	private Book selectedBook;

	private User selectedUser;

	private boolean on = false;

	public static String tabTitle = "图书管理";

	private List<User> searchedUsers;

	private List<Book> searchedBooks;

	private String searchContent;

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public User getSelectedUser() {
		if (this.selectedUser == null) {
			this.selectedUser = new User();
		}

		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {

		this.selectedUser = selectedUser;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void onTabChange(TabChangeEvent e) {

		this.tabTitle = e.getTab().getTitle();
		log.info("当前的tab:" + tabTitle);

	}

	private String tab = "books";

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public void executeQuery() {

		if (this.searchContent == null || this.searchContent.isEmpty()) {
			return;
		}

		log.info("开始搜索");
		log.info("129:" + this.searchContent);

		for (Book b : this.searchedBooks) {

			System.out.println("150:" + b);

		}

	}

	public List<String> search(String query) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		List<String> list = new ArrayList<String>();
		this.searchedBooks.clear();
		this.searchedUsers.clear();
		this.searchContent = "";
		this.searchContent = query;
		boolean add = false;
		log.info("159:" + query);
		if ("图书管理".equalsIgnoreCase(tabTitle)) {

			for (Book b : books) {
				if (b.getBookid().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(b.getBookid());
				}
				if (b.getAuthor().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(b.getAuthor());
				}
				if (b.getBookname().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(b.getBookname());
				}
				if (b.getCategory().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(b.getCategory());
				}
				if (b.getCover().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(b.getCover());
				}
				if (b.getPublishhouse().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(b.getPublishhouse());
				}
				if (b.getSuffix().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(b.getSuffix());
				}
				// if (b.getSummary().toLowerCase().trim()
				// .contains(query.toLowerCase().trim())) {
				// add = true;
				// list.add(b.getSummary());
				// }
				if (format.format(b.getPublishdate()).toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(format.format(b.getPublishdate()));
				}
				if (add) {
					this.searchedBooks.add(b);
					add = false;

				}

			}
			tab = "books";

		} else if ("用户信息".equalsIgnoreCase(tabTitle)) {
			for (User user : users) {

				if (user.getUsername().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(user.getUsername());
				}
				if (user.getUserid().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(user.getUserid());
				}

				if (format.format(user.getBirthday()).toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(format.format(user.getBirthday()));
				}
				if (user.getEmail().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(user.getEmail());
				}
				if (user.getPassword().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(user.getPassword());
				}
				if (user.getPhone().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(user.getPhone());
				}
				if (user.getQq().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(user.getQq());
				}
				if (user.getSex().toLowerCase().trim()
						.contains(query.toLowerCase().trim())) {
					add = true;
					list.add(user.getSex());
				}

				if (add) {
					add = false;
					this.searchedUsers.add(user);

				}

			}

			tab = "users";
		}
		search = true;

		return list;

	}

	
	@PostConstruct
	public void init() {

		addBook = new Book();
		selectedBook = new Book();
		books = this.bookService.getAllBooks();
		users = this.userService.findAllUsers();
		this.searchedBooks = new ArrayList<Book>();
		this.searchedUsers = new ArrayList<User>();
		this.searchContent = "";
		this.tabTitle = "图书管理";

	}

	public List<User> getUsers() {
		if (this.searchContent != null && !this.searchContent.isEmpty()
				&& !this.searchedUsers.isEmpty()) {
			Iterator<User> i = this.searchedUsers.iterator();
			while (i.hasNext()) {

				User user = i.next();
				if (!user.toString().toLowerCase().trim()
						.contains(this.searchContent.toLowerCase().trim())) {
					i.remove();
				}

			}
			this.search = false;
			
			return this.searchedUsers;
		} else {
			users = this.userService.findAllUsers();
		}
		return users;
	}

	public void onCellEdit(CellEditEvent e) {

		log.info(e.getOldValue() + "");
		log.info(e.getNewValue() + "");

	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getAllUsers() {

		return this.userService.findAllUsers();
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
		log.info(file.getFileName());
	}

	public Book getAddBook() {
		return addBook;
	}

	public void setAddBook(Book addBook) {
		this.addBook = addBook;

	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public List<Book> getBooks() {

		
		if (this.searchContent != null && !this.searchContent.isEmpty()
				&& !this.searchedBooks.isEmpty()) {

			log.info("350:" + this.searchContent);
			Iterator<Book> it = this.searchedBooks.iterator();
			while (it.hasNext()) {
				Book b = it.next();
				if (!b.toString().toLowerCase().trim()
						.contains(searchContent.toLowerCase().trim())) {
					log.info("清除多余书籍");
					it.remove();
				}
			}
			search = false;
			//searchContent = "";
			log.info("返回搜索书籍");

			log.info(this.searchedBooks.toString());

			return this.searchedBooks;
		} else {
			books = bookService.getAllBooks();
		}
		for(Book b : books){
			System.out.println("366:"+b);
		}
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void onRowEdit(RowEditEvent e) {

		log.info("这在编辑书籍:" + e.getObject());
		Book b = (Book) e.getObject();
		log.info(b + "");
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("正在进行书籍编辑"));

	}

	public void onRowCancel(RowEditEvent e) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("取消书籍编辑"));

	}

	public Book getSelectedBook() {
		if (this.selectedBook == null) {
			this.selectedBook = new Book();
			this.selectedBook.setAuthor("错误");
			this.selectedBook.setBookid("错误");
			this.selectedBook.setBookname("错误");
			this.selectedBook.setCategory("错误");
			this.selectedBook.setCover("错误");
			this.selectedBook.setPath("错误");
			this.selectedBook.setPublishhouse("错误");
			this.selectedBook.setReadsum(0);
			this.selectedBook.setSuffix("错误");
			this.selectedBook.setSummary("错误");
			this.selectedBook.setPublishdate(new Date());
		}
		return selectedBook;
	}

	public void setSelectedBook(Book selectedBook) {
		log.info("书籍选中了:" + selectedBook);
		this.selectedBook = selectedBook;
	}

	public void deleteBoook(Book book) {

		int effectRows = this.bookService.deleteBook(book);
		log.info("删除书籍数据:" + effectRows + "条");

	}

	public void addBook() {

		int effectRows = this.bookService.addBook(this.addBook);
		log.info("添加书籍:" + effectRows + "条");
		this.addBook = new Book();
	}

	public String modify() {

		log.info("确定修改");
		int effectRows = this.bookService.modifyBook(this.selectedBook);
		log.info("修改书籍数据:" + effectRows + "条");
		return "";

	}

	public String cancelModify() {

		log.info("取消修改");
		return "";
	}

	public void deleteUser(User user) {

		int effectRows = this.userService.deteleUser(user);
		log.info("删除用户数据:" + effectRows + "条");
	}

	public void modifyUser(User user) {

		int effectRows = this.userService.updateUser(user);
		log.info("更改用户数据:" + effectRows + "条");

	}

	public void openModifyUser(User user) {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);

		log.info("235 " + user);
		this.selectedUser = user;
		log.info("237 " + this.selectedUser);
		User onlineUser = (User) session.getAttribute("user");

		if (selectedUser != null && selectedUser.equals(onlineUser)) {
			on = true;
		} else {
			on = false;
		}

	}

	public void modifyUser() {
		log.info("修改用户:" + this.selectedUser);

		this.modifyUser(selectedUser);
	}

	public void testUser(User user) {

		log.info("保存用户信息:" + user);

	}

}
