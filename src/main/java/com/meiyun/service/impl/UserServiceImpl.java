package com.meiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meiyun.dao.UserDao;
import com.meiyun.model.User;
import com.meiyun.service.UserService;
import com.meiyun.service.core.impl.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer, UserDao>
		implements UserService {

	@Override
	@Resource
	public void setBaseDao(UserDao baseDao) {
		super.baseDao = baseDao;
	}

	@Override
	public User queryLogin(User user) throws Exception {
		return baseDao.queryLogin(user);
	}

}
