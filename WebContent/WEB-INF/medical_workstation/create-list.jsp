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
<link href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" rel="stylesheet" />
<script src="<%=path%>js/jquery-1.8.3.min.js"></script>
<script src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<title>人员列表</title>
</head>

<body>
	<div class="page-content">
		<div class="Manager_style">
			<span class="title_name">已开单列表</span>
			<table id="patientTable" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>公司名</th>
						<th>金额</th>
						<th>是否开单</th>
						<th>是否结算</th>
						<th>批次</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${billerList}" var="b" varStatus="s">
						<tr>
							<td>${s.count}</td>
							<td>${b.name}</td>
							<td>${b.totalMoney }</td>
							<td>${b.bcreate}</td>
							<td>${b.bstate}</td>
							<td>${b.batch}</td>
							<td><input type="button" value="生成导检单" onclick="createCheckpage('${b.biller_id}','${b.batch}');"></input></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">

function createCheckpage(bid,batch){
	var s = confirm("是否开单？批次："+batch);
	if(s){
		location.href="<%=path%>nurse/getCheckPage.handle?bid="+bid;
	}
}

$(function(){
	$('#patientTable').DataTable();
});

</script>
</html>