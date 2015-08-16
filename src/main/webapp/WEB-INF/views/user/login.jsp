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

	<div class="container" style="margin-top: 50px;">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div id="alert" class="alert alert-danger alert-dismissible hide" role="alert">
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  <strong></strong>
				</div>
				
				<form id="login-form" action="javascript:void(0)">
				  <div class="form-group">
				    <label for="username">用户名或邮箱</label>
				    <input type="text" class="form-control input-lg" id="username" name="username" placeholder="用户名 、邮箱、手机号" autocomplete="off">
				  </div>
				  <div class="form-group">
				    <label for="password">密码<a href="#">（忘记密码）</a></label>
				    <input type="password" class="form-control input-lg" id="password" name="password" placeholder="登录密码" autocomplete="off">
				  </div>
				  <button id="submit" data-loading-text="正在登录..." class="btn btn-primary">登 录</button>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	
<%@ include file="../snippets/scripts.jsp" %>
<script src="/assets/js/user/login.js"></script>
</body>
</html>
