package com.meiyun.dao.core;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * 数据查询接口
 * @author Administrator
 *
 * @param <T>
 * @param <PK>
 */
public interface QueryReposity<T, PK extends Serializable> {
	
	/**
	 * 根据主键查询
	 * @param primaryKey
	 * @return
	 * @throws SQLException
	 */
	T findById(PK primaryKey) throws SQLException;
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<T> find(T entity) throws SQLException;

}
