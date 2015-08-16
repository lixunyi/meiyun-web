package com.meiyun.web.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meiyun.core.Constants;
import com.meiyun.core.Route;
import com.meiyun.core.render.Context;
import com.meiyun.core.render.RestError;
import com.meiyun.core.session.LoginUser;
import com.meiyun.core.session.SessionUtils;
import com.meiyun.dao.core.Pagable;
import com.meiyun.model.Product;
import com.meiyun.model.Topic;
import com.meiyun.model.User;
import com.meiyun.service.ProductService;
import com.meiyun.service.TopicService;
import com.meiyun.service.UserService;
import com.meiyun.service.logic.UserLogic;
import com.meiyun.web.component.WebContent;
import com.meiyun.web.core.BaseController;

@Controller
@Scope("prototype")
public class UserController extends BaseController<User, Integer, UserService> {
	
	@Resource
	private ProductService productService;
	
	@Resource
	private TopicService topicService;

	@Override
	@Resource
	public void setBaseService(UserService baseService) {
		super.baseService = baseService;
	}
	
	/**
	 * 跳转到用户登录页：GET
	 * @return
	 */
	@RequestMapping(value=Route.USER_LOGIN, method=RequestMethod.GET)
	public String login() {

		return WebContent.forword("user.login");
	}
	
	/**
	 * 用户登录：POST
	 * @param username
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value=Route.USER_LOGIN, method=RequestMethod.POST)
	public Context login(String username, String password,
			HttpServletRequest request) {
		Context context = new Context();
		context.setMessage("登录成功");
		try {
			User loginUser = this.getUserByName(username);
			RestError error = new UserLogic().userLogin(loginUser, password, request);
			if (error != null) {
				context.setSuccess(false);
				context.setMessage(error.getMessage());
			} else {
				context.setSuccess(true);
				context.setMessage("登录成功");
			}
		} catch (Exception e) {
			// 登录失败
			context.setSuccess(false);
			context.setMessage("系统服务故障");
			e.printStackTrace();
		}
		
		return context;
	}
	
	/**
	 * 跳转到用户登录页：GET
	 * @return
	 */
	@RequestMapping(value=Route.USER_REGISTER, method=RequestMethod.GET)
	public String register() {
		return WebContent.forword("user.register");
	}
	
	/**
	 * 用户注册：POST
	 * @param username
	 * @param password
	 * @param email
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value=Route.USER_REGISTER, method=RequestMethod.POST)
	public Context register(String username, String password, String email,
			HttpServletRequest request) {
		Context context = new Context();
		context.setMessage("注册成功");
		
		try {
			User user = new User();
			// 必须参数
			user.setName(username.trim());
			user.setPassword(DigestUtils.md5Hex(password.trim()));
			user.setEmail(email);
			user.setTitle(username.trim());
			
			// 默认参数
			user.setSecret(UUID.randomUUID().toString());
			user.setColor("#eee");
			user.setSalt("DDUP");
			user.setState(1);
			user.setType(1);
			
			boolean flag = getBaseService().add(user);
			if (!flag) {
				context.setSuccess(false);
				context.setMessage("注册失败");
			} else { // 注册成功后默认为登录状态
				User loginUser = this.getUserByName(username);
				SessionUtils.getInstance(request).set(Constants.LOGIN_USER, loginUser);
			}
		} catch (Exception e) {
			context.setSuccess(false);
			context.setMessage("注册失败");
			e.printStackTrace();
		}
		
		return context;
	}
	
	/**
	 * 个人中心页：用户分享或关注的站点
	 * @return
	 */
	@RequestMapping(value=Route.USER_DASHBORD)
	public String dashbord(Model model, HttpServletRequest request) {
		Context context = new Context();
		Product product = new Product();
		product.setUser(new LoginUser(request).getUser());
		
		try {
			context.setResult(productService.query(product, new Pagable(1, 50)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("c", context);
		
		return WebContent.forword("user.dashbord");
	}

	@RequestMapping(value=Route.USER_LOGOUT)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(Constants.LOGIN_USER);
		
		return WebContent.redirect("/");
	}
	
	/**
	 * 粉丝：关注我的人
	 * @param request
	 * @return
	 */
	@RequestMapping(value = Route.USER_FOLLOWER)
	public String follower(HttpServletRequest request) {
		
		return WebContent.forword("user.follower");
	}
	
	/**
	 * 我关注的人
	 * @param request
	 * @return
	 */
	@RequestMapping(value = Route.USER_FOLLOWING)
	public String following(HttpServletRequest request) {
		
		return WebContent.forword("user.following");
	}
	
	/**
	 * 忘记密码
	 * @param request
	 * @return
	 */
	@RequestMapping(value = Route.USER_FORGOT)
	public String forgot(HttpServletRequest request) {
		
		return WebContent.forword("user.forgot");
	}
	
	/**
	 * 用户标签
	 * @param request
	 * @return
	 */
	@RequestMapping(value = Route.USER_LABEL)
	public String label(HttpServletRequest request) {
		
		return WebContent.forword("user.label");
	}
	
	/**
	 * 用户设置
	 * @param request
	 * @return
	 */
	@RequestMapping(value = Route.USER_PROFILE)
	public String profile(HttpServletRequest request) {
		
		return WebContent.forword("user.profile");
	}
	
	/**
	 * 用户主题
	 * @param request
	 * @return
	 */
	@RequestMapping(value = Route.USER_TOPIC)
	public String topic(Model model, HttpServletRequest request) {
		
		Context context = new Context();
		Topic topic = new Topic();
		topic.setUser(new LoginUser(request).getUser());
		
		try {
			context.setResult(topicService.query(topic, new Pagable(1, 50)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("c", context);
		
		return WebContent.forword("user.topic");
	}
	
	private User getUserByName(String name) throws Exception {
		return getBaseService().queryLogin(new User(name));
	}
}
