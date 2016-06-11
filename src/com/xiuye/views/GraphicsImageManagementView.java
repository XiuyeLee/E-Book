package com.xiuye.views;

import java.net.URLEncoder;

import javax.faces.bean.ManagedBean;

import com.xiuye.util.EBookConstant;

@ManagedBean(name="GIMView")
public class GraphicsImageManagementView {

	private String defaultImageUrl = EBookConstant.DEFAULT_IMAGE;

	public String getDefaultImageUrl() {
		return defaultImageUrl;
	}

	public void setDefaultImageUrl(String defaultImageUrl) {
		this.defaultImageUrl = defaultImageUrl;
	}

	public String bookCover(String cover){
		
		if(cover== null || cover.isEmpty()){
			return this.defaultImageUrl;
		}
		
		cover = URLEncoder.encode(cover);
		
		return "bookCover.do?cover="+cover;
		
	}
	
}
