<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>体检综合查询</title>
</head>

<body>
	<form id="form1" name="form1" method="post"
		action="<%=path%>demo/DocAction!searchDoc.action"
		style="border: 1px solid #000; margin: 50px 140px;">
		<p align="center">&nbsp;</p>
		<p align="center">
			姓名 <input type="text" name="doc.title" id="doc.title"
				style="height: 20px; width: 145px; font-size: 15px;" /> 手机号 <input
				type="text" name="doc.account" id="doc.account"
				style="height: 20px; width: 145px; font-size: 15px;" />
		</p>
		<p align="center">
			体检时间<input type="date" name="doc.fronttime" id="doc.fronttime" />
			条码号 <input type="text" name="doc.title" id="doc.title"
				style="height: 20px; width: 145px; font-size: 15px;" /> <input
				type="submit" value="查询"
				style="height: 25px; width: 100px; font-size: 15px;" />
		</p>
		<table width="900" border="1" align="center">
			<tr align="center">
				<td width="150">体检人姓名</td>
				<td width="150">体检人信息</td>
				<td width="150">体检项目信息</td>
				<td width="150">体检小结信息</td>
				<td width="150">体检总结信息</td>
				<td width="150">体检报告预览</td>
			</tr>
			<tr align="center">
				<td width="150">张三</td>
				<td width="150"><input type="button" value="查看"
					style="font-size: 16px; width: 100px;" /></td>
				<td width="150"><input type="button" value="查看"
					style="font-size: 16px; width: 100px;" /></td>
				<td width="150"><input type="button" value="查看"
					style="font-size: 16px; width: 100px;" /></td>
				<td width="150"><input type="button" value="查看"
					style="font-size: 16px; width: 100px;" /></td>
				<td width="150"><input type="button" value="查看"
					style="font-size: 16px; width: 100px;" /></td>
			</tr>
		</table>
		<p align="center">
			<input type="button" value="上一页"
				style="height: 25px; width: 145px; font-size: 15px;" /> <input
				type="button" value="下一页"
				style="height: 25px; width: 145px; font-size: 15px;" />
		</p>
		<p align="center">&nbsp;</p>
	</form>
</body>
</html>

