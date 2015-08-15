package com.meiyun.model.core;

import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.MaxSize;
import net.sf.oval.constraint.NotNull;

/**
 * 通用属性实体：表必须字段
 * 
 * @author Administrator
 *
 * @param <ID>
 */
public abstract class CommonEntity extends BaseEntity {

	private static final long serialVersionUID = 7075161334987416406L;

	@NotNull(profiles = "name")
	@MaxLength(value = 32, profiles = "name")
	private String name; // 名称

	@NotNull(profiles = "title")
	@MaxLength(value = 128, profiles = "title")
	private String title; // 标题

	@MaxSize(value = 256, profiles = "comment")
	private String comment; // 简短的内容描述

	public CommonEntity() {
		super();
	}

	public CommonEntity(int id) {
		super(id);
	}

	public CommonEntity(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
