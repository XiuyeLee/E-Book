package com.xiuye.views;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.xiuye.beans.ReadingHistoryBook;
import com.xiuye.logger.Logger;
import com.xiuye.orm.User;
import com.xiuye.service.ReadingHistoryService;

@ManagedBean
@RequestScoped
public class UserinfoView {

	private static Logger log = Logger.getLogger(UserinfoView.class);

	@ManagedProperty("#{readingHistoryService}")
	private ReadingHistoryService readingHistoryService;

	private List<ReadingHistoryBook> readHistoryBooks;

	private List<ReadingHistoryBook> readHistorySearchedBooks;

	private boolean historyOrFavorite = false;

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

	public void lookAtHistoryBooks(){
		this.historyOrFavorite = true;
	}
	
	public List<String> completeMethod(String query){
		
		List<String> list = new ArrayList<String>();
		
		list.add("123567890");
		list.add("456890");
		list.add("789123456");
		list.add("qwe1234567");
		list.add("tyu");
		
		return list;
		
	}
}
