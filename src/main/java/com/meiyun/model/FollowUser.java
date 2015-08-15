package com.meiyun.model;

import com.meiyun.model.core.BaseEntity;

/**
 * 关注用户
 * 
 * @author Administrator
 *
 */
public class FollowUser extends BaseEntity {

	private static final long serialVersionUID = 7894030309816680023L;

	private User user; // 用户

	private User follower; // 关注者

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUser(Integer userId) {
		this.user = new User(userId);
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	public void setFollower(Integer followerId) {
		this.follower = new User(followerId);
	}

}
