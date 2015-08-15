package com.meiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meiyun.dao.TopicDao;
import com.meiyun.model.Topic;
import com.meiyun.service.TopicService;
import com.meiyun.service.core.impl.BaseServiceImpl;

@Service
public class TopicServiceImpl extends BaseServiceImpl<Topic, Integer, TopicDao>
		implements TopicService {

	@Override
	@Resource
	public void setBaseDao(TopicDao baseDao) {
		super.baseDao = baseDao;
	}

}
