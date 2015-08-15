package com.meiyun.service.core;

import java.io.Serializable;

import com.github.pagehelper.PageInfo;
import com.meiyun.dao.core.Pagable;
import com.meiyun.model.core.BaseEntity;

/**
 * 服务层通用接口
 * 
 * @author Administrator
 *
 * @param <T>
 */
public interface BaseService<T extends BaseEntity, PK extends Serializable> {

	/**
	 * 添加数据
	 * 
	 * @param t
	 * @return 添加成功后的记录
	 * @throws Exception
	 */
	boolean add(T entity) throws Exception;

	/**
	 * 物理删除数据
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	boolean delete(T entity) throws Exception;

	/**
	 * 更新数据
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	boolean update(T entity) throws Exception;

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
