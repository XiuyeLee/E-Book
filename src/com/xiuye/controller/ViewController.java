package com.xiuye.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiuye.logger.Logger;
import com.xiuye.orm.Book;
import com.xiuye.orm.User;
import com.xiuye.orm.UserFavoriteBook;
import com.xiuye.service.BookService;
import com.xiuye.service.OnlineUserService;
import com.xiuye.service.ReadingHistoryService;
import com.xiuye.service.UserFavoriteBookService;

@Controller
public class ViewController {

	private static Logger log = Logger.getLogger(ViewController.class);

	@Resource
	private OnlineUserService onlineUserService;
	@Resource
	private BookService bookService;

	@Resource
	private ReadingHistoryService readingHistoryService;

	@Resource
	private UserFavoriteBookService ufbService;

	@RequestMapping("/currentTheme.do")
	@ResponseBody
	public String theme(HttpSession session) {
		String theme = (String) session.getAttribute("theme");
		if (theme == null) {
			theme = "swanky-purse";
			session.setAttribute("theme", theme);
		}
		return theme;
	}

	@RequestMapping("loginOut.do")
	@ResponseBody
	public void loginOut(HttpSession session) {

		User user = (User) session.getAttribute("user");

		// 删除数据库中的在线用户
		int effectRows = this.onlineUserService.cancelOnlineUserByUserid(user);

		log.info(effectRows >= 1 ? "在线用户退出" + user : "没有用户退出");
		user = null;
		session.setAttribute("user", user);
	}

	@RequestMapping("/readBook.do")
	@ResponseBody
	public void readBook(String bookid, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {

		User user = (User) session.getAttribute("user");
		Book book = this.bookService.getBookByBookid(bookid);
		if (book == null) {
			return;
		}
		String bookpath = book.getPath();
		// int beginIndex = bookpath.lastIndexOf(File.separator);
		// int endIndex = bookpath.lastIndexOf(".");
		//
		// String filename = bookpath.substring(beginIndex + 1, endIndex);
		// // System.out.println(filename);
		// String suffix = bookpath.substring(endIndex);
		// if (suffix != null && suffix.length() >= 2) {
		// suffix = suffix.toLowerCase();
		// if (suffix.contains("pdf")) {
		// filename += ".pdf";
		// } else if (suffix.contains("txt")) {
		// filename += ".txt";
		// } else if (suffix.contains("html"))
		// filename += ".html";
		// }
		//
		// try {
		// filename = URLEncoder.encode(filename, "UTF-8");
		// } catch (UnsupportedEncodingException e1) {
		// e1.printStackTrace();
		// }
		// log.info("文件名:" + filename);
		// response.setHeader("Content-Disposition", "attachment;filename="
		// + filename);

		BufferedInputStream bis = null;
		FileInputStream fis = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream(bookpath);
			bis = new BufferedInputStream(fis);

			int length = bis.available();
			log.info("阅读文件大小:" + length + "字节(B)");

			if (user == null) {
				length = length / 100;
				log.info("用户不在线阅读文件大小:" + length + "字节(B)");
			}

			response.setContentLength(length);

			bos = new BufferedOutputStream(response.getOutputStream());
			int i = 0;

			byte[] data = new byte[1024];
			while (bis.read(data) != -1) {

				bos.write(data);

				bos.flush();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				bis.close();
				// 不要关闭服务器输出，否则出错

			} catch (IOException e) {
			}
		}

		int effectRows = 0;

		if (user != null) {
			UserFavoriteBook ufBook = new UserFavoriteBook();
			ufBook.setBookid(bookid);
			ufBook.setUserid(user.getUserid());
			effectRows = this.ufbService.addUserBookReadtimes(ufBook);
			log.info("用户增加阅读次数:" + effectRows + "次");
		}

		effectRows = this.bookService.addReadtime(book);
		log.info("总阅读次数加" + effectRows + "次");
	}

	@RequestMapping("/downloadBook.do")
	@ResponseBody
	public void downloadBook(String bookid, HttpServletResponse response,
			HttpServletRequest request) {

		Book book = this.bookService.getBookByBookid(bookid);
		if (book == null) {
			return;
		}
		String bookpath = book.getPath();
		int beginIndex = bookpath.lastIndexOf(File.separator);
		int endIndex = bookpath.lastIndexOf(".");

		String filename = bookpath.substring(beginIndex + 1, endIndex);
		// System.out.println(filename);
		String suffix = bookpath.substring(endIndex);
		if (suffix != null && suffix.length() >= 2) {
			suffix = suffix.toLowerCase();
			if (suffix.contains("pdf")) {
				filename += ".pdf";
			} else if (suffix.contains("txt")) {
				filename += ".txt";
			} else if (suffix.contains("html"))
				filename += ".html";
		}

		try {
			filename = URLEncoder.encode(filename, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		log.info("文件名:" + filename);
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);

		BufferedInputStream bis = null;
		FileInputStream fis = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream(bookpath);
			bis = new BufferedInputStream(fis);

			int length = bis.available();
			response.setContentLength(length);

			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] data = new byte[1024];
			while (bis.read(data) != -1) {
				bos.write(data);
				bos.flush();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				bis.close();
				// 不要关闭服务器输出，否则出错

			} catch (IOException e) {
			}
		}

	}

}
