package com.xiuye.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.xiuye.bean.FavoriteBook;
import com.xiuye.bean.ReadingHistoryBook;
import com.xiuye.logger.Logger;
import com.xiuye.orm.User;
import com.xiuye.service.ReadingHistoryService;
import com.xiuye.service.UserFavoriteBookService;

@ManagedBean
@SessionScoped
public class UserinfoView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5659432281968130360L;

	private static Logger log = Logger.getLogger(UserinfoView.class);

	@ManagedProperty("#{readingHistoryService}")
	private ReadingHistoryService readingHistoryService;

	@ManagedProperty("#{userFavoriteBookService}")
	private UserFavoriteBookService ufBookService;

	private List<ReadingHistoryBook> readHistoryBooks;

	private List<ReadingHistoryBook> readHistorySearchedBooks;

	private List<FavoriteBook> favoriteBooks;

	private List<FavoriteBook> favoriteSearchBooks;

	private boolean historyOrFavorite = false;

	private boolean search = false;

	private String searchContent;

	public void setUfBookService(UserFavoriteBookService ufBookService) {
		this.ufBookService = ufBookService;
	}

	
	public String managerInfo(){
		
		ManagerView.tabTitle = "图书管理";
		return "/pages/manager";
				
		
	}
	
	public List<FavoriteBook> getFavoriteBooks() {

		if (search) {
			return this.favoriteSearchBooks;
		}

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		User user = (User) session.getAttribute("user");

		this.favoriteBooks = this.ufBookService.getFavoriteBooks(user);

		log.info("读取到用户收藏图书数据");

		return favoriteBooks;
	}

	public void setFavoriteBooks(List<FavoriteBook> favoriteBooks) {

		this.favoriteBooks = favoriteBooks;
	}

	public List<FavoriteBook> getFavoriteSearchBooks() {
		return favoriteSearchBooks;
	}

	public void setFavoriteSearchBooks(List<FavoriteBook> favoriteSearchBooks) {
		this.favoriteSearchBooks = favoriteSearchBooks;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public boolean isHistoryOrFavorite() {
		return historyOrFavorite;
	}

	public void setHistoryOrFavorite(boolean historyOrFavorite) {
		this.historyOrFavorite = historyOrFavorite;
	}

	public List<ReadingHistoryBook> getReadHistorySearchedBooks() {
		return readHistorySearchedBooks;
	}

	public void setReadHistorySearchedBooks(
			List<ReadingHistoryBook> readHistorySearchedBooks) {
		this.readHistorySearchedBooks = readHistorySearchedBooks;
	}

	public void setReadingHistoryService(
			ReadingHistoryService readingHistoryService) {
		this.readingHistoryService = readingHistoryService;
	}

	public List<ReadingHistoryBook> getReadHistoryBooks() {

		if (search) {
			return readHistorySearchedBooks;
		}

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		User user = (User) session.getAttribute("user");
		readHistoryBooks = this.readingHistoryService
				.getUserReadingHistoryBooks(user);

		log.info("取到历史用户读书数据:" + readHistoryBooks.size() + "条");
		// for(ReadingHistoryBook r : readHistoryBooks){
		// log.info("书籍的名字:"+r.getBook().getBookname());
		// }

		return readHistoryBooks;
	}

	public void setReadHistoryBooks(List<ReadingHistoryBook> readHistoryBooks) {
		this.readHistoryBooks = readHistoryBooks;
	}

	public void lookAtHistoryBooks() {
		this.historyOrFavorite = true;
		this.search = false;
	}

	public void lookAtFavoriteBooks() {
		this.historyOrFavorite = false;
		this.search = false;
	}

	public void deleteFavoriteBook(FavoriteBook fb) {

		if(fb == null){
			return;
		}
		log.info(fb.toString());
		
		this.ufBookService.deleteUserFavoriteBook(fb);
		

	}

	public void search() {
		if (this.searchContent == null || this.searchContent != null
				&& searchContent.isEmpty()) {
			this.search = false;
			return;
		}
		if (this.historyOrFavorite) {
			// 清除多余的
			Iterator<ReadingHistoryBook> it = this.readHistorySearchedBooks
					.iterator();
			while (it.hasNext()) {

				ReadingHistoryBook rhBook = it.next();
				String searchData = rhBook.toString();
				if (!searchData.toLowerCase().trim()
						.contains(this.searchContent.toLowerCase().trim())) {
					it.remove();
				}

			}
		} else {
			Iterator<FavoriteBook> it2 = this.favoriteSearchBooks.iterator();
			while (it2.hasNext()) {
				FavoriteBook fb = it2.next();
				String searchData = fb.toString();
				if (!searchData.toLowerCase().trim()
						.contains(this.searchContent.toLowerCase().trim())) {
					it2.remove();
				}
			}

		}
		search = true;
	}

	public List<String> completeMethod(String query) {

		if (readHistorySearchedBooks == null) {
			this.readHistorySearchedBooks = new ArrayList<ReadingHistoryBook>();
		}
		if(favoriteSearchBooks == null){
			this.favoriteSearchBooks = new ArrayList<FavoriteBook>();
		}
		if (!this.readHistorySearchedBooks.isEmpty()) {
			this.readHistorySearchedBooks.clear();
		}
		if(!favoriteSearchBooks.isEmpty()){
			this.favoriteSearchBooks.clear();
		}
		
		log.info(query);
		log.info(this.historyOrFavorite + "");
		List<String> list = new ArrayList<String>();
		if (this.historyOrFavorite) {//历史
			for (ReadingHistoryBook rhBook : readHistoryBooks) {
				String temp = rhBook.toString();
				String[] readBookData = temp.split("。");
				for (String s : readBookData) {
					// log.info(s);
					if (s != null
							&& !s.isEmpty()
							&& s.toLowerCase().toLowerCase().trim()
									.contains(query.toLowerCase().trim())) {
						this.readHistorySearchedBooks.add(rhBook);
						list.add(s);
						break;
					}
				}
			}
		} else {//收藏

			for (FavoriteBook fBook : this.favoriteBooks) {
				String temp = fBook.toString();
				String[] fBookData = temp.split("。");
				for (String s : fBookData) {
					// log.info(s);
					if (s != null
							&& !s.isEmpty()
							&& s.toLowerCase().toLowerCase().trim()
									.contains(query.toLowerCase().trim())) {
						this.favoriteSearchBooks.add(fBook);
						list.add(s);
						break;
					}
				}
			}

		}
		return list;

	}
}
