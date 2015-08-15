package com.meiyun.model;

import com.meiyun.model.core.BaseEntity;

/**
 * 用户关注主题
 * 
 * @author Administrator
 *
 */
public class FollowTopic extends BaseEntity {

	private static final long serialVersionUID = 7845983123679652001L;

	private User user; // 用户

	private Topic topic; // 主题
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setUser(Integer userId) {
		this.user = new User(userId);
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public void setTopic(Integer topicId) {
		this.topic = new Topic(topicId);
	}

}
