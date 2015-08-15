package com.meiyun.dao.core;

import java.io.Serializable;

import com.github.pagehelper.PageInfo;

/**
 * DAO 基础接口
 * @author Administrator
 *
 * @param <T>
 * @param <PK>
 */
public interface BaseDao<T, PK extends Serializable> {
	
	/**
	 * 添加数据
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int insert(T entity) throws Exception;

	/**
	 * 物理删除数据
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	int delete(T entity) throws Exception;

	/**
	 * 更新数据
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	int update(T entity) throws Exception;

	/**
	 * 查询数据
	 * 
	 * @param queryParams
	 * @return
	 * @throws Exception
	 */
	PageInfo<T> query(T entity, Pagable pagable) throws Exception;

	/**
	 * 根据对象ID查询
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	T queryById(PK primaryKey) throws Exception;
	
}
