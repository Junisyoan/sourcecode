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
<link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
<link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path %>css/style.css" />
<title>新闻列表</title>
	<style type="text/css">
		.box{width:180px;border-radius:10px}
	</style>
</head>

<body>
	<div class="page-content">
		<div class="gys_style">
			<div class="Manager_style">
				<div class="title_name">新闻查询</div>
				
				<!-- 查询条码号 -->
				<form method="post" action="<%=path %>nurse/searchnews.handle">
					<ul class="search_content clearfix">
						<li>
						<label class="lf">标题</label>
						<input name="title" id="box" type="text" class="text_add" />
						日期
						<input name="mindate" id="box" type="date" class="text_add" />至
						<input name="maxdate" id="box" type="date" class="text_add" />
						内容
						<input name="info" id="box" type="text" class="text_add" />
						<button type="submit" class="btn btn-primary" class="btn_search">查询</button>
						</li>
					</ul>
				</form>

				</div>
			</div>

			<div class="Manager_style">
				<span class="title_name">新闻信息</span>
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>序号</th>
							<th>标题</th>
							<th>时间</th>
							<th>内容</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>13505140602</td>
							<td>备注信息</td>
							<td>备注信息</td>
							<td>
								<a href="<%=path %>doctor/Detail.handle?projectname=血常规 &patientid=1&projectid=1"><button type="button" class="btn btn-info Product_Details">检查</button></a>
								<button type="button" class="btn btn-primary">修改</button>
								<button type="button" class="btn btn-warning">删除</button></td>
						</tr>

						<c:forEach items="${nlist }" var="n" varStatus="s">
							<tr>
								<td>${s.index + 1}</td>
								<td>${n.title}</td>
								<td>${n.time}</td>
								<td>${n.info}</td>
								<td class="center">
								
								<a href="<%=path %>doctor/receive.handle?newsid=${n.new_id}"><button type="button" class="btn btn-primary">修改</button></a>
								<a href="<%=path %>doctor/Detail.handle?newsid=${n.new_id}"><button type="button" class="btn btn-info Product_Details">删除</button></a>
								
								</td>
							</tr>
						</c:forEach>
					</tbody>
				 </table>
			</div>
		</div>
	<div class="" id="Product_Details" style="display: none">
		<div class="page-content">
			<div class="add_Attributes">
				<button class="btn btn-primary Attribute_btn" type="button">添加属性</button>
			</div>
		</div>
	</div>
	<!--添加属性样式-->
	<div class="Attributes_style" id="add_Attributes_style"
		style="display: none">
		<input name="" type="text" class="Attributestext" id="shuxin" />
		<!--<button type="button" class="btn btn-primary">添加</button>-->
	</div>

	<!--[if !IE]> -->
	<script src="<%=path %>assets/js/jquery.min.js"></script>
	<!-- <![endif]-->

	<!--[if !IE]> -->

	<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=path %>assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
	<script src="<%=path%>assets/layer/layer.js" type="text/javascript"></script>

</body>
</html>
