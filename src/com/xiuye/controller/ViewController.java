package com.xiuye.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiuye.logger.Logger;
import com.xiuye.orm.User;
import com.xiuye.service.OnlineUserService;

@Controller
public class ViewController {

	private static Logger log = Logger.getLogger(ViewController.class);
	
	@Resource
	private OnlineUserService onlineUserService;
	
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

}
