<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>

<body>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<c:forEach items="${patientlist}" var="p" varStatus="s">
		<p style="margin-left: 500px;">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：${p.n1}</p>
		<p style="margin-left: 500px;">公&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;司：${p.n2}</p>
		<p style="margin-left: 500px;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：${p.sex}</p>
		<p style="margin-left: 500px;">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：${p.age}</p>
		<p style="margin-left: 500px;">身份证号：${p.ID}</p>
		<p style="margin-left: 500px;">手机号码：${p.phone}</p>
		<p style="margin-left: 500px;">条&nbsp;&nbsp;码&nbsp;&nbsp;号：${p.code}</p>
		<p style="margin-left: 500px;">体&nbsp;&nbsp;检&nbsp;&nbsp;号：${p.check_num}</p>
		<p style="margin-left: 500px;">体检时间：${p.time}</p>
		<p align="center">
			<a href="<%=path%>patient/findpatientall.handle?name=${p.n1}">返回</a>
		</p>
	</c:forEach>
</body>
</html>