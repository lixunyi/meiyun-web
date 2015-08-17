package com.meiyun.core;

/**
 * Session常量类
 * @author Administrator
 *
 */
public enum SessionConstants {

	LoginUser("loginUser");

	private String name;

	private SessionConstants(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
