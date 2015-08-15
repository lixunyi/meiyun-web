package com.meiyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.meiyun.dao.FollowLabelDao;
import com.meiyun.dao.core.impl.BaseDaoImpl;
import com.meiyun.model.FollowLabel;

@Repository
public class FollowLabelDaoImpl extends BaseDaoImpl<FollowLabel, Integer>
		implements FollowLabelDao {

	@Override
	public String getMapper() {
		return "FollowLabelMapper";
	}

}
