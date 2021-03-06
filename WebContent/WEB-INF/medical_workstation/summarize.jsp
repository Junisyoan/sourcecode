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
<script src="<%=path%>js/jquery-ui.1.12.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#item").dataTable();
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#showpicture").dialog({
			autoOpen : false,
			show : {
				effect : "blind",
				duration : 300
			},
			hide : {
				effect : "explode",
				duration : 500
			}
		});
	});
</script>
<title>无标题文档</title>
</head>

<body>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<div class="Manager_style">
		<span class="title_name">体检总结信息</span> <span class="title_name">体检小结信息</span>
		<table class="table table-striped table-bordered table-hover"
			id="item">
			<thead>
				<tr>
					<th>序号</th>
					<th>项目</th>
					<th>细项</th>
					<th>结果</th>
					<th>单位</th>
					<th>参考值</th>
					<th>体检时间</th>
					<th>体检医生</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${patientlist}" var="p" varStatus="s">
					<c:if test="${s.index == 0}">
						<h2 align="center">${p.n1}</h2>
					</c:if>
					<tr>
						<th>${s.index + 1}</th>
						<th>${p.n3}</th>
						<th>${p.n2}</th>
						<th>${p.resulttext}</th>
						<th>${p.unit}</th>
						<c:if test="${p.min == null}">
							<th>${p.min}</th>
						</c:if>
						<c:if test="${p.min != null}">
							<th>${p.min}~${p.max}</th>
						</c:if>
						<th>${p.time}</th>
						<th>${p.n5}</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<p align="center">
		<button type="button" class="btn btn-info"
			onclick="javascript:$('#showpicture').dialog('open');">查看彩超图片</button>
	</p>
	<div id="showpicture" style="display: none;">
		<form>
			<c:forEach items="${patientlist}" var="p" varStatus="s">
				<c:if test="${p.resultpath != null}">
					<p align="center">${p.n3}</p>
					<p align="center">
						<img
							src="${pageContext.servletContext.contextPath}/upload/${p.resultpath}"
							style="width: 350px;" />
					</p>
				</c:if>
			</c:forEach>
		</form>
	</div>
	<p align="center">&nbsp;</p>
	<c:forEach items="${patientlist}" var="p" varStatus="s">
		<c:if test="${s.index == 0}">
			<p align="center">
				<a
					href="<%=path%>patient/findpatientall.handle?name=${p.n1}&time=${p.time}"><button
						class="btn btn-info">返回</button></a>
			</p>
		</c:if>
	</c:forEach>
</body>
</html>