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
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<script type="text/javascript" src="js/scate.js" charset="utf-8"></script>
<script language="javascript" type="text/javascript"
	src="<%=basePath%>laydate/laydate.js" charset="utf-8"></script>
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
			<td bgcolor="#FFFFFF"><s:form action="scate/updateScate.action"
					name="myform" onsubmit="return check()">
					<table width="40%" border="0" align="center" cellpadding="4"
						cellspacing="1" bgcolor="#aec3de">
						<tr align="center" bgcolor="#F2FDFF">
							<td align="left" colspan="2" class="optiontitle">修改商品小类<input
								type="hidden" name="id" value="${id}" /></td>
						</tr>
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">商品大类</td>
							<td align="left"><s:select list="%{map.bcateList}"
									name="scate.bcateid" style="width: 160px" id="bcateid"
									listKey="bcateid" listValue="bcatename" theme="simple"
									value="%{scate.bcateid}"></s:select></td>
						</tr>
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">商品小类</td>
							<td align="left"><input type="text" name="scate.scatename"
								style="width: 160px" id="scatename" value="${scate.scatename}" /></td>
						</tr>
						<tr align="center" bgcolor="#ebf0f7">
							<td colspan="2"><input type="submit" name="Submit"
								value="提交" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset"
								name="Submit2" value="重置" /></td>
						</tr>
					</table>
				</s:form></td>
		</tr>
	</table>
</body>
</html>