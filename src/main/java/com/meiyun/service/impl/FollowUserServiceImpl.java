package com.meiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meiyun.dao.FollowUserDao;
import com.meiyun.model.FollowUser;
import com.meiyun.service.FollowUserService;
import com.meiyun.service.core.impl.FollowServiceImpl;

@Service
public class FollowUserServiceImpl extends
		FollowServiceImpl<FollowUser, FollowUserDao> implements
		FollowUserService {

	@Resource
	public void setBaseDao(FollowUserDao baseDao) {
		super.baseDao = baseDao;
	}

}
