package com.xiuye.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiuye.dao.OnlineUserDao;
import com.xiuye.logger.Logger;
import com.xiuye.orm.OnlineUser;
import com.xiuye.orm.User;

@Service
public class OnlineUserService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4036457742507948054L;

	private static Logger log = Logger.getLogger(OnlineUserService.class);

	@Resource
	private OnlineUserDao onlineUserDao;

	public String getOnlineUseridBySession(HttpSession session) {

		return onlineUserDao.findUseridBySessionid(session.getId());

	}

	public OnlineUser getOnlineUserBySession(HttpSession session) {
		return onlineUserDao.findOnlineUserBySessionid(session.getId());
	}

	public List<OnlineUser> getAllOnlineUsers() {

		return onlineUserDao.findAll();

	}

	private List<OnlineUser> getAllTimeoutUsers() {
		return this.onlineUserDao.findOnlineUsersInSessionTimeout();
	}

	@Transactional
	public void clearNotExistsOnlineUser() {
		
		List<OnlineUser> list = this.getAllTimeoutUsers();
		for (OnlineUser onlineUser : list) {
			int effectRows = this.onlineUserDao
					.deleteOnlineUserByUserid(onlineUser.getUserid());
			log.info("删除无用在线用户记录(即用户的session失效记录):" + effectRows
					+ "行;删除无用在线用户id:" + onlineUser.getUserid());

		}

	}

	@Transactional
	public boolean validateOnlyOneUserOneBrowser(User user, HttpSession session) {

		OnlineUser onlineUser = this.onlineUserDao.findOnlineUserByUserid(user
				.getUserid());

		if (onlineUser == null) {
			log.info("用户新登录");
			return true;
		} else {
			if (onlineUser.getSessionid().equals(session.getId())) {
				log.info("用户上次登录过同一个浏览器");
				onlineUserDao.deleteOnlineUserByUserid(user.getUserid());
				return true;
			} else {
				onlineUserDao.deleteOnlineUserByUserid(user.getUserid());
				return false;
			}
		}

	}

	@Transactional
	public void addOnlineUser(User user, HttpSession session, long savedMinutes) {
		OnlineUser onlineUser = new OnlineUser();
		onlineUser.setUserid(user.getUserid());
		onlineUser.setSessionid(session.getId());
		Date createDate = new Date();//经过验证每次更新cookie，时间也会更新
		onlineUser.setCreatedate(createDate);
		onlineUser.setDeletedate(new Date(createDate.getTime() + savedMinutes
				* 60 * 1000));
		this.onlineUserDao.insertSession(onlineUser);
	}

	@Transactional
	public int cancelOnlineUserByUserid(User user){
		log.info("删除数据库中在线用户:"+user);
		if(user != null){
			return this.onlineUserDao.deleteOnlineUserByUserid(user.getUserid());
		}
		return 0;
	}
	
}
