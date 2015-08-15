<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="label-form" method="post" action="javascript:void(0)">
  <div class="form-group">
    <label for="title">标题</label>
    <input type="text" class="form-control" id="title" name="title" placeholder="标签名称">
  </div>
  <div class="form-group">
    <label for="comment">描述</label>
    <textarea class="form-control" id="comment" name="comment" placeholder="标签描述信息"></textarea>
  </div>
  <button id="submit" class="btn btn-default">添加</button>
</form>