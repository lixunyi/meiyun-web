package com.meiyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.meiyun.dao.FollowProductDao;
import com.meiyun.dao.core.impl.BaseDaoImpl;
import com.meiyun.model.FollowProduct;

@Repository
public class FollowProductDaoImpl extends BaseDaoImpl<FollowProduct, Integer>
		implements FollowProductDao {

	@Override
	public String getMapper() {
		return "FollowProductMapper";
	}

}
