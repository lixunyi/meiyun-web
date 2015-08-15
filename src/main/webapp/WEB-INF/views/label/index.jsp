<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

	<div class="toolbar">
		<div class="container">
			<ul class="list-inline">
				<li class="pull-right"><a href="<%= Route.LABEL_NEW %>" class="btn btn-info">添加标签</a></li>
			</ul>
		</div>
	</div>

	<div class="container">
		<div class="panel panel-default">
		  <c:if test="${c != null && c.result != null}">
		  <ul class="list-group">
		  	<c:forEach items="${c.result}" var="t">
		    <li class="list-group-item">
		    	<div class="media">
			      <div class="media-body">
			        <h4 class="media-heading">${t.title }</h4>
			        ${t.comment}
			      </div>
			    </div>
		    </li>
		    </c:forEach>
		  </ul>
		  </c:if>
		</div>
		</div>
		
<%@ include file="../snippets/scripts.jsp" %>
</body>
</html>
