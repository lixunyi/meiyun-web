package com.meiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meiyun.dao.FollowProductDao;
import com.meiyun.model.FollowProduct;
import com.meiyun.service.FollowProductService;
import com.meiyun.service.core.impl.FollowServiceImpl;

@Service
public class FollowProductServiceImpl extends
		FollowServiceImpl<FollowProduct, FollowProductDao> implements
		FollowProductService {

	@Resource
	public void setBaseDao(FollowProductDao baseDao) {
		super.baseDao = baseDao;
	}

}
