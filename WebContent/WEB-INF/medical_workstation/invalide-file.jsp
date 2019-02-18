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
<script src="<%=path %>js/jquery.dataTables.min.js"></script>
<script src="<%=path %>js/datatables.bootstrap.min.js"></script>
<title>文件审核</title>
</head>

<body>
<div class="page-content">
	<div class="Manager_style">
		<span class="title_name">文件审核</span>
		<table id="waitTable" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>所属公司</th>
					<th>文件名</th>
					<th>上传时间</th>
					<th>状态</th>
					<th>是否已查看</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${invalides}" var="i" varStatus="s">
					<tr>
						<td>${s.count}</td>
						<td>${i.name}</td>
						<td>${i.fname}</td>
						<td>${i.ftime}</td>
						<td>${i.cstate}</td>
						<td>${i.vs}</td>
						<td>
							<button class="btn btn-info" onclick="delInvalide('${i.file_id}','${i.vs}');">删除</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
<script type="text/javascript">

function delInvalide(fid,w){
	if(confirm("确认删除？文件"+w)){
		$.ajax({
			url:"<%=path %>company/delInvalide.handle",
			type:"post",
			data:{'fid':fid},
			dataType:"text",
			success:function(ret){
				if(ret=="1"){
					alert("删除成功");
				}else if(ret=="-1"){
					alert("文件已删除");
				}else if(ret=="0"){
					alert("删除失败");
				}
					location.href="<%=path %>nurse/getInvalideFile.handle";
			},
			error:function(){
				alert("服务器无响应");
			}
		});
	}
}

function check(fid){
	location.href="<%=path%>nurse/checkFile.handle?fid="+fid;
}
$(function(){
	$('#waitTable').DataTable();
});
</script>
</body>

</html>