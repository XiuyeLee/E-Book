package com.xiuye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiuye.logger.Logger;

@Controller
public class ManagerController {
	private Logger log = Logger.getLogger(ManagerController.class);
	
	/**
	 * story：因为RequestMapping的包名import错了，所以注解没起作用哈，
	 * 记住包名，也会引发错误啊，如果写的是错误的。
	 * @return
	 */
	@RequestMapping("/manager.do")
	public String manager() {

		log.info("manager.do running");
		return "manager";

	}

}
