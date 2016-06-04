package com.xiuye.views;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.xiuye.beans.TestBean;
import com.xiuye.orm.Test;
import com.xiuye.service.TestService;

@ManagedBean
@RequestScoped
public class TestView {

	//属性必须有相应的setter和getter
	@ManagedProperty("#{testBean}")//可以直接调用spring容器中的类
	private TestBean testBean;
	@ManagedProperty("#{testService}")
	private TestService testService;
	
	private String value;

	private List<Test> ts;
	
	@PostConstruct
	public void init(){
		ts = testService.getAllTest();
	}
	
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	public List<Test> getTs() {
		return ts;
	}

	public void setTs(List<Test> ts) {
		this.ts = ts;
	}

	public TestBean getTestBean() {
		return testBean;
	}

	public void setTestBean(TestBean testBean) {
		this.testBean = testBean;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
