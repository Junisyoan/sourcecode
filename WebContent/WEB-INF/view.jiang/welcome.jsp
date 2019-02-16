<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="<%=path%>js/jquery-1.4.2.min.js"></script>
<title>系统首页</title>
</head>
<body>
	<h1 align="center">&nbsp;</h1>
	<h1 align="center">&nbsp;</h1>
	<h1 align="center">欢迎使用团检工作后台</h1>
</body>
</html>