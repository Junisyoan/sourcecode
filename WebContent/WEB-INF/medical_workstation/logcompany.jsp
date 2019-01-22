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
<title>项目接收</title>
</head>
<body>
	<div class="Manager_style">
		<span class="title_name">体检人员信息</span>
		<h3 align="center">公司
			：${logCompanylist.get(0).getCompany().getName()}&nbsp;&nbsp;&nbsp;&nbsp;帐号：${logCompanylist.get(0).getCompany().getAccount()}&nbsp;&nbsp;&nbsp;&nbsp;帐号余额：${logCompanylist.get(0).getCompany().getDeposit() }</h3>
		<p>&nbsp;</p>
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>操作</th>
					<th>金额</th>
					<th>时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${logCompanylist}" var="l" varStatus="s">
					<tr>
						<td>${s.index + 1}</td>
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