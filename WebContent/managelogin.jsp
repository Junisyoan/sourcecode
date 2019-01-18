<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<script>

function passwordIsTrue(){
	
	var name = document.getElementById("name").value;
	var pwd = document.getElementById("pwd").value;
	var kcode =  document.getElementById("checkCode").value;
	 $.ajax({
		 type:"POST",
		 url:"user/login.action",
		 data:{
			 "name":name,
			 "pwd":pwd,
			 "checkCode":kcode
			 },
		 dataType:"text",
		 error:function(){
			 alert('ajax请求请求错误...');
		 },
		 success:function(data){
			if(data=="管"){
				alert("登陆成功！您的身份为管理员！");
				window.location.href="<%=path%>user/findRoleOne.action";
			}else if(data=="普通用户"){
				alert("登陆成功！您的身份为普通用户！");
				window.location.href="<%=path%>user.jsp";
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


<head>
<meta charset="UTF-8">
<title>后台登录</title>
<link rel="stylesheet" href="<%=path%>css/jigsaw.css">
<style>
.container {
	width: 310px;
	margin: 100px auto;
}

input {
	display: block;
	width: 290px;
	line-height: 40px;
	margin: 10px 0;
	padding: 0 10px;
	outline: none;
	border: 1px solid #c8cccf;
	border-radius: 4px;
	color: #6a6f77;
}

#msg {
	width: 100%;
	line-height: 40px;
	font-size: 14px;
	text-align: center;
}

a:link, a:visited, a:hover, a:active {
	margin-left: 100px;
	color: #0366D6;
}
</style>
</head>
<body>
	<form action="<%=path%>user/" method="post">
		<p id="top">
		<h1 align="center" style="color: #09F;">体检系统后台登录</h1>
		</p>
		<div class="container">
			<input type="text" name="name" id="name" /> <input type="password"
				name="pwd" id="pwd" />

			<div id="captcha" style="position: relative"></div>
			<div id="msg">
			
			</div>
		</div>
		<script src="<%=path%>js/jigsaw.js"></script>
		<script>
			jigsaw.init(document.getElementById('captcha'), function() {
				document.getElementById('msg').innerHTML = '验证成功'
			})
		</script>
		<input type="button" onClick="passworxdIsTrue()" value="登录"
			style="width: 100px;" /> <input type="button" value="注册"
			style="width: 100px;" />
		
	</form>
</body>

</html>
