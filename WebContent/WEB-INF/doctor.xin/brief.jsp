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
  <link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" />
  <!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
  <link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
  <link rel="stylesheet" href="<%=path %>css/style.css"/>
<title>项目小结</title>
</head>
<body>



<div class="page-content">
<h3 class="header smaller lighter blue">
	<div style="float:left">${projectname }</div>
	<div style="float:right">${keshi }</div>
</h3>
  <div class="">
  <
  <table id="" class="table table-striped table-bordered table-hover">
     <c:if test="${keshi=='常规检查室' }">
  
   <thead>
    <tr><th>序号</th><th>项目名称</th><th>结果</th><th>操作</th></tr>
   </thead>
   <tbody>
   <c:forEach items="${dlist }" var="d" varStatus="s">
		<tr>
			<c:if test="${d.type=='普通' }">
				<td>${s.index + 1}</td>
				<td>${d.name}</td>
				<td><input type="text" name="data" id="${d.name}" /></td>
				<td class="center">
				
				<a href="javascript:;" onclick="location ='<%=path %>doctor/brief.handle?data='+document.getElementById('${d.name}').value;">
					<button type="button" class="btn btn-primary" onclick="return confirm('确定提交么？');">提交</button>
				</a>
				
<%-- 				<a href="<%=path %>doctor/brief.handle?data='+document.getElementById('data').value;"><button type="button" class="btn btn-primary" onclick="return confirm('确定提交么？') ;">提交</button></a> --%>
				</td>
			</c:if> 
		</tr>
	</c:forEach>
  </tbody>

  </c:if>
  
  <c:if test="${keshi=='彩超室' }">
  
   <thead>
    <tr><th>序号</th><th>项目名称</th><th>影像</th><th>结果描述</th><th>操作</th></tr>
   </thead>
   <tbody>
   
   <c:forEach items="${dlist }" var="d" varStatus="s">
		<tr>
			<c:if test="${d.type=='影像' }">
				<td>${s.index + 1}</td>
				<td>${d.name}</td>
				<td>上传文件</td>
				<td><input type="text" /></td>
				<td class="center">
				<a href="<%=path %>"><button type="button" class="btn btn-primary" onclick="return confirm('确定提交么？') ;">提交</button></a>
				</td>
			</c:if> 
		</tr>
	</c:forEach>
  </tbody>
 
  </c:if>
  
    <c:if test="${keshi=='检验室' }">
  
   <thead>
    <tr><th>序号</th><th>项目名称</th><th>单位</th><th>参考值</th><th>结果</th><th>提示</th><th>操作</th></tr>
   </thead>
   <tbody>
   
   <c:forEach items="${dlist }" var="d" varStatus="s">
		<tr>
			<c:if test="${d.type=='检验' }">
				<td>${s.index + 1}</td>
				<td>${d.name}</td>
				<td>${d.unit}</td>
				<td>${d.min}-${d.max}</td>
				<td><input type="text" name="result" id="result"/></td>
				<td><input type="text" name="result" id="result"/></td>
				<td class="center">
				<a href="<%=path %>"><button type="button" class="btn btn-primary" onclick="return confirm('确定提交么？') ;">提交</button></a>
				</td>
			</c:if> 
		</tr>
	</c:forEach>
  </tbody>
 
  </c:if>
  
  </table>

  </div>
 </div>
 




	<!--[if !IE]> -->
		<script src="<%=path %>assets/js/jquery.min.js"></script>
		<!-- <![endif]-->
		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=path %>assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=path %>assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
<script src="<%=path %>assets/js/bootstrap.min.js"></script>
<script src="<%=path %>assets/layer/layer.js" type="text/javascript" ></script>
<script src="<%=path %>assets/laydate/laydate.js" type="text/javascript"></script>
<script type="text/javascript">
 //弹出一个iframe层

//$('.gys_bz').on('click', function(){
//    layer.open({
//        type: 2,
//        title: '供应商项目报价',
//        maxmin: true,
//        shadeClose: true, //点击遮罩关闭层
//        area : ['980px' , '400px'],
//        content: '供应商报价.html'
//    });
//});

laydate({
    elem: '#start',
    event: 'focus' 
});
/***判断用户添加文本**/
 jQuery(document).ready(function(){  
 
  $("#btn_search").click(function(){
	// var num=0;
     var str="";
     $("input[type$='text'],select").each(function(n){
          if($(this).val()=="")
          {
              // num++;
			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
                title: '提示框',				
				icon:0,				
          }); 
             // layer.msg(str+=""+$(this).attr("name")+"不能为空！\r\n");
             layer.close(index);
          }
		  
     });
    
});
 });
</script>
</body>
</html>
