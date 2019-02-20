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
<link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
<link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path %>css/style.css" />
<title>项目总结</title>
</head>

<body>
	<div class="page-content">
		<div class="gys_style">
			<div class="Manager_style">
				<div class="title_name">项目读取</div>

				<!-- 查询条码号 -->
				<form method="post"
					action="<%=path %>chiefdoctor/findProject.handle">
					<ul class="search_content clearfix">
						<li>
						<label class="lf">条码号/手机号</label>
						<input name="onecode" type="text" class="text_add" />
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



			<c:forEach items="${plist }" var="p" varStatus="s">
				<div class="page-content">
					<h3 class="header smaller lighter blue">
						<div style="float: left">${p.projectname }</div>
						<div style="float: right">${p.keshi }</div>
					</h3>

					<div class="">
						<table id=""
							class="table table-striped table-bordered table-hover">
							<c:if test="${p.keshi=='常规检查室' }">
								<thead>
									<tr>
										<th>序号</th>
										<th>项目名称</th>
										<th>单位</th>
										<th>结果</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${dlist }" var="d" varStatus="s">
										<tr>
											<c:if test="${d.project_id==p.project_id}">
												<td>${s.index + 1}</td>
												<td>${d.name}</td>
												<td>${d.unit}</td>

<%-- 												<c:if test="${d.sstate=='未提交' }"> --%>
<%-- 													<td><input type="text" name="data" id="${d.name}" /></td> --%>
<!-- 													<td class="center"><a href="javascript:;" -->
<%-- 														onclick="location ='<%=path %>brief/normal.handle?result='+document.getElementById('${d.name}').value+'&id='+${d.brief_id};"> --%>
<!-- 															<button type="button" class="btn btn-primary" -->
<!-- 																onclick="return confirm('确定提交么？');">提交</button> -->
<!-- 													</a></td> -->
<%-- 												</c:if> --%>

												<c:if test="${d.sstate=='已提交' }">
													<td>${d.resulttext}</td>
													<td class="center">已提交</td>
												</c:if>
											</c:if>
										</tr>
									</c:forEach>
								</tbody>
							</c:if>
							
							<c:if test="${p.keshi=='彩超室' }">
								<thead>
									<tr>
										<th>序号</th>
										<th>项目名称</th>
										<th>结果</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${dlist }" var="d" varStatus="s">
										<tr>
											<c:if test="${d.project_id==p.project_id}">
												<td>${s.index + 1}</td>
												<td>${d.name}</td>
												<td>${d.resulttext}</td>
											</c:if> 
										</tr>
									</c:forEach>
								</tbody>
							</c:if>
							
							<c:if test="${p.keshi=='检验室' }">
								<thead>
									<tr>
										<th>序号</th>
										<th>项目名称</th>
										<th>结果</th>
										<th>单位</th>
										<th>参考值</th>
										<th>提示</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${dlist }" var="d" varStatus="s">
										<tr>
											<c:if test="${d.project_id==p.project_id}">
												<td>${s.index + 1}</td>
												<td>${d.name}</td>
												<td>${d.resulttext}</td>
												<td>${d.unit}</td>
												<td>${d.min}-${d.max}</td>
												<td style="color:red">${d.tips}</td>
											</c:if> 
										</tr>
									</c:forEach>
								</tbody>
							</c:if>
							
						</table>
					<div style="float: right">${p.keshi }:${p.docname }</div>
					</div>

				</div>
			</c:forEach>
			
			<c:if test="${flag!=null && flag!=''}">
				<div style="width:100px;margin:0 auto">
					<a href="<%=path %>chiefdoctor/tosummarize.handle"><input type="button" class="btn btn-warning" value="总结"/></a>
				</div>  
			</c:if>
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

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
	<script src="<%=path%>assets/layer/layer.js" type="text/javascript"></script>

</body>
</html>
