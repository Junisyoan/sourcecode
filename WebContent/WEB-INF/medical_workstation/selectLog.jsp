<%@ page language="java" import="java.util.*"
	contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
<link rel="stylesheet" href="<%=path%>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path%>css/style.css" />
<title>日志查看</title>
</head>

<body>

	<div class="Manager_style">
		<span class="title_name">日志查看</span>
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>日志表ID</th>
					<th>用户表ID</th>
					<th>具体操作</th>
					<th>操作时间</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				</tr>
				<c:forEach items="${loglist}" var="l" varStatus="s">
					<tr>
						<td>${s.index + 1}</td>
						<td>${l.log_id}</td>
						<td>${l.user_id}</td>
						<td>${l.opera}</td>
						<td>${l.time}</td>
						<td><a href="<%=path%>log/delLog.handle?log_id=${l.log_id}">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>