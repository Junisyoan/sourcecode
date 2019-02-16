<%@ page language="java" import="java.util.*"
	contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
<link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path %>css/style.css" />
<script src="<%=path%>js/jquery-1.8.3.min.js"></script>
<script src="<%=path%>js/jquery-ui.1.12.1.js"></script>
<script src="<%=path%>js/jquery.dataTables.min.js"></script>
<title>人员列表</title>
</head>

<body>
	<div class="page-content">
		<div class="Manager_style">
			<span class="title_name">人员列表</span>
			<input type="button" value="临时添加人员" onclick="javascript:$('#addDialog').dialog('open');"/>
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
<!-- 						<th>选择</th> -->
						
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
<%-- 							<td><input type="checkbox" name="openBill" value="${p.paitent_id }"></input></td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div id="opera">
		<div>
			<button type="button" id="all" class="btn btn-primary" onclick="allOpen('${fid}');">生成账单</button>	
		</div>
	</div>
	<!-- 弹出框 -->
	<div id="addDialog" title="增加人员">
		<form action="<%=path %>nurse/addPatient.handle" method="post">
			<table width="600" border="0" cellpadding="2">
				<tr>
					<td>套餐名：</td>
					<td><input type="text" name="comboName" id="comboName" /></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="name" id="name" /></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="text" name="sex" id="sex" /></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" name="age" id="age" /></td>
				</tr>
				<tr>
					<td>身份证号：</td>
					<td><input type="text" name="ID" id="ID" /></td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td><input type="text" name="phone" id="phone" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="增加" /></td>
					<td><input type="reset" value="清空" /></td>
				</tr>
			</table>
		</form>

	</div>
</body>
<script type="text/javascript">

function allOpen(fid){
	var s = confirm("确定全部生成吗？");
	if(s){
		$.ajax({
			type:"post",
			dataType:"text",
			url:"<%=path%>nurse/allOpen.handle?fid="+fid,
			success:function(retData){
				if(retData=="1"){
					alert("生成成功");
				}else{
					alert("生成失败");
				}
			},
			error:function(){
				alert('服务器无响应');
			}
		});
	}
}

function chooseOpen(fid){
	var choosed = document.getElementsByName("openBill");
	var l = "";
	for(var i=0;i<choosed.length;i++){
		if(choosed[i].checked){
			l=l+","+choosed[i].value;
		}
	}
	if(l==""){
		return;
	}
	l=l.substring(1,l.length);
	$.ajax({
		url:"<%=path%>nurse/chooseOpen.handle",
		type:"post",
		dataType:"text",
		data:{data:l,fid:fid},
		success:function(retData){
			alert(retData);
		},
		error:function(){
			alert("服务器无响应");
		}
	});
}

$(function(){
	$('#patientTable').DataTable();
	$('#addDialog').dialog({
		 autoOpen: false,
	      show: {
	        effect: "blind",
	        duration: 1000
	      },
	      hide: {
	        effect: "explode",
	        duration: 1000
	      }
	});
});

$(function(){
	$('#comboName').on('blur',function(){
		var comboName = document.getElementById('combo').value;
		$.ajax({
			type:"post",
			url:"<%=path%>company/queryCombo.handle?comboName="+comboName,
			dataType:"text",
			success:function(retData){
				if(retData=="1"){
					alert("生成成功");
				}else if(retData=="0"){
					alert("生成失败");
				}
					location.href="<%=path %>nurse/getBillerNoPay.handle";
			},
			error:function(){
				alert("服务器无响应");
			}
		});
	});
});
</script>
</html>