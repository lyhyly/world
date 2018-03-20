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
<script type="text/javascript" src="themes/dapu/js/action.js"></script>
<script type="text/javascript" src="themes/dapu/js/mzp-packed-me.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href=".">首页</a>
			<code>&gt;</code>
			<a href="index/bcate.action?id=${map.goods.bcate.bcateid }">${map.goods.bcate.bcatename }</a>
			<code>&gt;</code>
			<a href="index/bcate.action?id=${map.goods.scate.scateid }">${map.goods.scate.scatename }</a>
			<code>&gt;</code>
			${map.goods.goodsname }
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
									style="padding-top: 10px; padding-right: 6px; cursor: pointer;"></span>
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
										src="${image }" alt="${goodsname }"
										class="B_blue" /></a></li>
								<li><a href="goods.php?id=24"
									title="${goodsname }">${goodsname }</a><br />售价：<font
									class="f1">￥${price }元</font><br /></li>
							</ul>
						</s:iterator>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>


		<div class="AreaR">

			<div id="goodsInfo" class="clearfix">


				<div class="imgInfo">
					<a href="${map.goods.image }" id="zoom1"
						class="MagicZoom MagicThumb" title="${map.goods.goodsname }">
						<img src="${map.goods.image }" alt="${map.goods.goodsname }"
						width="360px;" height="360px" />
					</a>
					<div class="blank5"></div>
					<div class="blank"></div>
				</div>
				<div class="textInfo">
					<form action="index/addCart.action" method="post"
						name="ECS_FORMBUY" id="ECS_FORMBUY">
						<h1 class="clearfix">${map.goods.goodsname }</h1>
						<ul class="ul2 clearfix">
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>本店售价：</strong><font class="shop" id="ECS_SHOPPRICE">￥${map.goods.price }元</font>
									<font class="market">￥${map.goods.marketprice }元</font>
								</dd>
							</li>
							<li class="clearfix">
								<dd>

									<strong>商品大类：</strong><a
										href="index/bcate.action?id=${map.goods.bcate.bcateid }">${map.goods.bcate.bcatename }</a>
								</dd>
							</li>
							<li class="clearfix">
								<dd>

									<strong>商品子类：</strong><a
										href="index/bcate.action?id=${map.goods.scate.scateid }">${map.goods.scate.scatename }</a>
								</dd>
							</li>
							<li class="clearfix">
								<dd>

									<strong>商品库存：</strong> ${map.goods.storage }
								</dd>
							</li>
							<li class="clearfix">
								<dd>

									<strong>商品销量：</strong> ${map.goods.sellnum }
								</dd>
							</li>
							<li class="clearfix">
								<dd>

									<strong>上架时间：</strong>${map.goods.addtime }
								</dd>
							</li>
							<li class="clearfix">
								<dd>
									<strong>商品点击数：</strong>${map.goods.hits }
								</dd>
							</li>
						</ul>
						<ul class="bnt_ul">
							<li class="clearfix">
								<dd>
									<strong>购买数量：</strong> <input name="cart.num" type="text"
										id="number" value="1" size="4" style="border: 1px solid #ccc;" />
									<input type="hidden" name="cart.goodsid"
										value="${map.goods.goodsid }" /> <input type="hidden"
										name="cart.price" value="${map.goods.price }" />
								</dd>
							</li>
							<li class="padd"><input type="image"
								src="themes/dapu/images/goumai2.gif" /></li>
						</ul>
					</form>
				</div>
			</div>
			<div class="blank"></div>
			<div class="box">
				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2>商品描述</h2>
					</div>
				</div>
				<div class="box_1">
					<div id="com_v" class="  " style="padding: 6px;"></div>
					<div id="com_h">
						<blockquote>${map.goods.contents }</blockquote>
					</div>
				</div>
			</div>
			<div class="blank"></div>


			<div class="blank5"></div>
			<script type="text/javascript" src="js/transport.js"></script>
			<script type="text/javascript" src="js/utils.js"></script>
			<div id="ECS_COMMENT">
				<div class="box">
					<div class="box_1">
						<h3>
							<span class="text">用户评论</span>(共<font class="f1">${map.tnum }</font>条评论)
						</h3>
						<div class="boxCenterList clearfix" style="height: 1%;">
							<ul class="comments">
								<s:iterator value="map.topicList">
									<li class="word"><font class="f2"><s:property
												value="users.username" /> </font> <font class="f3">(<s:property
												value="addtime" />)
									</font> <br /> <img
										src="themes/dapu/images/stars<s:property value="num"/>.gif" />
										<p>
											<s:property value="contents" />
										</p></li>
								</s:iterator>
							</ul>
							<div class="blank5"></div>
							<div class="commentsList">
								<form action="index/addTopic.action" method="post"
									name="commentForm" id="commentForm">
									<table width="710" border="0" cellspacing="5" cellpadding="0">
										<tr>
											<td width="64" align="right">用户名：</td>
											<td width="631">${sessionScope.username }</td>
										</tr>
										<tr>
											<td align="right">评价等级：</td>
											<td><input name="topic.num" type="radio" value="1"
												id="comment_rank1" /> <img
												src="themes/dapu/images/stars1.gif" /> <input
												name="topic.num" type="radio" value="2" id="comment_rank2" />
												<img src="themes/dapu/images/stars2.gif" /> <input
												name="topic.num" type="radio" value="3" id="comment_rank3" />
												<img src="themes/dapu/images/stars3.gif" /> <input
												name="topic.num" type="radio" value="4" id="comment_rank4" />
												<img src="themes/dapu/images/stars4.gif" /> <input
												name="topic.num" type="radio" value="5" checked="checked"
												id="comment_rank5" /> <img
												src="themes/dapu/images/stars5.gif" /></td>
										</tr>
										<tr>
											<td align="right" valign="top">评论内容：</td>
											<td><textarea name="topic.contents" class="inputBorder"
													style="height: 50px; width: 620px;"></textarea> <input
												type="hidden" name="topic.goodsid"
												value="${map.goods.goodsid }" /></td>
										</tr>
										<tr>
											<td colspan="2"><input name="" type="submit"
												value="评论咨询" class="f_r bnt_blue_1"
												style="margin-right: 8px;" /></td>
										</tr>
									</table>
								</form>
							</div>

						</div>
					</div>
				</div>
				<div class="blank5"></div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
