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
<script src="<%=path%>js/jquery-ui.1.12.1.js"></script>
<title>资金明细</title>
</head>

<body>
	<div class="page-content">
	<div class="Manager_style">
		<span class="title_name">操作</span>
		<button class="btn btn-info" onclick="addCarousel();">增加轮播图</button>
	</div>
	<div class="Manager_style">
		<span class="title_name">轮播图管理</span>
		<table id="carouselTable" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>内容</th>
					<th>图片</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${carouselList}" var="c" varStatus="s">
					<tr>
						<td>${s.count}</td>
						<td>${c.content}</td>
						<td><img src='<%=path%>${c.path }' width="200"/></td>
						<td>${c.time}</td>
						<td>
							删除，修改，
							<c:if test="${c.state=='禁用' }">启用</c:if>
							<c:if test="${c.state=='启用' }">禁用</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div style="display:none" id="addCarousel" align="center">
		<br/>
		<form id="r" method="post">
			<input type="textarea" id="content" name="content" onpropertychange="validateString(this.value)"/>
			<select name="cImg" id="ci"></select>
			<button id="cz" class="btn btn-info">增加</button>
		</form>
	</div>
</div>

<script>
function addCarousel(){
	$.ajax({
		url:"",
		dataType:"json",
		type:"post",
		success:function(ret){
			if(ret!="null"){
				$('#ci').empty();
				for(var i=0;i<ret.length;i++){
 					var ci=document.getElementById("ci").value;
					 
					ci = ret[i].name; 
 					var op=$("<option></option>").text(ci);
					  
 					$("#doctor").append(op);
				}
			}else{
				alert('服务器错误');
			}
		},
		error:function(){
			alert("服务器无响应");
			return false;
		}
	});
	
}
</script>

<script>
function validateString(value){

    if (value.length > 200) {
        value = value.substr(0, 200);
        $("#context").val(value);
    }
    $("#lengthover").text(value.length );
    
} 
</script>
</body>

<script type="text/javascript">

$(function(){
	$('#r').dialog();
});

$(function(){
	$('#carouselTable').DataTable();
});
</script>
</html>