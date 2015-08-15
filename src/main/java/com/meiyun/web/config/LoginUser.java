package com.meiyun.web.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.meiyun.core.ConstantEnum;
import com.meiyun.model.User;

/**
 * 登录用户
 * 
 * @author Administrator
 *
 */
public class LoginUser {

	/**
	 * 用户对象
	 */
	private User user;

	public LoginUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object loginUser = session.getAttribute(ConstantEnum.LOGIN_USER.getValue());
		user = (loginUser instanceof User) ? (User) loginUser : new User();
	}

	/**
	 * 获取登录用户
	 * 
	 * @param request
	 * @return
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * 获取登录用户ID
	 * @return
	 */
	public Integer getId() {
		return user.getId();
	}

}
