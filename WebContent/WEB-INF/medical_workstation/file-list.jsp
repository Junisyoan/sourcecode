<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%
String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ request.getContextPath() + "/";
%>
<meta charset="UTF-8">
<title>文件列表</title>
</head>
<body>
<div class="Manager_style">
		<span class="title_name">文件列表</span>
		<h3 align="center">团检表</h3>
		<p>&nbsp;</p>
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>文件名</th>
					<th>上传时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listFile}" var="l">
					<tr>
						<td>${l.file_id + 1}</td>
						<td>${l.operate}</td>
						<td>${l.money}</td>
						<td>${l.time}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>