package com.meiyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.meiyun.dao.UserDao;
import com.meiyun.dao.core.impl.BaseDaoImpl;
import com.meiyun.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

	@Override
	public String getMapper() {
		return "UserMapper";
	}

	@Override
	public User queryLogin(User user) throws Exception {
		return sqlSessionTemplate.selectOne(getMapper().concat(".queryLogin"),
				user);
	}

}
