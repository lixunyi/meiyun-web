package com.meiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meiyun.dao.FollowLabelDao;
import com.meiyun.model.FollowLabel;
import com.meiyun.service.FollowLabelService;
import com.meiyun.service.core.impl.FollowServiceImpl;

@Service
public class FollowLabelServiceImpl extends
		FollowServiceImpl<FollowLabel, FollowLabelDao> implements
		FollowLabelService {

	@Resource
	public void setBaseDao(FollowLabelDao baseDao) {
		super.baseDao = baseDao;
	}

}
