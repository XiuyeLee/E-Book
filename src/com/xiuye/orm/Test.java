package com.xiuye.orm;

public class Test {

	private Integer id;
	private String testname;
	private String desc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTestname() {
		return testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", testname=" + testname + ", desc=" + desc
				+ "]";
	}
	
	
	
}
