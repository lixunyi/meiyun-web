package com.meiyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.meiyun.dao.LabelDao;
import com.meiyun.dao.core.impl.BaseDaoImpl;
import com.meiyun.model.Label;

@Repository
public class LabelDaoImpl extends BaseDaoImpl<Label, Integer> implements LabelDao {

	@Override
	public String getMapper() {
		return "LabelMapper";
	}

}
