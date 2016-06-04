package com.xiuye.views;

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

}
