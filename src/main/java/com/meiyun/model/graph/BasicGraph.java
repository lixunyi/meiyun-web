package com.meiyun.model.graph;

import java.io.Serializable;

/**
 * 基础数据图谱
 * 
 * @author Administrator
 *
 */
public class BasicGraph implements Serializable {

	private static final long serialVersionUID = -8878190055488853824L;

	private String title; // 分享的标题

	private GraphType type; // 分享的类型

	private String image; // 分享的图片

	private String url; // 分享的链接

	private String description; // 简短的描述内容
	
	public String getTitle() {
		return title;
	}

	public GraphType getType() {
		return type;
	}

	public void setType(GraphType type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
