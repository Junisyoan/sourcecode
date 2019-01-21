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
<title>体检人员查询</title>
</head>

<body>
	<form id="form1" name="form1" method="post" action="<%=path%>"
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
				style="height: 25px; width: 100px; font-size: 15px;" />&nbsp;&nbsp;<input
				type="submit" value="Excel导出"
				style="height: 25px; width: 100px; font-size: 15px;" />
		</p>
		<table width="1000" border="1" align="center">
			<tr align="center">
				<td width="100">姓名</td>
				<td width="150">公司</td>
				<td width="50">性别</td>
				<td width="50">年龄</td>
				<td width="170">身份证号</td>
				<td width="130">手机号码</td>
				<td width="130">条码号</td>
				<td width="130">体检号</td>
			</tr>
			<c:forEach items="${patientlist}" var="p" varStatus="s">
				<tr>
					<td>${p.name}</td>
					<td>${p.company_id}</td>
					<td>${p.sex}</td>
					<td>${p.age}</td>
					<td>${p.ID}</td>
					<td>${p.phone}</td>
					<td>${p.code}</td>
					<td>${p.check_num}</td>
				</tr>
			</c:forEach>
			<tr align="center">
				<td>张三疯</td>
				<td>武当创新无限科技有限公司</td>
				<td>男</td>
				<td>123</td>
				<td>3508221896010111111234</td>
				<td>18008208820</td>
				<td>123456789</td>
				<td>0000000001</td>
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

