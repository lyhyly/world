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
<script type="text/javascript" src="js/goods.js" charset="utf-8"></script>
<script language="javascript" type="text/javascript"
	src="<%=basePath%>laydate/laydate.js" charset="utf-8"></script>
<link href="css/four.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js" charset="utf-8"></script>
		<script type="text/javascript" charset="utf-8">
			$(function(){            
    			$("#bcateid").change(function(){                
        			$.getJSON("ajax/ajax.action",{id:$(this).val()},function(myJSON){                    
	            		var myOptions="";                    
	           			for(var i=0;i<myJSON.length;i++){                       
	                		 myOptions += '<option value="' + myJSON[i].optionValue + '">' + myJSON[i].optionDisplay + '</option>';                    
	                 	}                   
	             		$("#scateid").empty();                    
	             		$("#scateid").html(myOptions);                
        			});            
    			});            
			}) 
		</script>
		<script type="text/javascript">
function selimage(){
window.open("<%=basePath%>saveimage.jsp","","toolbar=no,location=no,directories=no,status=no,menubar=no,resizable=yes,copyhistory=no,scrollbars=yes,width=400,height=240,top="+(screen.availHeight-240)/2+",left="+(screen.availWidth-400)/2+"");}
</script>
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
			<td bgcolor="#FFFFFF"><s:form action="goods/updateGoods.action"
					name="myform" onsubmit="return check()">
					<table width="60%" border="0" align="center" cellpadding="4"
						cellspacing="1" bgcolor="#aec3de">
						<tr align="center" bgcolor="#F2FDFF">
							<td align="left" colspan="2" class="optiontitle">修改商品<input
								type="hidden" name="id" value="${id}" /></td>
						</tr>
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">型号名称</td>
							<td align="left"><input type="text" name="goods.goodsname"
								style="width: 160px" id="goodsname" value="${goods.goodsname}" /></td>
						</tr>
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">商品图片</td>
							<td align="left"><input type="text" name="goods.image"
								style="width: 160px" id="image" value="${goods.image}"
								onclick="selimage();" readonly="readonly" /></td>
						</tr>
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">商品大类</td>
							<td align="left">
								<select name="goods.bcateid" style="width: 160px" id="bcateid">
										<option value="">
											---请选择商品大类---
										</option>
										<s:iterator value="map.bcateList">
										<option value="${bcateid }">${bcatename }</option>
										</s:iterator>
								</select>
							</td>
						</tr>
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">商品小类</td>
							<td align="left">
							<select name="goods.scateid" style="width: 160px" id="scateid">
										<option value="">
											---请选择商品小类---
										</option>
								</select>
							</td>
						</tr>
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">市场价</td>
							<td align="left"><input type="text" name="goods.marketprice"
								style="width: 160px" id="marketprice"
								value="${goods.marketprice}" /></td>
						</tr>
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">本站价</td>
							<td align="left"><input type="text" name="goods.price"
								style="width: 160px" id="price" value="${goods.price}" /></td>
						</tr>
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">是否推荐</td>
							<td align="left"><input type="radio" name="goods.recommend"
								id="recommend" value="是" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="radio" name="goods.recommend" id="recommend" value="否" />否</td>
						</tr>
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">是否特价</td>
							<td align="left"><input type="radio" name="goods.special"
								id="special" value="是" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="radio" name="goods.special" id="special" value="否" />否</td>
						</tr>
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">商品库存</td>
							<td align="left"><input type="text" name="goods.storage"
								style="width: 160px" id="storage" value="${goods.storage}" /></td>
						</tr>
						<tr align="center" bgcolor="#F2FDFF">
							<td width="20%" align="right">商品介绍</td>
							<td align="left"><script type="text/javascript"
									src="ckeditor/ckeditor.js"></script>
								<textarea cols="80" name="goods.contents" id="contents"
									rows="10">${goods.contents}</textarea>
								<script type="text/javascript">
									CKEDITOR.replace('contents', {
										language : 'zh-cn'
									});
								</script></td>
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