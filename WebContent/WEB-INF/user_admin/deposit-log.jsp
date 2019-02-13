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
<title>资金明细</title>
</head>

<body>


	<div class="Manager_style">
		<div class="title_name">充值</div>
			<input type="text" id="m" name="deposit"/>
			<input type="button" value="充值" onclick="recharge();"/>
		余额：${userCompany.deposit }
	</div>
	<div class="Manager_style">
		<span class="title_name">金额明细</span>
		<table id="depositTable" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>具体操作</th>
					<th>金额</th>
					<th>操作时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${logList}" var="l" varStatus="s">
					<tr>
						<td>${s.count}</td>
						<td>${l.operate}</td>
						<td>${l.money }</td>
						<td>${l.time}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
function recharge(){
	var m = document.getElementById("m").value;
	if(confirm("确认充值？")){
		$.ajax({
			url:"<%=path%>company/pay.handle",
			type:"post",
			dataType:"text",
			data:{deposit:m},
			success:function(ret){
				if(ret=="1"){
					alert("充值成功");
				}else{
					alert("充值失败");
				}
				location.href="<%=path %>company/getDepositDetail.handle";
			},
			error:function(){
				alert('错误');
			}
		});
	}
}
$(function(){
	$('#depositTable').DataTable();
});
</script>
</html>