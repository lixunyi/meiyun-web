package com.meiyun.core;

/**
 * 使用枚举定义常量类
 * @author Administrator
 *
 */
public enum ConstantEnum {

	CHARSET("UTF-8"), // 字符编码
	LOGIN_USER("loginUser"), // 登录用户
	SCOPE("prototype"); // 控制器作用域

	private String value;

	ConstantEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
