package com.xiuye.service;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiuye.dao.UserDao;
import com.xiuye.logger.Logger;
import com.xiuye.orm.User;

@Service
public class UserService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4106557236366334532L;
	@Resource
	private UserDao userDao;

	private static Logger log = Logger.getLogger(UserService.class);

	public List<User> findAllUsers() {

		return userDao.findAll();

	}

	public User getUserByUserid(String userid) {

		return userDao.findUserByUserid(userid);

	}

	public String checkUserIsRepeat(User user) {
		if (user.getUsername() != null && !user.getUsername().isEmpty()) {
			User tempUser = userDao.findUserByUsername(user.getUsername());
			if (tempUser != null) {
				user.setUsername(null);
				return "用户名已被注册，请重新设置用户名";
			}
		}
		if (user.getEmail() != null && !user.getEmail().isEmpty()) {
			User tempUser = userDao.findUserByEmail(user.getEmail());
			if (tempUser != null) {
				user.setEmail(null);
				return "用户邮箱已经注册，请重新修改新的邮箱";
			}
		}
		/**
		 * 一定要对字符串进行非空验证，否者业务逻辑要出错。非常隐蔽
		 */
		if (user.getPhone() != null && !user.getPhone().isEmpty()) {
			User tempUser = userDao.findUserByPhone(user.getPhone());
			log.info("tmepUser: " + tempUser);
			if (tempUser != null) {
				user.setPhone(null);
				log.info("phone的值: " + user.getPhone());
				return "用户手机号已经注册，请输入新的手机号";
			}
		}
		// userDao
		return null;

	}

	@Transactional
	public int insertUser(User user) {

		user.setUserid(UUID.randomUUID().toString());
		int effectRows = userDao.insertOneUser(user);

		return effectRows;
	}

	@Transactional(readOnly = true)
	public User validate(String name, String password) {

		if (name != null && !name.isEmpty() && password != null
				&& !password.isEmpty()) {
			User user = userDao.findUserByPhoneAndPasswd(name, password);

			if (user != null) {
				return user;
			}
			user = userDao.findUserByEmailAndPasswd(name, password);
			if (user != null) {
				return user;
			}
			user = userDao.findUserByNameAndPasswd(name, password);
			if (user != null) {
				return user;
			}

		}
		return null;

	}

	@Transactional
	public int updateUser(User user) {
		if (user == null) {
			return 0;
		}
		return this.userDao.updateUser(user);
	}
	public int  deteleUser(User user){
		if (user == null) {
			return 0;
		}
		return this.userDao.deleteUserByUserId(user.getUserid());
	}

	public String getPasswordByUserid(String userid){
		
		return  this.userDao.findPasswordByUserid(userid);
		
	}
	
	public String checkUserOldPasswordCorrect(String userid,String oldPwd){
		
		String oldStr = this.getPasswordByUserid(userid);
		if(oldStr.equals(oldPwd)){
			return null;
		}
		else{
			return "输入旧密码错误";
		}
		
	}
	
	@Transactional
	public int modifyPwd(String userid,String password){
		
		if(userid == null){
			return 0;
		}
		return this.userDao.updateUserPwdByUserid(userid, password);
		
	}
}
