<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@taglib
	prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/four.css" rel="stylesheet" type="text/css" />
</head>
<%
	String message = (String) request.getAttribute("message");
	if (message == null) {
		message = "";
	}
	if (!message.trim().equals("")) {
		out.println("<script language='javascript'>");
		out.println("alert('" + message + "');");
		out.println("</script>");
	}
	request.removeAttribute("message");
%><body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td bgcolor="#FFFFFF"><table width="96%" border="0"
					align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
					<tr align="left" bgcolor="#F2FDFF">
						<td colspan="20" class="optiontitle">商品信息列表</td>
					</tr>
					<tr align="center">
						<td align="center" bgcolor="#ebf0f7">型号名称</td>
						<td align="center" bgcolor="#ebf0f7">商品大类</td>
						<td align="center" bgcolor="#ebf0f7">商品小类</td>
						<td align="center" bgcolor="#ebf0f7">市场价</td>
						<td align="center" bgcolor="#ebf0f7">本站价</td>
						<td align="center" bgcolor="#ebf0f7">是否推荐</td>
						<td align="center" bgcolor="#ebf0f7">是否特价</td>
						<td align="center" bgcolor="#ebf0f7">商品库存</td>
						<td align="center" bgcolor="#ebf0f7">上架日期</td>
						<td align="center" bgcolor="#ebf0f7">商品销量</td>
						<td align="center" bgcolor="#ebf0f7">点击数</td>
					</tr>
					<s:iterator value="list" id="list">
						<tr align="center" bgcolor="#FFFFFF">
							<td align="center"><s:property value="goodsname" /></td>
							<td align="center"><s:property value="bcate.bcatename" /></td>
							<td align="center"><s:property value="scate.scatename" /></td>
							<td align="center"><s:property value="marketprice" /></td>
							<td align="center"><s:property value="price" /></td>
							<td align="center"><s:property value="recommend" /></td>
							<td align="center"><s:property value="special" /></td>
							<td align="center"><s:property value="storage" /></td>
							<td align="center"><s:property value="addtime" /></td>
							<td align="center"><s:property value="sellnum" /></td>
							<td align="center"><s:property value="hits" /></td>
						</tr>
					</s:iterator>
					<tr align="right" bgcolor="#ebf0f7">
						<td colspan="20"><form action="goods/queryGoodsByCond.action"
								name="myform" method="post">
								查询条件<select name="cond" style="width: 100px"><option
										value="goodsname">按型号名称查询</option>
									<option value="bcateid">按商品大类查询</option>
									<option value="scateid">按商品小类查询</option>
									<option value="marketprice">按市场价查询</option>
									<option value="price">按本站价查询</option>
									<option value="recommend">按是否推荐查询</option>
									<option value="special">按是否特价查询</option>
									<option value="storage">按商品库存查询</option>
									<option value="addtime">按上架日期查询</option>
									<option value="sellnum">按商品销量查询</option>
									<option value="hits">按点击数查询</option></select>关键字<input type="text"
									name="name" style="width: 100px" /><input type="submit"
									value="查询" />
							</form></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>