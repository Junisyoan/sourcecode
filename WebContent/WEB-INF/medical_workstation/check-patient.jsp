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
<script src="<%=path%>js/jquery-ui.1.12.1.js"></script>
<title>文件列表</title>
</head>

<body>
	<div class="page-content">
		<div class="Manager_style">
			<span class="title_name">人员列表</span>
			<table id="patientTable" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>身份证号</th>
						<th>手机号</th>
						<th>套餐</th>
						<th>是否符合</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${patientList}" var="p" varStatus="s">
						<tr>
							<td>${s.count}</td>
							<td>${p.name}</td>
							<td>${p.sex}</td>
							<td>${p.age}</td>
							<td>${p.ID}</td>
							<td>${p.phone}</td>
							<td>${p.comboName }</td>
							<td><span name="c">${p.check_num }</span></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="Manager_style">
			<div class="title_name">操作</div>
			<button class="btn btn-info" onclick="passFile('${fid}');">通过</button>
			<button class="btn btn-warning" onclick="invalidFile('${fid}');">不合格</button>
			<button class="btn btn-primary" onclick="backToPre();">返回</button>
		</div>
	</div>
<script type="text/javascript">
function backToPre(){
	window.history.back();
}
$(function(){
	$('#patientTable').DataTable();
});
function passFile(fid){
	var check = document.getElementsByName("c");
	for(var i = 0;i<check.length;i++){
		if(check[i].innerHTML!=""){
			alert("内容不符合！");
			return false;
		}
	}
	$.ajax({
		type:"post",
		dataType:"text",
		url:"<%=path%>nurse/passFile.handle",
		data:{'fid':fid},
		success:function(retData){
			if(retData=="1"){
				alert("审核通过");
				location.href="<%=path %>nurse/queryCheckFile.handle?cid=${userCompany.company_id}";
			}else if(retData=="0"){
				alert("审核失败");
			}
		},
		error:function(){
			alert("服务器无响应");
		}
		
	});
}

function invalidFile(fid){
	var check = document.getElementsByName("c");
	for(var i = 0;i<check.length;i++){
		if(check[i].innerHTML==""){
			alert("内容符合！");
			return false;
		}
	}
	$.ajax({
		type:"post",
		dataType:"text",
		url:"<%=path%>nurse/invalidFile.handle?fid="+fid,
		success:function(retData){
			if(retData=="1"){
				alert("执行成功");
				location.href="<%=path %>nurse/queryCheckFile.handle";
			}else if(retData=="0"){
				alert("执行失败");
			}
		},
		error:function(){
			alert("服务器无响应");
		}
		
	});
}
</script>
</body>
</html>