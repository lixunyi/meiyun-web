package com.meiyun.service;

import com.meiyun.model.User;
import com.meiyun.service.core.BaseService;

/**
 * 用户 Service
 * 
 * @author Administrator
 *
 */
public interface UserService extends BaseService<User, Integer> {
	
	/**
	 * 用户登录查询
	 * @param user：name, email, mobile
	 * @return
	 * @throws Exception
	 */
	User queryLogin(User user) throws Exception;

}
