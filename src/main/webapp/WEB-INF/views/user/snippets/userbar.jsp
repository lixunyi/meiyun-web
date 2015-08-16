<%@page import="com.meiyun.core.Route"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="jumbotron">
	<div class="container">
	
		<div class="media">
	      <div class="media-left">
	        <a href="#">
	          <img class="media-object thumbnail" data-src="holder.js/64x64" alt="64x64" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PCEtLQpTb3VyY2UgVVJMOiBob2xkZXIuanMvNjR4NjQKQ3JlYXRlZCB3aXRoIEhvbGRlci5qcyAyLjYuMC4KTGVhcm4gbW9yZSBhdCBodHRwOi8vaG9sZGVyanMuY29tCihjKSAyMDEyLTIwMTUgSXZhbiBNYWxvcGluc2t5IC0gaHR0cDovL2ltc2t5LmNvCi0tPjxkZWZzPjxzdHlsZSB0eXBlPSJ0ZXh0L2NzcyI+PCFbQ0RBVEFbI2hvbGRlcl8xNGVlZDkzMzI3YiB0ZXh0IHsgZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQgfSBdXT48L3N0eWxlPjwvZGVmcz48ZyBpZD0iaG9sZGVyXzE0ZWVkOTMzMjdiIj48cmVjdCB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSIxNC41IiB5PSIzNi41Ij42NHg2NDwvdGV4dD48L2c+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="width: 144px; height: 144px;">
	        </a>
	      </div>
	      <div class="media-body">
	        <h1 class="media-heading">Jack Smith <small>#962</small></h1>
			<p>Co-Founder @Vungle - Advisor @Coin</p>
			<p>Jack Smith&#39;s profile on Product Hunt</p>
			</div>
	      <div class="media-right">
	        <a class="btn btn-default btn-lg" href="<%= Route.USER_PROFILE %>" role="button">设置</a>
	      </div>
	    </div>
	</div>
</div>

<div class="container">
	<ul class="nav nav-tabs text-center">
	  <li role="presentation" class="active"><a href="<%= Route.USER_DASHBORD %>">115 链接</a></li>
	  <li role="presentation"><a href="<%= Route.USER_TOPIC %>">5 主题</a></li>
	  <li role="presentation"><a href="<%= Route.USER_LABEL %>">43 标签</a></li>
	  <li role="presentation"><a href="<%= Route.USER_FOLLOWING %>">132 关注的人</a></li>
	  <li role="presentation"><a href="<%= Route.USER_FOLLOWER %>">546 粉丝</a></li>
	</ul>
</div>
