package com.xiuye.views;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.xiuye.logger.Logger;
import com.xiuye.orm.User;
import com.xiuye.service.UserService;

@ManagedBean
@ViewScoped
public class ModifyUserInfoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6082450708871197059L;

	private static Logger log = Logger.getLogger(ModifyUserInfoView.class);

	@ManagedProperty("#{userService}")
	private UserService userService;

	private String oldPassword;
	private String newPassword;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void checkModifyPasswd() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);

		User user = (User) session.getAttribute("user");
		log.info("旧密码:" + oldPassword);
		log.info("新密码:" + newPassword);
		if (user == null) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("还未登录不能修改密码!"));
			return;
		}

		String msg = this.userService.checkUserOldPasswordCorrect(
				user.getUserid(), oldPassword);

		if (msg != null) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(msg));
			return;
		}

		

		int effectRows = this.userService.modifyPwd(user.getUserid(), newPassword);
		log.info("更新用户密码:" + effectRows + "条");
		if(effectRows >= 1){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("修改密码成功"));
		}

		this.newPassword = "";
		this.oldPassword = "";
	}

}
