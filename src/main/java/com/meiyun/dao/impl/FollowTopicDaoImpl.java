package com.meiyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.meiyun.dao.FollowTopicDao;
import com.meiyun.dao.core.impl.BaseDaoImpl;
import com.meiyun.model.FollowTopic;

@Repository
public class FollowTopicDaoImpl extends BaseDaoImpl<FollowTopic, Integer>
		implements FollowTopicDao {

	@Override
	public String getMapper() {
		return "FollowTopicMapper";
	}

}
