package com.meiyun.web.controller;

import java.net.URL;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.meiyun.commons.util.FetchUrl;
import com.meiyun.commons.util.FetchUtil;
import com.meiyun.core.Route;
import com.meiyun.core.annotation.Logined;
import com.meiyun.core.render.Context;
import com.meiyun.core.session.LoginUser;
import com.meiyun.dao.core.Pagable;
import com.meiyun.model.Product;
import com.meiyun.model.Topic;
import com.meiyun.service.ProductService;
import com.meiyun.service.TopicService;
import com.meiyun.web.component.WebContent;
import com.meiyun.web.core.BaseController;

@Controller
@Scope("prototype")
public class ProductController extends BaseController<Product, Integer, ProductService> {

	@Resource
	private TopicService topicService;
	
	@Override
	@Resource
	public void setBaseService(ProductService baseService) {
		super.baseService = baseService;
	}
	
	@Logined
	@RequestMapping(value=Route.PRODUCT_NEW, method=RequestMethod.GET)
	public String add(Model model, HttpServletRequest request) {
		
		Context context = new Context();
		
		Topic topic = new Topic();
		topic.setUser(new LoginUser(request).getUser());
		
		try {
			PageInfo<Topic> page = topicService.query(null, new Pagable(1, 5));
			context.setResult(page.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("c", context);
		
		return WebContent.forword("product.new");
	}
	
	@ResponseBody
	@RequestMapping(value=Route.PRODUCT_NEW, method=RequestMethod.POST)
	public Context add(String title, String url, String comment,
			Integer topicId, HttpServletRequest request) {
		Context context = new Context();
		context.setMessage("添加产品成功");
		
		try {
			Product t = new Product();
			t.setComment(comment);
			t.setDomain(new URL(url).getHost());
			t.setTitle(title);
			t.setUrl(url);
			
			// 默认参数设置
			t.setName(UUID.randomUUID().toString());
			t.setTopic(new Topic(topicId)); 
			t.setUser(new LoginUser(request).getUser());
			t.setState(1);
			t.setLiked(0);
			
			if (!getBaseService().add(t)) {
				context.setSuccess(false);
				context.setMessage("创建产品失败");
			}
		} catch (Exception e) {
			context.setSuccess(false);
			context.setMessage("创建产品失败，系统错误");
			e.printStackTrace();
		}
		
		return context;
	}
	
	@ResponseBody
	@RequestMapping(value=Route.PRODUCT_UPDATE)
	public Context update(Product product) {
		Context context = new Context();
		
		try {
			boolean flag = getBaseService().update(product);
			if (flag) {
				context.setSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return context;
	}
	
	@ResponseBody
	@RequestMapping(value=Route.PRODUCT_DELETE)
	public Context delete(Product product) {
		Context context = new Context();
		
		try {
			boolean flag = getBaseService().delete(product);
			if (flag) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return context;
	}
	
	@RequestMapping(value=Route.PRODUCT_INDEX)
	public String index(Model model, Product product) {
		Context context = new Context();
		context.setMessage("产品首页");
		try {
			
			Pagable pagable = new Pagable(1, 10);
			pagable.setOrderBy("id DESC");
			
			context.setResult(getBaseService().query(null, pagable).getList());
		} catch (Exception e) {
			context.setSuccess(false);
			context.setMessage("获取产品数据失败");
			e.printStackTrace();
		}
		
		model.addAttribute("c", context);
		
		return WebContent.forword("product.index");
	}
	
	@ResponseBody
	@RequestMapping(value=Route.PRODUCT_FETCH_URL)
	public Context fetchUrl (Model model, String url) {
		Context context = new Context();
		context.setMessage("获取链接数据");
		try {
			FetchUrl fetchUrl = FetchUtil.get(url);
			context.setResult(fetchUrl);
		} catch (Exception e) {
			context.setSuccess(false);
			context.setMessage("获取链接数据失败");
			e.printStackTrace();
		}
		
		model.addAttribute("c", context);
		
		return context;
	}

}
