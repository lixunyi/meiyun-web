package com.meiyun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meiyun.dao.ProductDao;
import com.meiyun.model.Product;
import com.meiyun.service.ProductService;
import com.meiyun.service.core.impl.BaseServiceImpl;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Integer, ProductDao>
		implements ProductService {

	@Override
	@Resource
	public void setBaseDao(ProductDao baseDao) {
		super.baseDao = baseDao;
	}

}
