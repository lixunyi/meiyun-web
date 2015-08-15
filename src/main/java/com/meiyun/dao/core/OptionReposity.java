package com.meiyun.dao.core;

import java.io.Serializable;
import java.sql.SQLException;

public interface OptionReposity<T, PK extends Serializable> {
	
	/**
	 * 清除表中的全部数据
	 * @return
	 * @throws SQLException
	 */
	int truncate() throws SQLException;

}
