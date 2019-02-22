<%@ page language="java" import="java.util.*"
	contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="xyz.cymedical.entity.jiang.Tb_user"%>

<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
<link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path %>css/style.css" />
<title>项目接收</title>
</head>

<body>
	<%Tb_user user=(Tb_user)request.getSession().getAttribute("user"); %>


	<div class="page-content">
		<div class="gys_style">
			<div class="Manager_style">
				<div class="title_name">项目读取</div>
				
				<!-- 查询条码号 -->
				<form method="post" action="<%=path %>doctor/findProject.handle">
					<ul class="search_content clearfix">
						<li><label class="lf">条码号/手机号</label><input name="onecode" type="text"
							class="text_add" />
							<button type="submit" class="btn btn-primary" class="btn_search">查询</button>
						</li>
					</ul>
				</form>
					<div>
					<table align="center" style="width:1000px;font-size: 15px;">
					<tr style="margin:0 5px">
						<td>姓名：${patient.name }&nbsp;&nbsp;</td>
						<td>年龄：${patient.age }&nbsp;&nbsp;</td>
						<td>性别：${patient.sex }&nbsp;&nbsp;</td>
						<td>身份证号：${patient.ID }&nbsp;&nbsp;</td>
						<td>电话号码：${patient.phone }&nbsp;&nbsp;</td>
						<td>检查号：${patient.check_num }</td>
					</tr>
					</table>
					</div>
		
		
				</div>
			</div>

			<div class="Manager_style">
				<span class="title_name">体检信息</span>
			<form method="post" action="<%=path %>doctor/findProject.handle">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>序号</th>
							<th>科室</th>
							<th>项目</th>
							<th>接收状态</th>
							<th>结算状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${prolist }" var="p" varStatus="s">
							<tr>
								<td>${s.index + 1}</td>
								<td>${p.keshi}</td>
								<td>${p.projectname}</td>
								<td>${p.state}</td>
								<td>${p.balance}</td>
								<td class="center">
								<c:if test="${p.state=='未接收' && p.balance=='已结算'}">
									<a href="<%=path %>doctor/receive.handle?patient_project_id=${p.patient_project_id}&onecode=${p.code } "><button type="button" class="btn btn-primary" onclick="return confirm('确定接收么？') ;">接收</button></a>
								</c:if> 
								<c:if test="${p.state=='已接收' }">
									<a href="<%=path %>doctor/Detail.handle?projectname=${p.projectname} &patientid=${p.patient_id}&projectid=${p.project_id}&keshi=${p.keshi }&code=${p.code}"><button type="button" class="btn btn-info Product_Details">检查</button></a>
								</c:if> 
								</td>
							</tr>
						</c:forEach>
					</tbody>
				 </table>
				</form>
			</div>
		</div>
	</div>
	<div class="" id="Product_Details" style="display: none">
		<div class="page-content">
			<div class="add_Attributes">
				<button class="btn btn-primary Attribute_btn" type="button">添加属性</button>
			</div>
		</div>
	</div>
	<!--添加属性样式-->
	<div class="Attributes_style" id="add_Attributes_style"
		style="display: none">
		<input name="" type="text" class="Attributestext" id="shuxin" />
		<!--<button type="button" class="btn btn-primary">添加</button>-->
	</div>

	<!--[if !IE]> -->
	<script src="<%=path %>assets/js/jquery.min.js"></script>
	<!-- <![endif]-->

	<!--[if !IE]> -->

	<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=path %>assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
	<script src="<%=path%>assets/layer/layer.js" type="text/javascript"></script>

</body>
</html>
