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
<title>登录</title>

<link href="<%=path %>css/login.css" rel="stylesheet" type="text/css">

</head>

<body class="login">
	<div class="login_logo" style="margin-top:68px;font-size:35px;">医生工作站</div>
<div class="login_m">
	<div class="login_boder">
	
	<form  action="<%=path%>doctor/login.handle" method="post">
	
		<div class="login_padding">
			<h2>用户名</h2>
			<label>
				<input type="text" id="account" name="account" class="txt_input txt_input2">
			</label>
			<h2>密码</h2>
			<label>
				<input type="password" name="pwd" id="pwd" class="txt_input">
			</label>
			<div class="rem_sub">
				<div class="rem_sub_l">
					<input type="checkbox" name="checkbox" id="save_me">
					<label for="checkbox">记住</label>
				</div>
				<label>
					<input type="submit" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;">
				</label>
			</div>
		</div>
		
		</form>
	</div><!--login_boder end-->
</div><!--login_m end-->

<br />
<br />
<p style="margin:0 auto">版权所有：传一科技</p>

</body>
</html>