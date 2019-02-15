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
<script type="text/javascript">
	function base64(content) {
		return window.btoa(unescape(encodeURIComponent(content)));
	}
	/*
	 *@tableId: table的Id
	 *@fileName: 要生成excel文件的名字（不包括后缀，可随意填写）
	 */
	function tableToExcel(tableID, fileName) {
		var table = document.getElementById(tableID);
		var excelContent = table.innerHTML;
		var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
		excelFile += "<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head>";
		excelFile += "<body><table>";
		excelFile += excelContent;
		excelFile += "</table></body>";
		excelFile += "</html>";
		var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
		var a = document.createElement("a");
		a.download = fileName + ".xls";
		a.href = link;
		a.click();
	}
</script>
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
	function delLog(a) {
		
		var log_id = a;
		
		var b = confirm("是否删除");
		
		if(b == true){
			$.ajax({
				 type:"POST",
				 url:"<%=path%>log/delLog.handle",
				 data:{
					 "log_id":log_id
					 },
				 dataType:"text",
				 error:function(){
					 alert('ajax请求请求错误...');
				 },
				 success:function(data){
					if(data=="success"){
						alert("删除成功！");
						window.location.href="<%=path%>log/findAllLog.handle";
							} else {
								alert(data);
							}

						},
					});
		}

	}
</script>
<script>
	function selectAll() {
		
		var arr = document.getElementsByName("checkin");
		for(var i = 0; i < arr.length; i++){
			if(!arr[i].disabled){
				arr[i].checked = true;
			}
		}
	}
	
	function cancelAll() {
		
		var arr = document.getElementsByName("checkin");
		for(var i = 0; i < arr.length; i++){
				arr[i].checked = false;
		}
		
	}
</script>
<script>
	function del() {
		
		var arr = document.getElementsByName("checkin");
		var arrin = new Array();
		for(i = 0; i < arr.length; i++){
			if(arr[i].checked){
				arrin.push(arr[i].value);
			}
		}
		if(arrin.length > 0){
			alert(arrin);
			var b = confirm("是否删除");
			
			if(b == true){
				
				$.ajax({
					 type:"POST",
					 url:"<%=path%>log/delLog.handle",
					 data:{
						 "arrin":arrin
						 },
					 dataType:"json",
					 traditional:true,
					 error:function(){
						 alert("删除成功！");
						 window.location.href="<%=path%>log/findAllLog.handle";
						 <!--alert('ajax请求请求错误...');-->
					 },
					 success:function(data){
						if(data=="success"){
							alert("删除成功！");
							window.location.href="<%=path%>log/findAllLog.handle";
								} else {
									alert(data);
								}

							},
						});
				
			}
		}else{
			alert("未勾选正确的移动项");
		}
	}
</script>
<title>日志查看</title>
</head>

<body>

	<div class="Manager_style">
		<span class="title_name">日志查看</span>
		<p align="center">
			<button type="button" onclick="tableToExcel('item','data')">导出Excel</button>
			<button type="button" onclick="selectAll()">全选</button>
			<button type="button" onclick="cancelAll()">全不选</button>
			<button type="button" onclick="del()">删除</button>
		</p>
		<p align="center">&nbsp;</p>
		<table class="table table-striped table-bordered table-hover"
			id="item">
			<thead>
				<tr>
					<th>序号</th>
					<th>用户</th>
					<th>具体操作</th>
					<th>操作时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${loglist}" var="l" varStatus="s">
					<tr>
						<td>${s.index + 1}</td>
						<td>${l.name}</td>
						<td>${l.opera}</td>
						<td>${l.time}</td>
						<td><input type="checkbox" name="checkin" value="${l.log_id}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>