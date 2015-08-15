package com.meiyun.core;

/**
 * 表记录状态设置，通用
 * 
 * @author Administrator
 *
 */
public enum State {

	/**
	 * 状态0：禁用，不可用
	 */
	DISABLED(0),

	/**
	 * 状态1：可用
	 */
	ACTIVE(1),

	/**
	 * 状态2：删除
	 */
	DELETED(2),

	/**
	 * 状态3：草稿，待审核
	 */
	DRAFT(3);

	private Integer value;

	private State(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
