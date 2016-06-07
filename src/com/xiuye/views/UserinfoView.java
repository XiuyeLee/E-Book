package com.xiuye.views;


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


	public void setReadingHistoryService(ReadingHistoryService readingHistoryService) {
		this.readingHistoryService = readingHistoryService;
	}


	public List<ReadingHistoryBook> getReadHistoryBooks() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		User user = (User) session.getAttribute("user");
		readHistoryBooks = this.readingHistoryService.getUserReadingHistoryBooks(user);
		log.info("取到历史用户读书数据");
		return readHistoryBooks;
	}


	public void setReadHistoryBooks(List<ReadingHistoryBook> readHistoryBooks) {
		this.readHistoryBooks = readHistoryBooks;
	}
	


}
