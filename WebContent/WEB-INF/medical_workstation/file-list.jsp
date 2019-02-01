<%@ page language="java" import="java.util.*" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>

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
<script src="<%=path%>js/jquery-1.8.3.min.js"></script>
<script src="<%=path %>js/jquery.dataTables.min.js"></script>
<script src="<%=path %>js/datatables.bootstrap.min.js"></script>
<title>项目接收</title>
</head>

<body>
	<div class="page-content">
		<div class="Manager_style">
			<span class="title_name">文件列表</span>
			<table id="listTable" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>文件名</th>
						<th>文件大小</th>
						<th>上传日期</th>
						<th>审核状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${fileList}" var="l" varStatus="s">
						<tr>
							<td>${s.count}</td>
							<td>${l.name}</td>
							<td>${l.fsize}</td>
							<td>${l.ftime}</td>
							<td>${l.cstate }</td>
							<td>
								<a href="javascript:;" onclick="importFile('${l.file_id}');">导入</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
<script type="text/javascript">

function importFile(file_id){
	location.href='<%=path%>nurse/importFile.handle?file_id='+file_id;
}

$(function(){
	$("#listTable").dataTable();
});
</script>
</body>
</html>