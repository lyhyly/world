<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="themes/dapu/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/index.js"></script>
<div class="top_nav">
	<div class="block">

		<div class="bookmail">
			<s:if test="#session.userid == null">
				<font id="ECS_MEMBERZONE"> 欢迎光临本店，<a
					href="index/preLogin.action">[用户登录]</a>&nbsp;<a
					href="index/preReg.action">[用户注册]</a>
				</font>
			</s:if>
			<s:if test="#session.userid != null">
				<font id="ECS_MEMBERZONE"> 欢迎光临本店${sessionScope.username }， <a
					href="index/usercenter.action">[用户中心]</a>&nbsp; <a
					href="index/cart.action">[购物车]</a>&nbsp;<a href="index/exit.action">[退出系统]</a>
				</font>
			</s:if>
		</div>
	</div>
</div>
<div class="clearfix">
	<div class="block header">
		<div class="top clearfix">
			<a href="index.jsp" class="logo"><img
				src="themes/dapu/images/logo.gif"> </a>
			<div class="head_r">
				<div class="top_search">
					<form id="searchForm" name="searchForm" method="post"
						action="index/query.action" style="_position: relative; top: 5px;">
						<div class="headSearch_input">
							<input name="name" type="text" id="keyword" class="keyword"
								value="" /> <input value="" id="seachbtn" type="submit" />
						</div>
					</form>
					<div style="clear: both"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<div style="clear: both"></div>

<div class="menu_box clearfix">
	<div class="block main_menu">
		<div class="menu">
			<a href="index.jsp" class="cur">网站首页<span></span></a> <a
				href="index/article.action" class="cur">网站新闻<span></span></a> <a
				href="index/special.action" class="cur">特价商品<span></span></a> <a
				href="index/recommend.action" class="cur">推荐商品<span></span></a> <a
				href="index/all.action" class="cur">全部商品<span></span></a>
		</div>
	</div>
</div>
<div style="clear: both"></div>











