package com.meiyun.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * SessionUtils 工具类
 * 
 * @author Administrator
 *
 */
public class SessionUtils {

	private SessionUtils() {
	}

	private static SessionUtils instance = new SessionUtils();
	private static HttpSession session;

	public static SessionUtils getInstance(HttpServletRequest request) {
		session = request.getSession();
		return instance;
	}

	/**
	 * 获取Session对象
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * 添加指定Session
	 * 
	 * @param name
	 * @param value
	 */
	public void set(String name, Object value) {
		session.setAttribute(name, value);
		session.setMaxInactiveInterval(-1); // 不过期
	}

	/**
	 * 添加指定Session
	 * 
	 * @param name
	 * @param value
	 * @param interval
	 */
	public void set(String name, Object value, int interval) {
		session.setAttribute(name, value);
		session.setMaxInactiveInterval(interval);
	}

	/**
	 * 获取指定Session
	 * 
	 * @param name
	 * @return
	 */
	public Object get(String name) {
		return session.getAttribute(name);
	}

	/**
	 * 移除指定Session
	 * 
	 * @param name
	 */
	public void remove(String name) {
		session.removeAttribute(name);
	}

}
