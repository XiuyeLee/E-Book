package com.xiuye.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.xiuye.logger.Logger;

public class OpenSourceSessionListener implements HttpSessionListener {

	private Logger log = Logger.getLogger(OpenSourceSessionListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		log.info("session created!");
		
		HttpSession session = se.getSession();
		if(session.getAttribute("username") == null){
			session.setAttribute("username", "Welcome to OpenSourceBookstore!");
		
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

		log.info("session destroyed!");
		
	}

}
