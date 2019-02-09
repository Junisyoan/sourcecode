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
<link href="<%=path%>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
<link rel="stylesheet" href="<%=path%>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path%>css/style.css" />
<script src="<%=path%>js/jquery-1.8.3.min.js"></script>
<script src="<%=path%>js/jquery-ui.1.12.1.js"></script>
<script src="<%=path%>js/jquery.dataTables.min.js"></script>
<title>人员列表</title>
</head>

<body>
	<div class="page-content">
		<div class="Manager_style">
			<span class="title_name">未结算账单列表</span>
			<table id="patientTable" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>公司名</th>
						<th>是否结算</th>
						<th>总金额</th>
						<th>批次</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${billerList}" var="b" varStatus="s">
						<tr>
							<td>${s.count}</td>
							<td>${b.name}</td>
							<td>${b.bstate}</td>
							<td>${b.totalMoney }</td>
							<td>${b.batch}</td>
							<td>
								<input type="button" name="payBiller" onclick="payBiller('${b.biller_id}','${b.totalMoney }' );" value="结算"></input>
								<input type="button" name="payBiller" onclick="payBiller('${b.biller_id}' );" value="打印发票"></input>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">

function payBiller(bid,totalmoney){
	var s = confirm("总金额"+totalmoney+"确认结算？");
	if(s){
		$.ajax({
			url:"<%=path%>company/payBiller.handle",
			type:"post",
			dataType:"text",
			data:{bid:bid,totalmoney:totalmoney},
			success:function(retData){
				if(retData=="1"){
					alert('支付成功');
					location.href="";
				}else if(retData=="0"){
					alert('支付失败');
				}else if(retData=="-1"){
					alert("费用扣除失败，请联系管理员！");
				}else if(retData=="-2"){
					alert("余额不足！");
				}
			},
			error:function(){
				alert("服务器无响应");
			}
		});
	}
}

$(function(){
	$('#patientTable').DataTable();
});

</script>
</html>