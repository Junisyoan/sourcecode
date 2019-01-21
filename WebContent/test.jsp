<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试</title>
</head>
<body>

	<a href="<%=path%>log/findAllLog.handle">测试</a>
	<a href="<%=path%>doctor/index.handle">doc测试</a>

	<a href="<%=path%>logcompany/findcompanylog.handle">测试</a>

</body>

</html>
