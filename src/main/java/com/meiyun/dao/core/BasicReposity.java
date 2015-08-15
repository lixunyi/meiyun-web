package com.meiyun.dao.core;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * DAO接口，定义基本的DAO功能
 * 
 * @author zhy
 * @since 2015-08-12
 * @param <T> 实体类
 * @param <PK> 主键类，必须实现Serializable接口
 */
public interface BasicReposity<T, PK extends Serializable> {

	/**
	 * 添加一个实体（在数据库中INSERT一条记录）
	 * @param entity 实体对象
	 * @return 添加的对象个数，正常情况=1
	 * @throws SQLException
	 */
	int insert(T entity) throws SQLException;
	
	/**
	 * 修改一个实体对象（UPDATE一条记录）
	 * @param entity 实体对象
	 * @return 修改的对象个数，正常情况=1
	 * @throws SQLException
	 */
	int update(T entity) throws SQLException;
	
	/**
	 * 按主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws SQLException
	 */
	int deleteById(PK primaryKey) throws SQLException;
	
	/**
	 * 根据条件来删除
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	int delete(T entity) throws SQLException;
	
}
