package com.meiyun.model;

import com.meiyun.model.core.BaseEntity;

/**
 * 用户关注产品
 * 
 * @author Administrator
 *
 */
public class FollowProduct extends BaseEntity {

	private static final long serialVersionUID = 5473310657350309165L;

	private User user; // 用户

	private Product product; // 产品

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUser(Integer userId) {
		this.user = new User(userId);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setProduct(Integer productId) {
		this.product = new Product(productId);
	}

}
