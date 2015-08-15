package com.meiyun.web.core;

import java.io.Serializable;

import com.meiyun.model.core.BaseEntity;
import com.meiyun.service.core.BaseService;

/**
 * 控制器的基类
 * 
 * @author Administrator
 *
 * @param <T>
 * @param <S>
 */
public abstract class BaseController<T extends BaseEntity, PK extends Serializable, S extends BaseService<T, PK>> {

	protected S baseService;

	public S getBaseService() {
		return baseService;
	}

	public abstract void setBaseService(S baseService);

	/**
	 * 返回给前端的对象
	 * 
	 * @param viewName
	 * @param context
	 * @return
	 */
	/*public ModelAndView render(String viewName, Context context) {
		ModelAndView model = this.render(viewName);
		model.addObject("c", context);
		return model;
	}*/

	/**
	 * 返回给前端对象，可以做重定向
	 * 
	 * @param viewName
	 * @return
	 */
	/*public ModelAndView render(String viewName) {
		return new ModelAndView(Config.render(viewName));
	}*/

	/**
	 * @method 获取登录用户对象
	 * @param request
	 * @return
	 */
	/*public User getLoginUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(
				Default.LoginUser.toString());
	}*/

	/**
	 * @method 删除用户对象
	 * @param request
	 */
	/*public void removeLoginUser(HttpServletRequest request) {
		request.getSession().removeAttribute(Default.LoginUser.toString());
	}*/

}
