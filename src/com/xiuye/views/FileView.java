package com.xiuye.views;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.xiuye.logger.Logger;
import com.xiuye.orm.User;
import com.xiuye.orm.UserFavoriteBook;
import com.xiuye.service.UserFavoriteBookService;

@ManagedBean
@RequestScoped
public class FileView {

	private static Logger log = Logger.getLogger(FileView.class);

	@ManagedProperty("#{userFavoriteBookService}")
	private UserFavoriteBookService userFavoriteBookService;

	private StreamedContent file;

	public void setUserFavoriteBookService(
			UserFavoriteBookService userFavoriteBookService) {
		this.userFavoriteBookService = userFavoriteBookService;
	}

	public StreamedContent getFile() {
		System.out.println(file.getName());
		return file;
	}

	public FileView() {

		InputStream stream = FacesContext.getCurrentInstance()
				.getExternalContext().getResourceAsStream("/");

		file = new DefaultStreamedContent(stream, "application/pdf", "exam.pdf");

	}

	public void downloadBook(String bookid) {

		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/E-Book/downloadBook.do?bookid=" + bookid);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void readBook(String bookid) {

		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/E-Book/readBook.do?bookid=" + bookid);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addFavoriteBook(String bookid) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		User user = (User) session.getAttribute("user");
		if (user == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("你还未登录，不能收藏"));
			return;
		}
		log.info("86:"+user);
		log.info("87:"+bookid);
		log.info("88:"+this.userFavoriteBookService);
		boolean repeat = this.userFavoriteBookService.checkRepeatFavoriteBook(
				bookid, user);
		if (!repeat) {

			UserFavoriteBook ufBook = new UserFavoriteBook();
			ufBook.setAddDate(new Date());
			ufBook.setBookid(bookid);
			ufBook.setUserid(user.getUserid());
			ufBook.setReadtimes(1);

			int effectRows = this.userFavoriteBookService
					.addFavoriteBook(ufBook);
			log.info("添加收藏:" + effectRows + "条");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("收藏成功!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("你已经收藏过该书,不能再收藏了!"));
		}
	}

}
