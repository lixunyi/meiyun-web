<%@page import="com.meiyun.core.Route"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">美云</a>
    </div>
    <div class="navbar-collapse collapse" role="navigation">
      <ul class="nav navbar-nav">
    	<li><a href="<%=Route.TOPIC_INDEX %>">主题</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
       <c:if test="${loginUser == null}">
   		<li><a href="<%=Route.USER_LOGIN %>">登录</a></li>
     	<li><a href="<%=Route.USER_REGISTER %>">注册</a></li>
   	  </c:if>
   	  <c:if test="${loginUser != null}">
    	  <li class="dropdown">
           <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">${loginUser.title}<b class="caret"></b></a>
           <ul class="dropdown-menu">
             <li><a href="<%=Route.USER_DASHBORD %>">个人中心</a></li>
             <li><a href="<%=Route.USER_PROFILE %>">设置</a></li>
             <li><a href="<%=Route.USER_LOGOUT %>">退出</a></li>
           </ul>
         </li>
   	  </c:if>
      </ul>
    </div>
  </div>
</div>