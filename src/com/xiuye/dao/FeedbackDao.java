package com.xiuye.dao;

import java.util.List;

import com.xiuye.orm.Feedback;

public interface FeedbackDao {

	List<Feedback> findAll();
	
}
