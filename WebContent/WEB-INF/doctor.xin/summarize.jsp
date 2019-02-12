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
<style type="text/css">
	.left1{margin:10px 80px;}
	.left2{margin:10px 100px;}
</style>
</head>

<body>
	<div class="page-content">
<!-- 		<div class="gys_style"> -->
<!-- 			<div class="Manager_style"> -->
<!-- 				<div class="title_name">提示</div> -->
<!-- 						<div class=""> -->
<!-- 						<table id="" -->
<!-- 							class="table table-striped table-bordered table-hover"> -->
<!-- 							<thead> -->
<!-- 									<tr> -->
<!-- 										<th>项目名称</th> -->
<!-- 										<th>提示</th> -->
<!-- 									</tr> -->
<!-- 								</thead> -->
<!-- 								<tbody> -->
<%-- 								<c:forEach items="${dlist }" var="d" varStatus="s"> --%>
<!-- 									<tr> -->
<%-- 										<c:if test="${d.tips!=null}"> --%>
<%-- 											<td>${d.name}</td> --%>
<%-- 											<td>${d.tips}</td> --%>
<%-- 										</c:if>  --%>
<!-- 									</tr> -->
<%-- 								</c:forEach> --%>
<!-- 							</tbody> -->
<!-- 						</table> -->
<!-- 					</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

		<div class="Manager_style">
			<span class="title_name">总结信息</span>
			
		<form method="post" action="<%=path %>chiefdoctor/dosummarize.handle">
			<div style="float: left; margin-left: 75px;font-size:20px;padding:5px">健康体检中心</div>
			<div style="float: right; margin-right: 75px;font-size:20px">体检日期： ${time }</div>
			
				<hr style="width: 1200px;">
				
				<h3 style="margin-left: 80px;">体检总结及建议：</h3>
				
				<hr style="width: 1200px;">
				
				<h4 style="margin-left: 80px;">【综诉】</h4>
				
				<div class="left2">
				<p>一、检验室：</p>
					<c:forEach items="${dlist }" var="d" varStatus="s">
							<c:if test="${d.tips!=null && d.type=='检验' && d.code==mycode}">
								${d.name}&nbsp;&nbsp;
								${d.resulttext}&nbsp;${d.unit}&nbsp;
								${d.tips}<br/>
							</c:if> 
					</c:forEach>
					<br/>
				<p>二、身高体重血压：</p>
					<c:forEach items="${dlist }" var="d" varStatus="s">
							<c:if test="${d.type=='普通' && d.code==mycode}">
								${d.name}&nbsp;&nbsp;
								${d.resulttext}&nbsp;${d.unit}&nbsp;
								${d.tips}<br/>
							</c:if> 
					</c:forEach>
				</div>
				
				<h4 style="margin-left: 80px;">【建议】</h4>
				
				<p class="left1"><textarea rows="5" cols="150" id="advice" name="advice"></textarea></p>
				 
				<hr style="width: 1200px;">
					<h3 style="margin-left: 80px;">生活保健指导</h3>
				<hr/>
				
				<p style="margin-left: 80px;">一、保持健康的生活方式</p>
				<p style="margin-left: 130px;">(1)健康的饮食习惯：食物多样，谷类为主；适合吃季节性蔬菜；吃适量乳类、豆类制品；吃适量

					新鲜有鱗鱼、蛋、瘦肉，少吃肥肉和荤油；</p>
				<p style="margin-left: 150px;">食量与活动量要平衡，监测体重，吃清淡少盐食物。</p>
				<p style="margin-left: 130px;">(2)戒烟戒酒：不但要避免吸烟也要避免被动吸烟，不饮酒或饮少量红葡萄酒。</p>
				<p style="margin-left: 130px;">(3)适量规律运动：能够预防很多慢性疾病，包括冠心病、高血压、糖尿病、骨质疏松等。</p>
				<p style="margin-left: 130px;">(4)保持心理平衡：愉悦的心情更有益于健康。</p>
				
				
				
				<h4 style="margin-left: 80px;">【指导】</h4>
		
				<p class="left1"><textarea rows="5" cols="150" id="guide" name="guide"></textarea></p>

<%-- 			<c:if test="${flag!=null}"> --%>
				<div style="width:180px;margin:0 auto;border:0px red solid;padding:20px">
					<a href="<%=path%>chiefdoctor/first.handle"><button type="button" class="btn btn-info Product_Details" >返回</button></a>
					<input type="submit" class="btn btn-info Product_Details" onClick="return confirm('确定提交么？') ;" value="提交"/>
				</div>  
<%-- 			</c:if> --%>
		</form>
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
