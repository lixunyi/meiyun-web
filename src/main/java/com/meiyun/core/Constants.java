package com.meiyun.core;

/**
 * 系统常量设置
 * @author qizh
 * @since 2015-08-14
 */
public interface Constants {
	
	/**
	 * 字符编码
	 */
	String CHARSET = "UTF-8";
	
	/**
	 * 控制器作用域
	 */
	String SCOPE = "prototype";
	
	/**
	 * 操作名称
	 */
	String OP_NAME = "op";
	
	/**
     * 消息key
     */
    String MESSAGE = "message";

    /**
     * 错误key
     */
    String ERROR = "error";
	
    /**
     * 上个页面地址
     */
    String BACK_URL = "BackURL";

    /**
     * 忽略返回地址
     */
    String IGNORE_BACK_URL = "ignoreBackURL";

    /**
     * 当前请求的地址 带参数
     */
    String CURRENT_URL = "currentURL";

    /**
     * 当前请求的地址 不带参数
     */
    String NO_QUERYSTRING_CURRENT_URL = "noQueryStringCurrentURL";

    /**
     * 上下文路径
     */
    String CONTEXT_PATH = "ctx";
    
	/**
	 * 登录用户
	 */
	String LOGIN_USER = "loginUser";
	
	/**
	 * 管理员用户
	 */
	String ADMIN_USER = "adminUser";

}
