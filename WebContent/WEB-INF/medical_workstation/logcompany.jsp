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
<title>团检单位对账</title>
</head>
<body>

	<div class="page-content">
		<div class="gys_style">
			<div class="Manager_style">
				<div class="title_name">日志查询</div>
				<form method="post" action="<%=path%>logcompany/searchlog.handle">
					<ul class="search_content clearfix">
						<li><label class="lf">公司名字<input name="name"
								type="text" class="text_add" /></label> <label class="lf">具体操作<input
								name="operate" type="text" class="text_add" />
						</label> <label class="lf">金额<input name="money" type="text"
								class="text_add" /></label>
						<label class="lf">操作时间<input name="time" type="date"
								class="text_add" /></label>
							<button type="submit" class="btn btn-primary" class="btn_search">查询</button>
							<button type="button" class="btn btn-primary" onclick="tableToExcel('item','data')">导出Excel</button>
							</li>
					</ul>
				</form>
			</div>
		</div>
	</div>

	<div class="Manager_style">
		<span class="title_name">团检单位对账</span>
		<p>&nbsp;</p>
		<table class="table table-striped table-bordered table-hover" id="item">
			<thead>
				<tr>
					<th>序号</th>
					<th>公司</th>
					<th>操作</th>
					<th>金额</th>
					<th>时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${logCompanylist2}" var="l" varStatus="s">
					<tr>
						<td>${s.index + 1}</td>
						<td>${l.name}</td>
						<td>${l.operate}</td>
						<td>${l.money}</td>
						<td>${l.time}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>