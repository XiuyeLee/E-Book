package com.xiuye.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.xiuye.logger.Logger;

public class OpenSourceSessionListener implements HttpSessionListener {

	private Logger log = Logger.getLogger(OpenSourceSessionListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		log.info("session created!");
		
		
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

		log.info("session destroyed!");
		
	}

}
