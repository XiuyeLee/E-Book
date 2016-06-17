package com.xiuye.views;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.faces.bean.ManagedBean;

import com.xiuye.util.EBookConstant;

@ManagedBean(name = "GIMView")
public class GraphicsImageManagementView {

	private String defaultImageUrl = EBookConstant.DEFAULT_IMAGE;

	public String getDefaultImageUrl() {
		return defaultImageUrl;
	}

	public void setDefaultImageUrl(String defaultImageUrl) {
		this.defaultImageUrl = defaultImageUrl;
	}

	public String bookCover(String cover) {

		if (cover == null || cover.isEmpty()) {
			return this.defaultImageUrl;
		}
		
	
		
		//System.out.println("GIMV Cover:编码前:"+cover);
		try {
			cover = URLEncoder.encode(cover,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//System.out.println("GIMV Cover:编码后:"+cover);
		return "bookCover.do?cover=" + cover;

	}

	public String bookCover2(String bookid) {
		if (bookid == null || bookid.isEmpty()) {
			return this.defaultImageUrl;
		}

		bookid = URLDecoder.decode(bookid);

		return "bookCover2.do?bookid=" + bookid;

	}

}
