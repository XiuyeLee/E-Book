package com.xiuye.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.xiuye.orm.Test;

@Repository
public interface TestDao {
	public List<Test> findAll();
}
