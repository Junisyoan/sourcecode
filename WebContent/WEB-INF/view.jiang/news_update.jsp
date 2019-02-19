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
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
 <![endif]-->
<link rel="stylesheet" href="<%=path%>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path%>css/style.css" />
<script src="<%=path%>js/jquery-1.8.3.min.js"></script>
<script src="<%=path %>js/jquery.dataTables.min.js"></script>
<script src="<%=path %>js/datatables.bootstrap.min.js"></script>
<title>修改新闻</title>
<script src="<%=path %>js/jquery.validate.min.js"></script>
<script src="<%=path %>js/jquery.validate.cn.js"></script>

<script type="text/javascript">

function checkupdate(){
var title = document.getElementById("title").value;
var time = document.getElementById("time").value;
var info = document.getElementById("info").value;
var new_id = document.getElementById("new_id").value;

if(title=='' || time=='' || info==''){
	 alert("修改失败,信息不全！");
}
else{
var f=confirm('确定修改？')
if(f){
	 $.ajax({
		 type:"POST",
		 url:"<%=path%>usermanage/updatenews.handle",
		 data:{
			 "title":title,
			 "time":time,
			 "info":info,
			 "new_id":new_id,
			 },
		 dataType:"text",
		 error:function(){
			 alert('ajax请求请求错误...');
		 },
		 success:function(data){
			if(data=="成功"){
				alert("修改成功,前往列表页面！");
				window.location.href="<%=path %>usermanage/newslist.handle";
			}else{
				alert("修改失败,要不再试试？");
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
<%-- <form id="signupForm" action="<%=path %>usermanage/updatenews.handle" method="post"> --%>
	<div style="width:400px;margin:0 auto;border:1px black solid;border-radius:10px">
    	<table  border="0" align="center">
       		<tr >
            <td colspan="2" align="center">新闻修改</td>
            </tr>
            <input type="hidden" name="new_id" id="new_id" value="${news.new_id }"/>
        	<tr>
            	<td>标题</td>
                <td><input type="text" name="title" id="title" value="${news.title }"/></td>
            </tr>
            <tr>
            	<td>时间</td>
                <td><input type="date" name="time" id="time" value="${news.time }"/></td>
            </tr>
            <tr>
            	<td>内容</td>
                <td><textarea name="info" id="info" cols="45" rows="5" >${news.info }</textarea></td>
            </tr>
            <tr >
            <td colspan="2" align="center">
            <input type="button" onclick="checkupdate()" value="修改" />
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