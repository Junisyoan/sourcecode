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
<title>添加参数</title>
</head>
<body>
	<form action="<%=path%>param/addparam.handle" method="post">
		<p align="center">&nbsp;</p>
		<p align="center">&nbsp;</p>
		<p align="center">&nbsp;</p>
		<p align="center">
			上级参数ID：<input name="pid" type="text" />
		</p>
		<p style="margin-left: 567px;">
			参数名字：<input name="name" type="text" />
		</p>
		<p align="center">
			<input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="<%=path%>param/findAllParam.handle"><input type="button"
				value="返回"></a>
		</p>
	</form>
</body>
</html>