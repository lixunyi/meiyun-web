package com.meiyun.dao.core.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.github.pagehelper.PageInfo;
import com.meiyun.dao.core.BaseDao;
import com.meiyun.dao.core.Pagable;
import com.meiyun.model.core.BaseEntity;

public abstract class BaseDaoImpl<T extends BaseEntity, PK extends Serializable>
		implements BaseDao<T, PK> {
	
	protected static final String SQL_INSERT = ".insert";
	
	protected static final String SQL_DELETE = ".delete";
	
	protected static final String SQL_UPDATE = ".update";

	protected static final String SQL_QUERY = ".query";
	
	protected static final String SQL_QUERY_BY_ID = ".queryById";
	
	// 映射实体名称
	protected String mapper;
	
	protected SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 必须设置每个实体的映射名称
	 * @param mapper 实体映射名称，与XML配置的name一致
	 */
	public abstract String getMapper();

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	// 自动注入
	@Resource
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int insert(T entity) throws Exception {
		return sqlSessionTemplate.insert(getMapper().concat(SQL_INSERT), entity);
	}

	@Override
	public int delete(T entity) throws Exception {
		return sqlSessionTemplate.delete(getMapper().concat(SQL_DELETE), entity);
	}

	@Override
	public int update(T entity) throws Exception {
		return sqlSessionTemplate.update(getMapper().concat(SQL_UPDATE), entity);
	}

	@Override
	public PageInfo<T> query(T entity, Pagable pagable) throws Exception {
		// 使用分页插件控制分页
		Pagable.excute(pagable);
		List<T> list = sqlSessionTemplate.selectList(getMapper().concat(SQL_QUERY), entity);
		return new PageInfo<T>(list);
	}

	@Override
	public T queryById(PK primaryKey) throws Exception {
		return sqlSessionTemplate.selectOne(getMapper().concat(SQL_QUERY_BY_ID), primaryKey);
	}

}
