<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<title>添加产品</title>
<%@ include file="../snippets/style.jsp" %>
</head>
<body>
	<%@ include file="../header.jsp"%>
	
	<div class="pagehead">
		<div class="container">
			<div class="pagehead-body pagehead-title">
			<span class="text-muted">创建标签</span>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">添加标签</div>
			<div class="panel-body">
				<%@ include file="snippets/add_form.jsp"%>
			</div>
		</div>
	</div>
	
<%@ include file="../snippets/scripts.jsp" %>
<script src="/assets/js/label/add.js"></script>
</body>
</html>
