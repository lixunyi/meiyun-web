package com.meiyun.service.core.impl;

import com.meiyun.dao.core.BaseDao;
import com.meiyun.model.core.BaseEntity;
import com.meiyun.service.core.FollowService;

/**
 * 关注服务实现
 * @author Administrator
 *
 * @param <T>
 * @param <D>
 */
public abstract class FollowServiceImpl<T extends BaseEntity, D extends BaseDao<T, Integer>>
		implements FollowService<T> {
	
	protected D baseDao;

	public D getBaseDao() {
		return baseDao;
	}

	// 通过实现类 自动注入
	public abstract void setBaseDao(D baseDao);

	@Override
	public void follow(T entity) throws Exception {
		baseDao.insert(entity);
	}

	@Override
	public void unfollow(T entity) throws Exception {
		baseDao.delete(entity);
	}

}
