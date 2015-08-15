package com.meiyun.dao.impl;

import org.springframework.stereotype.Repository;

import com.meiyun.dao.ProductDao;
import com.meiyun.dao.core.impl.BaseDaoImpl;
import com.meiyun.model.Product;

@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product, Integer> implements
		ProductDao {

	@Override
	public String getMapper() {
		return "ProductMapper";
	}

}
