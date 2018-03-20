<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<title>${title }</title>
		<script type="text/javascript" src="js/jquery-1.3.2.min.js" charset="utf-8"></script>
		<script type="text/javascript" src="js/cartajax.js" charset="utf-8"></script>
	</head>
<%
	String message = (String) session.getAttribute("message");
	if (message == null) {
		message = "";
	}
	if (!message.trim().equals("")) {
		out.println("<script language='javascript'>");
		out.println("alert('" + message + "');");
		out.println("</script>");
	}
	session.removeAttribute("message");
%>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="block box">
			<div class="blank"></div>
			<div id="ur_here">
				当前位置:
				<a href=".">首页</a>
				<code>
					&gt;
				</code>
				购物流程
			</div>
		</div>
		<div class="blank"></div>
		<div class="block table">
			<div class="flowBox">
				<h6>
					<span>商品列表</span>
				</h6>
				<table width="99%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd" class="tab">
					<tr>
						<th bgcolor="#ffffff">
							商品名称
						</th>
						<th bgcolor="#ffffff">
							本店价
						</th>
						<th bgcolor="#ffffff">
							购买数量
						</th>
						<th bgcolor="#ffffff">
							小计
						</th>
						<th bgcolor="#ffffff">
							日期
						</th>
						<th bgcolor="#ffffff">
							操作
						</th>
					</tr>

					<s:iterator value="map.cartList">
						<tr>
							<td bgcolor="#ffffff" align="center" style="width: 300px;">
								<a href="index/detail.action?id=${goodsid }" target="_blank"><img style="width: 80px; height: 80px;"
										src="${goods.image }" border="0" title="${goods.goodsname }" /> </a>
								<br />
								<a href="index/detail.action?id=${goodsid }" target="_blank" class="f6">${goods.goodsname }</a>
							</td>
							<td align="center" bgcolor="#ffffff">
								￥${price }元
							</td>
							<td align="center" bgcolor="#ffffff">
								<input type="text" size="1" value="${num }" id="num" class="num" />
								<input type="hidden" value="${cartid }" id="cartid" class="cartid" />
								<input type="hidden" value="${sessionScope.userid }" id="userid" class="userid" />
							</td>
							<td align="center" bgcolor="#ffffff">
								￥<font color="#f9c100" id="gsum" class="gsum">${num*price }</font>元
							</td>
							<td align="center" bgcolor="#ffffff">
								${addtime }
							</td>
							<td align="center" bgcolor="#ffffff">
								<a
									href="javascript:if (confirm('您确实要把该商品移出购物车吗？')) location.href='<%=basePath%>index/deleteCart.action?id=${cartid}'; "
									class="f6">移除</a>
							</td>
						</tr>
					</s:iterator>
				</table>
				<table width="99%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
					<tr>
						<td bgcolor="#ffffff" align="right">
							购物金额小计 ￥<font color="#f9c100" id="total">${map.total }</font>元
						</td>
					</tr>
				</table>

				<table width="99%" align="center" border="0" cellpadding="5" cellspacing="0" bgcolor="#dddddd">
					<tr>
						<td bgcolor="#ffffff">
							<a href="index.jsp"><img src="themes/dapu/images/continue.gif" alt="continue" /> </a>
						</td>
						<td bgcolor="#ffffff" align="right">
							<a href="index/preCheckout.action"><img src="themes/dapu/images/checkout.gif" alt="checkout" />
							</a>
						</td>
					</tr>
				</table>
			</div>
			<div class="blank"></div>

			<div class="blank5"></div>
		</div>



		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
