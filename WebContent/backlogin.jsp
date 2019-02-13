<%@ page language="java" import="java.util.*"
	contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>一卡通系统后台登录</title>
<link rel="stylesheet" type="text/css" href="<%=path%>css/backlogin.css" />
<script src="<%=path%>js/jquery-1.4.2.min.js"></script>
<script>

// function turn(){
	
<%-- 	window.location.href="<%=path%>user/findRoleOne.handle"; --%>
	
// }

function passwordIsTrue(){
	
	var account = document.getElementById("account").value;
	var pwd = document.getElementById("pwd").value;
	 $.ajax({
		 type:"POST",
		 url:"user/login.handle",
		 data:{
			 "account":account,
			 "pwd":pwd,
			 },
		 dataType:"text",
		 error:function(){
			 alert('ajax请求请求错误...');
		 },
		 success:function(data){
			if(data=="管理员"){
				alert("登陆成功！您的身份为管理员！");
				window.location.href="<%=path%>user/index.handle";
			}else{
				alert(data);
			}
			
		 },
	 });
 }


</script>
</head>

<body background="<%=path%>image/bkg.jpg">

	<p id="top">后台登录</p>
	<div id="login">
		<form method="post">
			<table width="303">
				<tr>
					<td height="33" colspan="3">后台登录</td>
				</tr>
				<tr>
					<td width="65" height="30">用户名:</td>
					<td width="222" colspan="2"><input type="text" name="account"
						id="account" /></td>
				</tr>
				<tr>
					<td height="23">密码:</td>
					<td colspan="2"><input type="password" name="pwd" id="pwd" /></td>
				</tr>
				<tr>
					<td height="35" colspan="3"><input type="button"
						onClick="passwordIsTrue()" value="登录" style="width: 100px;" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
