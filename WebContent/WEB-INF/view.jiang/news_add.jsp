<%@ page language="java" import="java.util.*" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="<%=path%>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path%>css/style.css" />
<script src="<%=path%>js/jquery-1.8.3.min.js"></script>
<script src="<%=path %>js/jquery.dataTables.min.js"></script>
<script src="<%=path %>js/datatables.bootstrap.min.js"></script>
<title>添加新闻</title>
<script src="<%=path %>js/jquery.validate.min.js"></script>
<script src="<%=path %>js/jquery.validate.cn.js"></script>

<script type="text/javascript">
	function checkadd(){
		
		 var title = document.getElementById("title").value;
		 var time = document.getElementById("time").value;
		 var info = document.getElementById("info").value;
		
		 if(title=='' || time=='' || info==''){
			 alert("信息不全！");
		 }
		 else{
		 var f=confirm('确定添加？')
		 if(f){
			 $.ajax({
				 type:"POST",
				 url:"<%=path%>usermanage/addnews.handle",
				 data:{
					 "title":title,
					 "time":time,
					 "info":info,
					 },
				 dataType:"text",
				 error:function(){
					 alert('ajax请求请求错误...');
				 },
				 success:function(data){
					if(data=="成功"){
						alert("新增成功,前往列表页面！");
						window.location.href="<%=path %>usermanage/newslist.handle";
					}else{
						alert("新增失败,要不再改改？");
					}
					
				 },
			 });
		 }
	}
	}
	
</script>


<style type="text/css">
	input{border-radius:10px}
</style>
</head>

<body>
<!-- <form id="signupForm" action="checkadd()" method="post"> -->
	<div style="width:400px;margin:0 auto;border:1px black solid;border-radius:10px">
    	<table  border="0" align="center">
       		<tr >
            <td colspan="2" align="center">新闻添加</td>
            </tr>
        	<tr>
            	<td>标题</td>
                <td><input type="text" name="title" id="title" /></td>
            </tr>
            <tr>
            	<td>时间</td>
                <td><input type="date" name="time" id="time" /></td>
            </tr>
            <tr>
            	<td>内容</td>
                <td><textarea name="info" id="info" cols="45" rows="5"></textarea></td>
            </tr>
            <tr >
            <td colspan="2" align="center">
            <input type="button" onclick="checkadd()" value="添加" />
	         <a href="<%=path%>usermanage/newslist.handle" >
	           <input type="button" value="返回"/>
	         </a>
            </td>
            </tr>
        </table>
    </div>
<!--    </form> -->
</body>
</html>