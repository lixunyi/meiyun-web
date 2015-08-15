<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<title>美云 - 用户中心</title>
<%@ include file="../snippets/style.jsp" %>
</head>
<body>
<%@ include file="../header.jsp" %>
<%@ include file="snippets/userbar.jsp" %>

	<div class="toolbar">
		<div class="container">
			<ul class="list-inline">
				<li class="pull-right"><a href="<%= Route.PRODUCT_NEW %>" class="btn btn-info">分享产品</a></li>
			</ul>
		</div>
	</div>

	<div class="container">
		<div class="panel panel-default">
		  <c:if test="${c != null && c.result != null}">
		  <ul class="list-group">
		  	<c:forEach items="${c.result}" var="t">
		    <%@ include file="../snippets/product_list.jsp" %>
			</c:forEach>
		  </ul>
		  </c:if>
		</div>
	</div>
	
<%@ include file="../snippets/scripts.jsp" %>
</body>
</html>
