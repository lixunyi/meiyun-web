package com.meiyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.meiyun.dao.FollowUserDao;
import com.meiyun.dao.core.impl.BaseDaoImpl;
import com.meiyun.model.FollowUser;

@Repository
public class FollowUserDaoImpl extends BaseDaoImpl<FollowUser, Integer>
		implements FollowUserDao {

	@Override
	public String getMapper() {
		return "FollowUserMapper";
	}

}
