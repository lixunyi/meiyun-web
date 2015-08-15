package com.meiyun.model.core;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 抽象实体基类，提供统一的ID，和相关的基本功能方法
 * 
 * @author Administrator
 *
 * @param <ID>
 */
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 6730731136916220145L;

	private int id; // ID

	private int state; // 状态

	private Timestamp created; // 创建时间

	private Timestamp lastModified; // 最后修改时间

	public BaseEntity() {
		super();
	}

	public BaseEntity(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

}
