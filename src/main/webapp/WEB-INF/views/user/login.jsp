<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<title>美云 - 用户登录</title>
<%@ include file="../snippets/style.jsp" %>
</head>
<body>
<%@ include file="../header.jsp" %>

	<div class="container">
		<div id="alert" class="alert alert-warning" role="alert"></div>
		
		<%@ include file="snippets/login_form.jsp" %>
	
	</div>
	
<%@ include file="../snippets/scripts.jsp" %>
<script src="/assets/js/user/login.js"></script>
</body>
</html>
