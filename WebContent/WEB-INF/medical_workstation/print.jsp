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
<script src="<%=path%>js/jquery-1.8.3.min.js"></script>
<script src="<%=path%>js/jquery.dataTables.min.js"></script>
<script src="<%=path%>js/datatables.bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#item").dataTable();
	});
</script>
<title>体检报告打印</title>
</head>

<body>
	<div class="page-content">
		<div class="gys_style">
			<div class="Manager_style">
				<div class="title_name">体检人报告打印</div>
				<form method="post" action="<%=path%>patient/printpatient.handle">
					<ul class="search_content clearfix">
						<li style="text-align: center;">姓名<input name="name"
							type="text" class="text_add" />
							<button type="submit" class="btn btn-primary" class="btn_search">查询</button>
						</li>
					</ul>
				</form>
			</div>
		</div>
	
	<div class="Manager_style">
		<span class="title_name">体检人员信息</span>
		<table class="table table-striped table-bordered table-hover"
			id="item">
			<thead>
				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>公司</th>
					<th>性别</th>
					<th>年龄</th>
					<th>身份证号</th>
					<th>手机号码</th>
					<th>条码号</th>
					<th>体检号</th>
					<th>体检时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${patientlist}" var="p" varStatus="s">
					<tr>
						<td>${s.index + 1}</td>
						<td>${p.n1}</td>
						<td>${p.n2}</td>
						<td>${p.sex}</td>
						<td>${p.age}</td>
						<td style="mso-number-format: '\@';">${p.ID}</td>
						<td>${p.phone}</td>
						<td>${p.code}</td>
						<td>${p.check_num}</td>
						<td style="mso-number-format: 'yyyy\-mm\-dd';">${p.time}</td>
						<td>
						<a href="<%=path%>patient/print.handle?name=${p.n1}&time=${p.time}&code=${p.code}"><span class="btn btn-info">打印体检报告</span></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</body>
</html>