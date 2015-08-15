package com.meiyun.web.component;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * 通过WebApplicationInitializer配置Web.xml
 * @author Administrator
 * @since 2015-07-19
 * @reference http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-servlet
 */
public class MeiyunWebApplicationInitializer implements
		WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		// 设置初始化全局参数
		container.setInitParameter("contextConfigLocation", "/WEB-INF/spring/root-context.xml");
		
		// 注册 Spring 监听
		registrationListener(container);
		
		// 注册Spring MVC DispatcherServlet
		registrationDispatcherServlet(container);
		
		// 注册 Druid 连接池 StatViewServlet
		registrationStatViewServlet(container);
		
		// 注册Spring字符编码过滤器
		registrationCharacterEncodingFilter(container);
	}
	
	/**
	 * 管理和注册系统监听
	 * @param container
	 */
	private void registrationListener(ServletContext container) {
		container.addListener(ContextLoaderListener.class);
	}
	
	/**
	 * 管理和注册Spring MVC DispatcherServlet
	 * @param container
	 */
	private void registrationDispatcherServlet(ServletContext container) {
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet());
		dispatcher.setInitParameter("contextConfigLocation", "/WEB-INF/spring/appServlet/servlet-context.xml");
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
	
	/**
	 * 管理和注册 Druid 连接池 StatViewServlet
	 * @param container
	 */
	private void registrationStatViewServlet(ServletContext container) {
		ServletRegistration.Dynamic druidStatView = container.addServlet("druidStatView", new StatViewServlet());
		druidStatView.addMapping("/druid");
	}
	
	/**
	 * 管理和注册CharacterEncodingFilter
	 * @param container
	 */
	private void registrationCharacterEncodingFilter(ServletContext container) {
		FilterRegistration.Dynamic encodingFilter = container.addFilter("encodingFilter", new CharacterEncodingFilter());
		encodingFilter.setInitParameter("encoding", "UTF-8");
		encodingFilter.setInitParameter("forceEncoding", "true");
		// EnumSet类不允许重复数据
		EnumSet<DispatcherType> dispatcherTypes = EnumSet.noneOf(DispatcherType.class);
		dispatcherTypes.add(DispatcherType.REQUEST);
		dispatcherTypes.add(DispatcherType.FORWARD);
		dispatcherTypes.add(DispatcherType.ERROR);
		encodingFilter.addMappingForServletNames(dispatcherTypes, false, "dispatcher");
	}

}
