package com.meiyun.model;

import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotNull;

import com.meiyun.model.core.CommonEntity;

/**
 * 主题
 * 
 * @author Administrator
 *
 */
public class Topic extends CommonEntity {

	private static final long serialVersionUID = 8806053128810435874L;

	@MaxLength(value = 128, profiles = "labels")
	private String labels; // 标签

	@MaxLength(value = 128, profiles = "image")
	private String image; // 图像

	@MaxLength(value = 128, profiles = "cover")
	private String cover; // 封面

	@MaxLength(value = 32, profiles = "color")
	private String color; // 颜色

	private Integer counter; // 产品计数器

	private Integer liked; // 已关注的人数

	@NotNull(profiles = "user")
	private User user; // 用户

	public Topic() {
		super();
	}

	public Topic(Integer id) {
		super(id);
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public Integer getLiked() {
		return liked;
	}

	public void setLiked(Integer liked) {
		this.liked = liked;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
