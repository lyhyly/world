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

	</head>

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
				用户中心
			</div>
		</div>
		<div class="blank"></div>

		<div class="blank"></div>
		<div class="block clearfix">

			<div class="AreaL">
				<div class="box">
					<div class="box_1">
						<div class="userCenterBox">
							<jsp:include page="usermenu.jsp"></jsp:include>
						</div>
					</div>
				</div>
			</div>


			<div class="AreaR">
				<div class="box">
					<div class="box_1">
						<div class="userCenterBox boxCenterList clearfix" style="_height: 1%;">
							<h5>
								<span>我的订单</span>
							</h5>
							<div class="blank"></div>
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
								<tr>
									<th bgcolor="#ffffff">
										订单号
									</th>
									<th bgcolor="#ffffff">
										图书
									</th>
									<th bgcolor="#ffffff">
										单价
									</th>
									<th bgcolor="#ffffff">
										数量
									</th>
								</tr>
								<s:iterator value="map.itemList">
									<tr>
										<td bgcolor="#ffffff" align="center" width="20%">
											<s:property value="ordercode" />
										</td>
										<td bgcolor="#ffffff" align="center">
											<a href="index/detail.action?id=<s:property value="goodsid" />"><s:property value="goods.goodsname" />
											</a>
										</td>
										<td bgcolor="#ffffff" align="center">
											￥
											<s:property value="price" />
											元
										</td>
										<td bgcolor="#ffffff" align="center">
											<s:property value="num" />
										</td>
									</tr>
								</s:iterator>
							</table>
							<div class="blank5"></div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="blank"></div>



		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
