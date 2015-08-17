package com.meiyun.web.core;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meiyun.core.SessionConstants;
import com.meiyun.model.User;


/**
 * 美云核心Controller
 * @author Administrator
 *
 */
public class WebController {
	
	/**
	 * 设置Cookie有效期，根据需要自定义[系统设置为30天]
	 */
	private final static int COOKIE_MAX_AGE = 1000 * 60 * 60 * 24 * 30;
	
	/**
	 * 设置Session有效期，根据需要自定义[系统设置为60分钟]
	 */
	private final static int SESSION_DEFAULT_AGE = 1000 * 60 * 60;
	
	/**
	 * 获取Session对象
	 * @param request
	 * @return
	 */
	public HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}
	
	/**
	 * 添加Session对象
	 * @param name
	 * @param value
	 * @param request
	 */
	public void addSession(SessionConstants name, Object value, HttpServletRequest request) {
		addSession(name, value, -1, request); // 不过期
	}
	
	/**
	 * 添加Session对象
	 * @param name Session名称
	 * @param value Session对象值
	 * @param interval 过期时间
	 * @param request
	 */
	public void addSession(SessionConstants name, Object value, int interval, HttpServletRequest request) {
		HttpSession session = this.getSession(request);
		session.setAttribute(name.toString(), value);
		session.setMaxInactiveInterval(interval);
	}
	
	/**
	 * 根据Name获取Session对象
	 * @param name
	 * @param request
	 * @return
	 */
	public Object getSession(SessionConstants name, HttpServletRequest request) {
		return this.getSession(request).getAttribute(name.toString());
	}
	
	/**
	 * 移除Session值
	 * @param name
	 * @param request
	 */
	public void removeSession(SessionConstants name, HttpServletRequest request) {
		this.getSession(request).removeAttribute(name.toString());
	}
	
	/**
	 * 获取登录用户
	 * @param request
	 * @return
	 */
	public User getLoginUser(HttpServletRequest request) {
		Object object = this.getSession(request).getAttribute(
				SessionConstants.LoginUser.toString());
		return (object instanceof User) ? (User) object : null;
	}
	
	/**
	 * 添加登录用户Session
	 * @param user
	 * @param request
	 */
	public void setLoginUser(User user, HttpServletRequest request) {
		this.addSession(SessionConstants.LoginUser, user, SESSION_DEFAULT_AGE, request);
	}
	
	/**
	 * 获取登录用户ID
	 * @param request
	 * @return
	 */
	public int getLoginUserId(HttpServletRequest request) {
		User user = getLoginUser(request);
		return (user != null) ? user.getId(): 0;
	}
	
	/**
	 * @method 添加新的Cookie信息，默认有效时间为一个月
	 * @param response
	 * @param name
	 * @param value
	 */
	public void addCookie(HttpServletResponse response, String name, String value) {
		addCookie(response, name, value, COOKIE_MAX_AGE);
	}
	
	/**
	 * @method 添加新的Cookie信息，可设置其最长有效时间（单位为：秒）
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	public void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
		
		value = (value != null) ? value : "";
		Cookie cookie = new Cookie(name, value);
		if (maxAge != 0) {
			cookie.setMaxAge(maxAge);
		} else {
			cookie.setMaxAge(COOKIE_MAX_AGE);
		}
		
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * @method 删除指定的Cookie
	 * @param response
	 * @param cookie
	 */
	public void removeCookie(HttpServletResponse response, Cookie cookie) {
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
	public void removeCookie(HttpServletResponse response, Cookie cookie, String domain) {
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
	public String getCookieValue(HttpServletRequest request, String name) {
		Cookie cookie = getCookie(request, name);
		return (cookie != null) ? cookie.getValue(): null;
	}
	
	/**
	 * @method 根据Cookie名称得到Cookie对象，不存在则返回null
	 * @param request
	 * @param name
	 * @return
	 */
	public Cookie getCookie(HttpServletRequest request, String name) {
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
	
}
