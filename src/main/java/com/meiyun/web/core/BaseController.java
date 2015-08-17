package com.meiyun.web.core;

import java.io.Serializable;
import java.util.Map;

import com.meiyun.model.core.BaseEntity;
import com.meiyun.service.core.BaseService;
import com.meiyun.web.component.PropertiesUtil;

/**
 * 控制器的基类
 * 
 * @author Administrator
 *
 * @param <T>
 * @param <S>
 */
public abstract class BaseController<T extends BaseEntity, PK extends Serializable, S extends BaseService<T, PK>>
		extends WebController {

	protected S baseService;

	public S getBaseService() {
		return baseService;
	}

	public abstract void setBaseService(S baseService);

	// 保存视图配置
	private static Map<Object, Object> viewsMap;

	// 保存系统配置
	private static Map<Object, Object> applicationMap;

	public static Map<Object, Object> getViewsMap() {
		return viewsMap;
	}

	public static void setViewsMap(Map<Object, Object> viewsMap) {
		BaseController.viewsMap = viewsMap;
	}

	public static Map<Object, Object> getApplicationMap() {
		return applicationMap;
	}

	public static void setApplicationMap(Map<Object, Object> applicationMap) {
		BaseController.applicationMap = applicationMap;
	}
	
	/**
	 * 加载视图配置
	 */
	public static void loadViews() {
		if (viewsMap == null) {
			viewsMap = PropertiesUtil.INSTANCE.load("views.properties");
		}
	}
	
	/**
	 * 加载系统配置
	 */
	public static void loadApplication() {
		if (applicationMap == null) {
			applicationMap = PropertiesUtil.INSTANCE.load("application.properties");
		}
	}
	
	/**
	 * @method 获取配置信息内容，默认值为null
	 * @param key 属性文件中的键名
	 * @return 通过键获取到的值
	 */
	public String prop(String key) {
		loadApplication();
		return applicationMap.get(key).toString();
	}

	/**
	 * @method 配置视图 views.properties
	 * @param key 
	 * @return
	 */
	public String render(String key) {
		loadViews();
		return viewsMap.get(key).toString();
	}
	
	/**
	 * 重定向页面
	 * @param path
	 * @return
	 */
	public String redirect(String path) {
		return "redirect:".concat(path);
	}

}
