package com.xiuye.service;



import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.xiuye.dao.TestDao;
import com.xiuye.orm.Test;


@ManagedBean
@SessionScoped
public class TestService {

	@ManagedProperty("#{testDao}")
	private TestDao dao;
	
	public List<Test> getAllTest(){
		
		return dao.findAll();
		
	}

	public void setDao(TestDao dao) {
		this.dao = dao;
	}
	
	
	
	
	
}
