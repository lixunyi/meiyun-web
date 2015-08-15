<%@page import="com.meiyun.core.Route"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.getRequestDispatcher(Route.PRODUCT_INDEX).forward(request, response);
%>
