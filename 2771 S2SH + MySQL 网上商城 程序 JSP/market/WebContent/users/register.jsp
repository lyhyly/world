<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<title>${title }</title>
		<script type="text/javascript" src="js/users.js" charset="utf-8"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
		<script type="text/javascript" src="js/jquery-1.3.2.min.js" charset="utf-8"></script>
		<script type="text/javascript" src="js/valation.js" charset="utf-8"></script>
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
				<a href="<%=basePath%>">首页</a>
				<code>
					&gt;
				</code>
				用户注册
			</div>
		</div>
		<div class="blank"></div>
		<div class="block">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>用户注册</span>
					</h3>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr valign="top">
							<td bgcolor="#FFFFFF" align="center">
								<form action="index/reg.action" method="post" name="myform" id="myform">
									<table width="60%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												用户名：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input type="text" name="users.username" size="25" class="inputBg" id="username" />
												<font color="red" id="usernamerror"></font>
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												密码：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input name="users.password" type="password" size="25" class="inputBg" id="password" />
												<font color="red" id="passworderror"></font>
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												校验密码：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input name="repassword" type="password" size="25" class="inputBg" id="repassword" />
												<font color="red" id="repassworderror"></font>
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												姓名：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input name="users.realname" type="text" size="25" class="inputBg" id="realname" />
												<font color="red" id="realnamerror"></font>
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												性别：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<select name="users.sex" id="sex"  class="inputBg">
													<option value="男">男</option>
													<option value="女">女</option>
												</select>
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												出生日期：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input name="users.birthday" type="text" size="25" class="inputBg" id="birthday" readonly="readonly" onclick="WdatePicker()" />
												<font color="red" id="birthdayerror"></font>
											</td>
										</tr>
										<tr>
											<td width="28%" align="right" bgcolor="#FFFFFF">
												联系方式：
											</td>
											<td width="76%" align="left" bgcolor="#FFFFFF">
												<input name="users.contact" type="text" size="25" class="inputBg" id="contact" />
												<font color="red" id="contacterror"></font>
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center" bgcolor="#FFFFFF">
												<input type="button" id="btn" class="bnt_blue_1" style="border: none;" value="确认注册" />
											</td>
										</tr>
									</table>
								</form>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="blank5"></div>
		</div>


		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
