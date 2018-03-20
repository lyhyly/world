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
										日期
									</th>
									<th bgcolor="#ffffff">
										总金额
									</th>
									<th bgcolor="#ffffff">
										状态
									</th>
									<th bgcolor="#ffffff">
										送货地址
									</th>
									<th bgcolor="#ffffff">
										收件人
									</th>
									<th bgcolor="#ffffff">
										联系方式
									</th>
									<th bgcolor="#ffffff">
										查看详情
									</th>
									<th bgcolor="#ffffff">
										操作
									</th>
								</tr>
								<s:iterator value="map.ordersList">
									<tr>
										<td bgcolor="#ffffff" align="center">
											<s:property value="ordercode" />
										</td>
										<td bgcolor="#ffffff" align="center">
											<s:property value="addtime" />
										</td>
										<td bgcolor="#ffffff" align="center">
											￥
											<s:property value="total" />
											元
										</td>
										<td bgcolor="#ffffff" align="center">
											<s:property value="status" />
										</td>
										<td bgcolor="#ffffff" align="center">
											<s:property value="address" />
										</td>
										<td bgcolor="#ffffff" align="center">
											<s:property value="receiver" />
										</td>
										<td bgcolor="#ffffff" align="center">
											<s:property value="contact" />
										</td>
										<td bgcolor="#ffffff" align="center">
											<a href="index/orderdetail.action?id=<s:property value="ordercode" />">查看详情</a>
										</td>
										<td bgcolor="#ffffff" align="center">
											<s:if test="status == '未付款'">
												<a href="index/prePay.action?id=${ordersid }">付款</a>
												&nbsp;&nbsp;&nbsp;
												<a href="javascript:if (confirm('您确实要删除此订单吗？')) location.href='<%=basePath%>index/deleteOrders.action?id=${ordersid }'; ">删除订单</a>
											</s:if>
											<s:if test="status == '发货'">
												<a href="index/over.action?id=${ordersid }">收货</a>
											</s:if>
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
