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
<script src="<%=path%>js/jquery-1.8.3.min.js"></script>
<script src="<%=path%>js/jquery.dataTables.min.js"></script>
<script src="<%=path%>js/datatables.bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#item").dataTable();
	});
</script>
<script>
	function delparam(a) {
		var param_id = a;
		var b = confirm("是否删除");
		if(b == true){
			$.ajax({
				 type:"POST",
				 url:"<%=path%>param/delparam.handle",
				 data:{
					 "param_id":param_id
					 },
				 dataType:"text",
				 error:function(){
					 alert('ajax请求请求错误...');
				 },
				 success:function(data){
					if(data=="success"){
						alert("删除成功！");
						window.location.href="<%=path%>param/findAllParam.handle";
					}else{
						alert(data);
					}
				 },
			 });
		}
	}
</script>
<title>参数管理</title>
</head>

<body>
	<div class="page-content">
		<div class="gys_style">
			<div class="Manager_style">
				<div class="title_name">参数查询</div>
				<form method="post" action="<%=path%>param/searchparam.handle">
					<ul class="search_content clearfix">
						<li><label class="lf">参数ID<input name="param_id"
								type="text" class="text_add" /></label> <label class="lf">上级参数ID<input
								name="pid" type="text" class="text_add" />
						</label> <label class="lf">参数名字<input name="name" type="text"
								class="text_add" /></label>
							<button type="submit" class="btn btn-primary" class="btn_search">查询</button>
							<a href="<%=path%>param/showaddparam.handle"><button
									type="button" class="btn btn-primary" class="btn_search">新增</button></a></li>
					</ul>
				</form>
			</div>
		</div>
	</div>
	<div class="Manager_style">
		<span class="title_name">参数信息</span>
		<table class="table table-striped table-bordered table-hover"
			id="item">
			<thead>
				<tr>
					<th>序号</th>
					<th>参数ID</th>
					<th>上级参数ID</th>
					<th>参数名字</th>
					<th>操作</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${paramlist}" var="p" varStatus="s">
					<tr>
						<td>${s.index + 1}</td>
						<td>${p.param_id}</td>
						<td>${p.pid}</td>
						<td>${p.name}</td>
						<td><input type="button" onclick="delparam('${p.param_id}')"
							value="删除" style="width: 100px;" />
							<a href="<%=path%>param/showmodifyparam.handle?param_id=${p.param_id}"><input type="button" value="修改" style="width: 100px;" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>