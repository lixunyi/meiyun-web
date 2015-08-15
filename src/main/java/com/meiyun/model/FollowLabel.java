package com.meiyun.model;

import com.meiyun.model.core.BaseEntity;

/**
 * 用户关注标签
 * 
 * @author Administrator
 *
 */
public class FollowLabel extends BaseEntity {

	private static final long serialVersionUID = -6595553720330274963L;

	private User user; // 用户对象

	private Label label; // 标签对象

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUser(Integer userId) {
		this.user = new User(userId);
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public void setLabel(Integer labelId) {
		this.label = new Label(labelId);
	}

}
