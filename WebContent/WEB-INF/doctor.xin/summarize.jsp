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
				<form method="post" action="<%=path %>brief/findProject.handle">
					<ul class="search_content clearfix">
						<li><label class="lf">条码号</label><input name="onecode" type="text"
							class="text_add" />
							<button type="submit" class="btn btn-primary" class="btn_search">查询</button>
						</li>
					</ul>
				</form>
				
				
				<!--     <button type="button" class="btn btn-primary" id="Add_Product_btn">添加产品</button> -->
<!-- 				<div class="Add_Manager_style"> -->
<!-- 						<div class="page-content"> -->
<!-- 							<div class="add_user_style clearfix"> -->
<!-- 								<ul class="clearfix"> -->
<!-- 									<li><label class="label_name">产品名称</label> <input -->
<!-- 										name="产品名称" type="text" class="text_add" id="name_text" /><i -->
<!-- 										style="color: #F60;">*</i></li> -->
<!-- 									<li><label class="label_name">产品联系人</label><input name="" -->
<!-- 										type="text" class="text_add" /></li> -->
<!-- 									<li><label class="label_name">产品联系电话</label><input name="" -->
<!-- 										type="text" class="text_add" /></li> -->
<!-- 								</ul> -->
<!-- 								<div class="Remark"> -->
<!-- 									<label class="label_name">备注</label> -->
<!-- 									<textarea name="" cols="" rows="" -->
<!-- 										style="width: 436px; height: 200px; padding: 5px;"></textarea> -->
<!-- 								</div> -->
<!-- 								    <div class="btn_operating"><button  type="button" class="btn btn-primary" id="submit">保存</button><button  type="button" class="btn btn-warning">重置</button></div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
				</div>
			</div>

			<div class="Manager_style">
				<span class="title_name">体检信息</span>
			<form method="post" action="<%=path %>doctor/findProject.handle">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>序号</th>
							<th>病人姓名</th>
							<th>年龄</th>
							<th>电话</th>
							<th>科室</th>
							<th>项目</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>13505140602</td>
							<td>备注信息</td>
							<td>备注信息</td>
							<td>备注信息</td>
							<td>备注信息</td>
							<td>备注信息</td>
							<td>
								<a href="<%=path %>doctor/Detail.handle?projectname=血常规 &patientid=1&projectid=1"><button type="button" class="btn btn-info Product_Details">检查</button></a>
								<button type="button" class="btn btn-primary">修改</button>
								<button type="button" class="btn btn-warning">删除</button></td>
						</tr>

						<c:forEach items="${prolist }" var="p" varStatus="s">
							<tr>
								<td>${s.index + 1}</td>
								<td>${p.name}</td>
								<td>${p.age}</td>
								<td>${p.phone}</td>
								<td>${p.keshi}</td>
								<td>${p.projectname}</td>
								<td>${p.state}</td>
								<td class="center">
								<c:if test="${p.state=='未接收' }">
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

			<!--     <div class="Manager_style"> -->
			<!--      <span class="title_name">产品信息</span> -->
			<!--      <table class="table table-striped table-bordered table-hover"> -->
			<!--       <thead> -->
			<!--        <tr> -->
			<!--         <th>序号</th> -->
			<!--         <th>细项</th> -->
			<!--         <th>结果</th> -->
			<!--         <th>单位</th> -->
			<!--         <th>参考值</th> -->
			<!--         <th>提示</th> -->
			<!--         <th>操作</th> -->
			<!--        </tr> -->
			<!--       </thead> -->
			<!--       <tbody> -->
			<!--        <tr> -->
			<!--         <td>1</td><td>#0号柴油</td><td>刘怀帮</td><td>13505140602</td><td>备注信息</td><td>备注信息</td> -->
			<!--         <td><button type="button" class="btn btn-info Product_Details">详情</button><button type="button" class="btn btn-primary">修改</button> <button type="button" class="btn btn-warning">删除</button></td> -->
			<!--        </tr> -->
			<!--        <tr> -->
			<!--         <td>2</td><td>#0号柴油A</td><td>刘怀帮</td><td>13505140602</td><td>备注信息</td><td>备注信息</td> -->
			<!--         <td><button type="button" class="btn btn-info Product_Details">详情</button><button type="button" class="btn btn-primary">修改</button> <button type="button" class="btn btn-warning">删除</button></td> -->
			<!--        </tr> -->
			<!--        <tr> -->
			<!--         <td>3</td><td>#0号柴油B</td><td>刘怀帮</td><td>13505140602</td><td>备注信息</td><td>备注信息</td> -->
			<!--         <td><button type="button" class="btn btn-info Product_Details">详情</button><button type="button" class="btn btn-primary">修改</button> <button type="button" class="btn btn-warning">删除</button></td> -->
			<!--        </tr> -->
			<!--        <tr> -->
			<!--         <td>4</td><td>#18号柴油</td><td>刘怀帮</td><td>13505140602</td><td>备注信息</td><td>备注信息</td> -->
			<!--         <td><button type="button" class="btn btn-info Product_Details">详情</button><button type="button" class="btn btn-primary">修改</button> <button type="button" class="btn btn-warning">删除</button></td> -->
			<!--        </tr> -->
			<!--       </tbody> -->
			<!--      </table> -->
			<!--   </div>  -->


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
	<script type="text/javascript">
		$('.Product_Details').on('click', function() {
			alert("111");
			layer.open({
				type : 1,
				title : '产品详情',
				maxmin : true,
				shadeClose : true, //点击遮罩关闭层
				area : [ '720px', '500px' ],
				content : $('#Product_Details')
			});
		});
		$('.Attribute_btn').on('click', function() {
			layer.open({
				type : 1,
				title : '添加属性',
				shadeClose : true, //点击遮罩关闭层
				area : [ '330px', '180px' ],
				content : $('#add_Attributes_style'),
				btn : [ '提交', '取消' ],
				yes : function(index, layero) {
					if ($("#shuxin").val() == "") {
						layer.alert('属性名称不能为空!', {
							title : '提示框',
							icon : 0,
						});
						return false;
					} else {
						layer.alert('添加成功！', {
							title : '提示框',
							icon : 1,
						});
						layer.close(index);
					}

				}
			});
		});
		$('#Add_Product_btn').on('click', function() {
			layer.open({
				type : 1,
				title : '添加/修改产品',
				shadeClose : true, //点击遮罩关闭层
				area : [ '600px', '' ],
				content : $('#Add_Product_style'),
				btn : [ '提交', '取消' ],
				yes : function(index, layero) {
					if ($("#name_text").val() == "") {
						layer.alert('产品名称不能为空!', {
							title : '提示框',
							icon : 0,
						});
						return false;
					} else {
						layer.alert('添加成功！', {
							title : '提示框',
							icon : 1,
						});
						layer.close(index);
					}
				}
			})
		});
	</script>
</body>
</html>