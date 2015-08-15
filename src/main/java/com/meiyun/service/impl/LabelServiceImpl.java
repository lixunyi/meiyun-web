package com.meiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meiyun.dao.LabelDao;
import com.meiyun.model.Label;
import com.meiyun.service.LabelService;
import com.meiyun.service.core.impl.BaseServiceImpl;

@Service
public class LabelServiceImpl extends BaseServiceImpl<Label, Integer, LabelDao>
		implements LabelService {

	@Resource
	public void setBaseDao(LabelDao baseDao) {
		super.baseDao = baseDao;
	}


}
