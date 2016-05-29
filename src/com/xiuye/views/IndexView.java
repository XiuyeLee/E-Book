package com.xiuye.views;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.xiuye.beans.AllThemes;
import com.xiuye.logger.Logger;


@ManagedBean(name="indexView")
@SessionScoped
public class IndexView {

	private Logger log = Logger.getLogger(IndexView.class);
	
	
	private String currentTheme = AllThemes.DEFAULT_THEME;

	public String getCurrentTheme() {
		return currentTheme;
	}

	public void setCurrentTheme(String currentTheme) {
		this.currentTheme = currentTheme;
		log.info("当前的主题:"+currentTheme);
				
	}
	
	
}
