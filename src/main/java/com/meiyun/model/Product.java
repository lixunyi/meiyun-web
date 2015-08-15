package com.meiyun.model;

import net.sf.oval.constraint.AssertURL;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotNull;

import com.meiyun.model.core.CommonEntity;

/**
 * 产品
 * 
 * @author Administrator
 *
 */
public class Product extends CommonEntity {

	private static final long serialVersionUID = -8932159666962395139L;

	@NotNull(profiles = "domain")
	@MaxLength(value = 128, profiles = "domain")
	private String domain; // 域名

	@NotNull(profiles = "url")
	@AssertURL(profiles = "url")
	@MaxLength(value = 512, profiles = "url")
	private String url; // 链接

	@MaxLength(value = 128, profiles = "labels")
	private String labels; // 标签

	@MaxLength(value = 128, profiles = "image")
	private String image; // 图片

	private Integer liked; // 已关注的人数

	@NotNull(profiles = "user")
	private User user; // 用户

	@NotNull(profiles = "topic")
	private Topic topic; // 主题

	public Product() {
		super();
	}

	public Product(Integer id) {
		super(id);
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
