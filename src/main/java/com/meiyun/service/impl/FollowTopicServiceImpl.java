package com.meiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meiyun.dao.FollowTopicDao;
import com.meiyun.model.FollowTopic;
import com.meiyun.service.FollowTopicService;
import com.meiyun.service.core.impl.FollowServiceImpl;

@Service
public class FollowTopicServiceImpl extends
		FollowServiceImpl<FollowTopic, FollowTopicDao> implements
		FollowTopicService {

	@Resource
	public void setBaseDao(FollowTopicDao baseDao) {
		super.baseDao = baseDao;
	}

}
