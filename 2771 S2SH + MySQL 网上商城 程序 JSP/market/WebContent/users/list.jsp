<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="index.jsp">首页</a>
			<code>&gt;</code>
			商品列表
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<div id="category_tree">
				<div class="tit">所有商品分类</div>
				<dl class="clearfix">
					<div class="box1 cate" id="cate">
						<s:iterator value="map.cateList" status="status">
							<h1 onclick="tab(<s:property value="%{#status.index}"/>)"
								style="border-top: none">
								<span class="f_l"><img
									src="themes/dapu/images/btn_fold.gif"
									style="padding-top: 10px; padding-right: 6px; cursor: pointer;" /></span>
								<a href="index/bcate.action?id=${bcateid }" class="  f_l">${bcatename }</a>
							</h1>
							<ul style="display: none">
								<s:iterator value="scateList">
									<li><a href="index/scate.action?id=${scateid }">${scatename }</a></li>
								</s:iterator>
							</ul>
							<div style="clear: both"></div>
						</s:iterator>
					</div>
				</dl>
			</div>
			<div class="blank"></div>

			<script type="text/javascript">
				obj_h4 = document.getElementById("cate").getElementsByTagName(
						"h4");
				obj_ul = document.getElementById("cate").getElementsByTagName(
						"ul");
				obj_img = document.getElementById("cate").getElementsByTagName(
						"img");
				function tab(id) {
					var css = function(obj, attr) {
						var at = obj.currentStyle ? obj.currentStyle[attr]
								: getComputedStyle(obj, null)[attr];
						//alert(at);
						return at;
					}
					if (css(obj_ul.item(id), "display") == "none") {
						obj_ul[id].style.display = "block";
						obj_img.item(id).src = "themes/dapu/images/btn_fold.gif";
						return false;
					} else
						(css(obj_ul.item(id), "display") == "block")
					{

						obj_ul[id].style.display = "none"
						obj_img.item(id).src = "themes/dapu/images/btn_unfold.gif"
					}
				}
			</script>

			<div class="box" id='history_div'>
				<div class="box_1">
					<h3>
						<span>热卖商品</span>
					</h3>
					<div class="boxCenterList clearfix" id='history_list'>
						<s:iterator value="map.hotList">
							<ul class="clearfix">
								<li class="goodsimg"><a href="goods.php?id=24"><img
										src="${image }" alt="${goodsname }" class="B_blue" /></a></li>
								<li><a href="goods.php?id=24" title="${goodsname }">${goodsname }</a><br />售价：<font
									class="f1">￥${price }元</font><br /></li>
							</ul>
						</s:iterator>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>


		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>商品列表</span>
					</h3>
					<div class="clearfix goodsBox"
						style="border: none; padding: 11px 0 10px 0px;">
						<s:iterator value="map.goodsList">
							<div class="goodsItem">
								<a href="index/detail.action?id=${goodsid }"><img
									src="${image }" alt="${goodsname}" class="goodsimg" /></a><br />
								<p>
									<a href="index/detail.action?id=${goodsid }"
										title="${goodsname}">${goodsname}</a>
								</p>
								市场价：<font class="market_s">￥${marketprice }元</font><br /> 本店价：<font
									class="shop_s">￥${price }元</font><br />
							</div>
						</s:iterator>
					</div>
				</div>
				<div class="box_1">
					<h3>
						<span>${html }</span>
					</h3>
				</div>
			</div>
			<div class="blank5"></div>
		</div>

	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
