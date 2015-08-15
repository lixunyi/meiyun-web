package com.meiyun.web.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理视图
 * @author Administrator
 */
@Component
public class MeiyunExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception ex) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("obj", object);
    	model.addObject("ex", ex);
    	
        // 根据不同错误转向不同页面  
        if (ex instanceof Exception) {
			model.setViewName("error"); // 错误视图
		}
        
        return model;
	}

}
