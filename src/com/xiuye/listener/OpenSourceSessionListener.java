package com.xiuye.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.xiuye.bean.AllThemes;
import com.xiuye.logger.Logger;

public class OpenSourceSessionListener implements HttpSessionListener {

	private Logger log = Logger.getLogger(OpenSourceSessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {

		//Logger.CLOSEINFO = true;
		se.getSession().setAttribute("theme", AllThemes.DEFAULT_THEME);
		
		log.info("SESSIONID:" + se.getSession().getId() + " session created!");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

		log.info("SESSIONID:"
				+ se.getSession().getId() + " session destroyed!");

	}

}
