package com.meiyun.service.logic;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import com.meiyun.core.Constants;
import com.meiyun.core.render.ErrorCodeList;
import com.meiyun.core.render.RestError;
import com.meiyun.core.session.SessionUtils;
import com.meiyun.model.User;

public class UserLogic {
	
	/**
	 * 用户登录
	 * @param loginUser
	 */
	public RestError userLogin(User loginUser, String password,
			HttpServletRequest request) {
		
		// 102：参数错误
		if (loginUser == null || StringUtils.isBlank(password.trim())) {
			return new RestError(ErrorCodeList.ERROR_102);
		}
		
		// 109：用户名或密码错误
		if (!DigestUtils.md5Hex(password.trim()).equalsIgnoreCase((loginUser.getPassword()))) {
			return new RestError(ErrorCodeList.ERROR_109);
		}
		
		// 登录成功
		SessionUtils.getInstance(request).set(Constants.LOGIN_USER, loginUser);
		return null;
	}

}
