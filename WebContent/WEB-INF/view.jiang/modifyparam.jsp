<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="<%=path%>js/jquery-1.4.2.min.js"></script>
<title>添加参数</title>
<script>

function modifyparam(){
	
	var param_id = document.getElementById("param_id").value;
	var pid = document.getElementById("pid").value;
	var name = document.getElementById("name").value;
	
	$.ajax({
		 type:"POST",
		 url:"<%=path%>param/modifyparam.handle",
		 data:{
			 "param_id":param_id,
			 "pid":pid,
			 "name":name
			 },
		 dataType:"text",
		 error:function(){
			 alert('ajax请求请求错误...');
		 },
		 success:function(data){
			if(data=="success"){
				alert("修改参数成功");
				window.location.href="<%=path%>param/findAllParam.handle";
						} else {
							alert(data);
						}

					},
				});
	}
</script>
</head>
<body>
	<form method="post">
		<p align="center">&nbsp;</p>
		<p align="center">&nbsp;</p>
		<p align="center">&nbsp;</p>
		<c:forEach items="${paramlist}" var="p" varStatus="s">
			<p align="center">
				上级参数ID：<input name="pid" type="text" id="pid" value="${p.pid}" />
			</p>
			<p align="center">
				参&nbsp;数&nbsp;名&nbsp;字：<input name="name" type="text" id="name"
					value="${p.name}" />
			</p>
			<p align="center">
				<input name="param_id" type="hidden" id="param_id"
					value="${p.param_id}" />
			</p>
			<p align="center">
				<input type="button" value="提交" onclick="modifyparam()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
					href="<%=path%>param/findAllParam.handle"><input type="button"
					value="返回"></a>
			</p>
		</c:forEach>
	</form>
</body>
</html>