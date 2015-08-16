package com.meiyun.core.render;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meiyun.core.Constants;

public abstract class Render {
	
	protected String view;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private static String encoding = Constants.CHARSET;
	
	static void init(String encoding) {
		Render.encoding = encoding;
	}
	
	public static String getEncoding() {
		return encoding;
	}
	
	public Render setContext(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		return this;
	}
	
	public Render setContext(HttpServletRequest request, HttpServletResponse response, String viewPath) {
		this.request = request;
		this.response = response;
		if (view != null && !view.startsWith("/"))
			view = viewPath + view;
		return this;
	}
	
	public String getView() {
		return view;
	}
	
	public void setView(String view) {
		this.view = view;
	}
	
	/**
	 * Render to client
	 */
	public abstract void render();
}
