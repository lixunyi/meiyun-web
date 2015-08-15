package com.meiyun.service.core.impl;

import java.io.Serializable;

import com.github.pagehelper.PageInfo;
import com.meiyun.dao.core.BaseDao;
import com.meiyun.dao.core.Pagable;
import com.meiyun.model.core.BaseEntity;
import com.meiyun.service.core.BaseService;

public abstract class BaseServiceImpl<T extends BaseEntity, PK extends Serializable, D extends BaseDao<T, PK>>
		implements BaseService<T, PK> {

	protected D baseDao;

	public D getBaseDao() {
		return baseDao;
	}

	// 通过实现类 自动注入
	public abstract void setBaseDao(D baseDao);

	@Override
	public boolean add(T entity) throws Exception {
		return baseDao.insert(entity) > 0;
	}

	@Override
	public boolean delete(T entity) throws Exception {
		return baseDao.delete(entity) > 0;
	}

	@Override
	public boolean update(T entity) throws Exception {
		return baseDao.update(entity) > 0;
	}

	@Override
	public PageInfo<T> query(T entity, Pagable pagable) throws Exception {
		return baseDao.query(entity, pagable);
	}

	@Override
	public T queryById(PK primaryKey) throws Exception {
		return baseDao.queryById(primaryKey);
	}

}
