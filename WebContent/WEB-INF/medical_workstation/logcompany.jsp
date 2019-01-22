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
<title>团检单位对账</title>
</head>

<body>
	<form id="form1" name="form1" method="post" action=""
		style="border: 1px solid #000; margin: 50px 140px;">
		<p align="center">&nbsp;</p>
		<p align="center">公司帐号 ：${logCompanylist.get(0).getName()}帐号余额：</p>
		<table width="500" border="1" align="center">
			<tr align="center">
				<td width="160">操作</td>
				<td width="100">金额</td>
				<td width="150">时间</td>
			</tr>
			<c:forEach items="${logCompanylist}" var="l" varStatus="s">
				<tr>
					<td>${l.operate}</td>
					<td>${l.money}</td>
					<td>${l.time}</td>
				</tr>
			</c:forEach>
			<tr align="center">
				<td width="160">资金存入</td>
				<td width="100">10000</td>
				<td width="150">2019-01-20 15:30:30</td>
			</tr>
			<tr align="center">
				<td width="160">团检付款</td>
				<td width="100">7000</td>
				<td width="150">2019-01-20 15:35:30</td>
			</tr>
			<tr align="center">
				<td width="160">结款支出</td>
				<td width="100">3000</td>
				<td width="150">2019-01-20 15:40:30</td>
			</tr>
		</table>
		<p align="center">&nbsp;</p>
		<p align="center">&nbsp;</p>
	</form>
</body>
</html>
