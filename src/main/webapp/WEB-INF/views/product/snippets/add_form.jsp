<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form id="product-form" action="javascript:void()">
   <div class="form-group">
    <label for="url">链接</label>
    <input type="text" class="form-control" id="url" name="url" placeholder="网站URL">
  </div>
  <div class="form-group">
    <label for="title">标题</label>
    <input type="text" class="form-control" id="title" name="title" placeholder="产品名称">
  </div>
  <div class="form-group">
    <label for="comment">描述</label>
    <textarea rows="" cols="" class="form-control" id="comment" name="comment" placeholder="标签描述信息"></textarea>
  </div>
  <div class="form-group">
    <label for="topic">主题</label>
    <select id="topic" name="topicId" class="form-control">
      <c:forEach items="${c.result}" var="t">
	  <option value="${t.id}">${t.title}</option>
	  </c:forEach>
	</select>
  </div>
  
  <button id="submit" class="btn btn-default">添加站点</button>
</form>