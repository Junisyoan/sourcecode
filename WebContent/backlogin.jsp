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
	var kcode =  document.getElementById("checkCode").value;
	 $.ajax({
		 type:"POST",
		 url:"user/login.handle",
		 data:{
			 "account":account,
			 "pwd":pwd,
			 "checkCode":kcode
			 },
		 dataType:"text",
		 error:function(){
			 alert('ajax请求请求错误...');
		 },
		 success:function(data){
			if(data=="管理员"){
				alert("登陆成功！您的身份为管理员！");
				window.location.href="<%=path%>user/index.handle";
			}else if(data=="医生"){
				alert("登陆成功！您的身份为医生！");
				window.location.href="<%=path%>doctor/index.handle";
			}else if(data=="后台"){
				alert("登陆成功！");
				window.location.href="<%=path%>user/index.handle";
			}
			else{
				document.getElementById("checkCode").value = "";
				document.getElementById("img").src="<%=path%>admin/checkcode.action?c="+Math.random();
				alert(data);
			}
			
		 },
	 });
 }


</script>

<script>

	function Code() {
		document.getElementById("img").src="<%=path%>
	admin/checkcode.action?p="
				+ Math.random();
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
					<td width="222" colspan="2"><input type="text" name="account" id="account" /></td>
				</tr>
				<tr>
					<td height="23">密码:</td>
					<td colspan="2"><input type="password" name="pwd" id="pwd" /></td>
				</tr>

				<tr>
					<td>验证码:</td>
					<td><input type="text" name="checkCode" id="checkCode"
						style="width: 90px; margin-left: 10px" /></td>
					<td><img id="img" src="<%=path%>admin/checkcode.action"
						onclick="Code()" style="padding-left: 0px"></td>
				</tr>

				<tr>
					<td height="35" colspan="3"><input type="button"
						onClick="passwordIsTrue()" value="登录" style="width: 100px;" /> <a
						href="<%=path%>register.jsp"><input type="button" value="注册"
							style="width: 100px;" /></a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
