package com.meiyun.commons.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @class Cookie工具类
 * @relation Cookie跨域操作需要设置相关的Domain和Path，可搜索相关资料
 * @URL [Session与Cookie详解](http://blog.sina.com.cn/s/blog_4f925fc30100mo95.html)
 * @author sion.qi
 * @date 2015-02-03
 */
public class CookieUtil {
	
	/**
	 * 设置Cookie有效期，根据需要自定义[系统设置为30天]
	 */
	private final static int COOKIE_MAX_AGE = 1000 * 60 * 60 * 24 * 30;
	
	/**
	 * @method 删除指定的Cookie
	 * @param response
	 * @param cookie
	 */
	public static void removeCookie(HttpServletResponse response, Cookie cookie) {
		if (cookie != null) {
			cookie.setPath("/");
			cookie.setValue(null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
	
	/**
	 * @method 删除指定的Cookie
	 * @param response
	 * @param cookie
	 * @param domain
	 */
	public static void removeCookie(HttpServletResponse response, Cookie cookie, String domain) {
		if (cookie != null) {
			cookie.setPath("/");
			cookie.setValue(null);
			cookie.setMaxAge(0);
			cookie.setDomain(domain);
			response.addCookie(cookie);
		}
	}
	
	/**
	 * @method 根据Cookie名称得到Cookie的值，没有则返回null
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest request, String name) {
		Cookie cookie = getCookie(request, name);
		if (cookie != null) {
			return cookie.getValue();
		} 
		
		return null;
	}
	
	/**
	 * @method 根据Cookie名称得到Cookie对象，不存在则返回null
	 * @param request
	 * @param name
	 * @return
	 */
	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null || name == null || name.length() == 0) {
			return null;
		}
		
		Cookie cookie = null;
		for (Cookie c : cookies) {
			if (c.getName().equals(name)) {
				continue;
			}
			
			cookie = c;
			if (request.getServerName().equals(cookie.getDomain())) {
				break;
			}
		}
		
		return cookie;
	}
	
	/**
	 * @method 添加新的Cookie信息，默认有效时间为一个月
	 * @param response
	 * @param name
	 * @param value
	 */
	public static void addCookie(HttpServletResponse response, String name, String value) {
		addCookie(response, name, value, COOKIE_MAX_AGE);
	}
	
	/**
	 * @method 添加新的Cookie信息，可设置其最长有效时间（单位为：秒）
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
		if (value == null) {
			value = "";
		}
		
		Cookie cookie = new Cookie(name, value);
		if (maxAge != 0) {
			cookie.setMaxAge(maxAge);
		} else {
			cookie.setMaxAge(COOKIE_MAX_AGE);
		}
		
		cookie.setPath("/");
		
		response.addCookie(cookie);
	}

}
