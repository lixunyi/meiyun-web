<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="https://meiyun.io" prefix="my" %>
<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<title>美云</title>
<%@ include file="../snippets/style.jsp" %>	
</head>

<body>
<%@ include file="../header.jsp" %>

	<div class="pagehead">
		<div class="container">
			<div class="pagehead-body pagehead-title">
			<span class="text-muted">分享你喜欢的站点</span>
			</div>
			<div class="pagehead-right"><a href="<%= Route.PRODUCT_NEW %>" class="btn btn-info">分享产品</a></div>
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
