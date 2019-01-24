<%@ page language="java" import="java.util.*"
	contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
<link rel="stylesheet" href="<%=path%>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path%>css/style.css" />
<script src="<%=path%>js/jquery-ui.1.12.1.js"></script>
<script src="<%=path%>js/jquery-ui.1.12.1.js"></script>
<title>人员列表</title>
</head>

<body>
	<div class="page-content">
		<div class="Manager_style">
			<span class="title_name">文件列表</span>
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>身份证号</th>
						<th>手机号</th>
						<th>选择</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listPatient}" var="p" varStatus="s">
						<tr>
							<td>${s.count}</td>
							<td>${p.name}</td>
							<td>${p.sex}</td>
							<td>${p.ID}</td>
							<td>${p.phone}</td>
							<td><input type="checked" value="${p.ID }"></input></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- 弹出框 -->
	<div id="dialog" title="增加人员">
		<form action="" method="post">
			<table width="600" border="0" cellpadding="2">
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="name" id="name" /></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="text" name="sex" id="sex" /></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" name="age" id="age" /></td>
				</tr>
				<tr>
					<td>身份证号：</td>
					<td><input type="text" name="ID" id="ID" /></td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td><input type="text" name="phone" id="phone" /></td>
				</tr>
				<tr>
					<td>套餐：</td>
					<td><input type="text" name="combo" id="combo" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="增加" /></td>
					<td><input type="reset" value="清空" /></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>