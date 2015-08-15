package com.meiyun.dao.core;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * 批量操作接口
 * @author Administrator
 *
 * @param <T>
 * @param <PK>
 */
public interface BatchReposity<T, PK extends Serializable> {
	
	/**
	 * 按主键批量删除
	 * @param list
	 * @return
	 * @throws SQLException
	 */
	int batchDelete(List<PK> list) throws SQLException;
	
	/**
	 * 按主键批量删除
	 * @param list
	 * @return
	 * @throws SQLException
	 */
	int batchUpdate(List<PK> list) throws SQLException;
	
	/**
	 * 按主键批量删除
	 * @param list
	 * @return
	 * @throws SQLException
	 */
	int batchInsert(List<PK> list) throws SQLException;

}
