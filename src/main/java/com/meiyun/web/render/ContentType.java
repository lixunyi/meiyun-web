package com.meiyun.web.render;

/**
 * 服务器常见的五种响应类型
 * @author Administrator
 * @since 2015-08-09
 */
public enum ContentType {
	
	TEXT("text/plain"), 
	
	HTML("text/html"), 
	
	XML("text/xml"), 
	
	JSON("application/json"), 
	
	JAVASCRIPT("application/javascript");

	private final String value;

	private ContentType(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

	public String toString() {
		return value;
	}
	
}
