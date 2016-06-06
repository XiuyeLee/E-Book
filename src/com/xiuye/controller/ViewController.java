package com.xiuye.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ViewController {

	@RequestMapping("currentTheme.do")
	@ResponseBody
	public String theme(HttpSession session){
		String theme = (String) session.getAttribute("theme");
		if(theme == null){
			theme = "swanky-purse";
			session.setAttribute("theme", theme);
		}
		return theme;
	}
	
}
