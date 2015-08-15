package com.meiyun.core;

public interface Route {
	
	String HOME_INDEX 			= "/about";
	String HOME_APP 			= "/app";
	String HOME_COPYRIGHT 		= "/copyright";
	String HOME_FAQ 			= "/faq";
	String HOME_HELP 			= "/help";

	String LABEL_INDEX 			= "/label";
	String LABEL_NEW 			= "/label/new";
	String LABEL_UPDATE 		= "/label/edit/{id}";
	String LABEL_DELETE 		= "/label/delete/{id}";
	String LABEL_SEARCH 		= "/label/search";

	String PRODUCT_NEW 			= "/product/new";
	String PRODUCT_DELETE 		= "/product/delete/{id}";
	String PRODUCT_UPDATE		= "/product/edit/{id}";
	String PRODUCT_INDEX		= "/product";
	String PRODUCT_SEARCH 		= "/product/search";
	String PRODUCT_FETCH_URL 	= "/product/fetch";
	
	String TOPIC_NEW 			= "/topic/new";
	String TOPIC_DETAIL			= "/topic/{id}";
	String TOPIC_DELETE 		= "/topic/delete/{id}";
	String TOPIC_UPDATE 		= "/topic/edit/{id}";
	String TOPIC_INDEX 			= "/topic";
	String TOPIC_SEARCH 		= "/topic/search";
	
	String USER_LOGIN 			= "/user/login";
	String USER_REGISTER 		= "/user/register";
	String USER_DASHBORD 		= "/user/dashbord";
	String USER_LOGOUT 			= "/user/logout";
	String USER_FORGOT 			= "/user/forgot";
	String USER_FOLLOWER		= "/user/follower";
	String USER_FOLLOWING		= "/user/following";
	String USER_LABEL 			= "/user/label";
	String USER_PROFILE			= "/user/profile";
	String USER_TOPIC			= "/user/topic";
}
