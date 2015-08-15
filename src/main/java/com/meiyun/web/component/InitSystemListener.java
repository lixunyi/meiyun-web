package com.meiyun.web.component;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;


/**
 * 系统初始化监听
 * @author Administrator
 *
 */
@Component
public class InitSystemListener implements InitializingBean, ServletContextAware {

	private Logger logger = LoggerFactory.getLogger(InitSystemListener.class);
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		logger.info("初始化配置数据开始加载");
		WebContent.loadApplication();
		WebContent.loadViews();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	
}
