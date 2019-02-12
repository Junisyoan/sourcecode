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
<link href="<%=path%>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
<link rel="stylesheet" href="<%=path%>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path%>css/style.css" />
<title>无标题文档</title>
</head>

<body>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<div class="Manager_style">
		<span class="title_name">体检小结信息</span>
		<table class="table table-striped table-bordered table-hover"
			id="item">
			<thead>
				<tr>
					<th>序号</th>
					<th>体检人</th>
					<th>项目</th>
					<th>结果</th>
					<th>单位</th>
					<th>参考值</th>
					<th>体检时间</th>
					<th>提示</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${patientlist}" var="p" varStatus="s">
					<tr>
						<th>${s.index + 1}</th>
						<th>${p.n1}</th>
						<th>${p.n2}</th>
						<th>${p.unit}</th>
						<th>${p.resulttext}</th>
						<th>${p.min}~${p.max}</th>
						<th>${gro.time}</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<p align="center">
		<a
			href="<%=path%>patient/findpatientall.handle?name=${p.n1}&time=${p.time}">返回</a>
	</p>
</body>
</html>