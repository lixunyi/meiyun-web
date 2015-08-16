package com.meiyun.service.core;

import com.meiyun.model.core.BaseEntity;

/**
 * 用户关注服务接口
 * @author Administrator
 *
 * @param <T>
 */
public interface FollowService<T extends BaseEntity> {
	
	/**
	 * 添加关注接口
	 * @param entity
	 * @throws Exception
	 */
	void follow(T entity) throws Exception;
	
	/**
	 * 取消关注接口
	 * @param entity
	 * @throws Exception
	 */
	void unfollow(T entity) throws Exception;

}
