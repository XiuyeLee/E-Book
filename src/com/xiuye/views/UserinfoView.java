package com.xiuye.views;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.xiuye.bean.ReadingHistoryBook;
import com.xiuye.logger.Logger;
import com.xiuye.orm.User;
import com.xiuye.service.ReadingHistoryService;

@ManagedBean
@SessionScoped
public class UserinfoView {

	private static Logger log = Logger.getLogger(UserinfoView.class);

	@ManagedProperty("#{readingHistoryService}")
	private ReadingHistoryService readingHistoryService;

	private List<ReadingHistoryBook> readHistoryBooks;

	private List<ReadingHistoryBook> readHistorySearchedBooks;

	private boolean historyOrFavorite = false;

	private boolean search = false;

	private String searchContent;

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

	public void search(){
		if(this.searchContent == null || this.searchContent !=null && searchContent.isEmpty()){
			this.search = false;
		}
		Iterator<ReadingHistoryBook> it = this.readHistorySearchedBooks.iterator();
		while(it.hasNext()){
			
			ReadingHistoryBook rhBook = it.next();
			String searchData = rhBook.toString();
			if(!searchData.toLowerCase().trim().contains(this.searchContent.toLowerCase().trim())){
				it.remove();
			}
			
		}
		
		search = true;		
	}
	
	
	public List<String> completeMethod(String query) {

		if(readHistorySearchedBooks == null){
			this.readHistorySearchedBooks = new ArrayList<ReadingHistoryBook>();
		}
		if(!this.readHistorySearchedBooks.isEmpty()){
			this.readHistorySearchedBooks.clear();
		}
		log.info(query);
		log.info(this.historyOrFavorite+"");
		List<String> list = new ArrayList<String>();
		if (this.historyOrFavorite) {
			for (ReadingHistoryBook rhBook : readHistoryBooks) {
				String temp = rhBook.toString();
				String[] readBookData = temp.split("。");
				for (String s : readBookData) {
					//log.info(s);
					if(s!= null && !s.isEmpty() && s.toLowerCase().toLowerCase().trim().contains(query.toLowerCase().trim()))
					{
						this.readHistorySearchedBooks.add(rhBook);
						list.add(s);
					}
				}
			}
		} else {

		}
		return list;

	}
}
