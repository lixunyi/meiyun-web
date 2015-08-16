package com.meiyun.dao;

import com.meiyun.dao.core.BaseDao;
import com.meiyun.model.User;

/**
 * 用户 DAO
 * 
 * @author Administrator
 *
 */
public interface UserDao extends BaseDao<User, Integer> {
	
	/**
	 * 用户登录查询
	 * @param user：name, email, mobile
	 * @return
	 * @throws Exception
	 */
	User queryLogin(User user) throws Exception;

}
