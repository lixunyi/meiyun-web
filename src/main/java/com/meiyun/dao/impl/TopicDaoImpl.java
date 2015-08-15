package com.meiyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.meiyun.dao.TopicDao;
import com.meiyun.dao.core.impl.BaseDaoImpl;
import com.meiyun.model.Topic;

@Repository
public class TopicDaoImpl extends BaseDaoImpl<Topic, Integer> implements
		TopicDao {

	@Override
	public String getMapper() {
		return "TopicMapper";
	}

}
