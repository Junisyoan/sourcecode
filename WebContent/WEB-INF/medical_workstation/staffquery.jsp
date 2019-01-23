<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
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
<title>项目接收</title>
</head>

<body>
	<div class="page-content">
		<div class="gys_style">
			<div class="Manager_style">
				<div class="title_name">体检人员查询</div>
				<!-- 查询条码号 -->
				<form method="post" action="<%=path%>patient/findpatient.handle">
					<ul class="search_content clearfix">
						<li><label class="lf">姓名<input name="name"
								type="text" class="text_add" /></label> <label class="lf">手机号<input
								name="phone" type="text" class="text_add" />
						</label> <label class="lf">体检时间<input name="time" type="date"
								class="text_add" /></label> <label class="lf">条码号<input
								name="code" type="text" class="text_add" /></label>
							<button type="submit" class="btn btn-primary" class="btn_search">查询</button>
							<button type="button" onclick="tableToExcel('item','data')">导出</button>
						</li>
					</ul>
				</form>
			</div>
		</div>

		<div class="Manager_style">
			<span class="title_name">体检人员信息</span>
			<table class="table table-striped table-bordered table-hover"
				id="item">
				<thead>
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>公司</th>
						<th>性别</th>
						<th>年龄</th>
						<th>身份证号</th>
						<th>手机号码</th>
						<th>条码号</th>
						<th>体检号</th>
						<th>体检时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${patientlist}" var="p" varStatus="s">
						<tr>
							<td>${s.index + 1}</td>
							<td>${p.n1}</td>
							<td>${p.n2}</td>
							<td>${p.sex}</td>
							<td>${p.age}</td>
							<td style="mso-number-format: '\@';">${p.ID}</td>
							<td>${p.phone}</td>
							<td>${p.code}</td>
							<td>${p.check_num}</td>
							<td style="mso-number-format: 'yyyy\-mm\-dd';">${p.time}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
</body>
</html>