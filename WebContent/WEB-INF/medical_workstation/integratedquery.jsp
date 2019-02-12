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
<title>体检综合查询</title>
</head>

<body>
	<div class="page-content">
		<div class="gys_style">
			<div class="Manager_style">
				<div class="title_name">体检综合查询</div>
				<form method="post" action="<%=path%>patient/findpatientall.handle">
					<ul class="search_content clearfix">
						<li><label class="lf">姓名<input name="name"
								type="text" class="text_add" /></label> <label class="lf">手机号<input
								name="phone" type="text" class="text_add" />
						</label> <label class="lf">体检时间<input name="time" type="date"
								class="text_add" /></label> <label class="lf">条码号<input
								name="code" type="text" class="text_add" /></label>
							<button type="submit" class="btn btn-primary" class="btn_search">查询</button>
						</li>
					</ul>
				</form>
			</div>
		</div>

		<div class="Manager_style">
			<span class="title_name">体检综合信息</span>
			<table class="table table-striped table-bordered table-hover"
				id="item">
				<thead>
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>体检时间</th>
						<th>体检人信息</th>
						<th>体检项目信息</th>
						<th>体检小结信息</th>
						<th>体检总结信息</th>
						<th>体检报告预览</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${patientlist}" var="p" varStatus="s">
						<tr>
							<td>${s.index + 1}</th>
								<td>${p.n1}</th>
									<td>${p.time}</th>
										<td><a
											href="<%=path%>patient/showmessage.handle?name=${p.n1}&time=${p.time}">查看</a></td>
							<td><a
								href="<%=path%>patient/showproject.handle?name=${p.n1}&time=${p.time}">查看</a></td>
							<td><a
								href="<%=path%>patient/showbrief.handle?name=${p.n1}&time=${p.time}">查看</a></td>
							<td><a
								href="<%=path%>patient/showsummarize.handle?name=${p.n1}&time=${p.time}">查看</a></td>
							<td><a href="<%=path%>patient/showall.handle?name=${p.n1}&time=${p.time}">查看</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>