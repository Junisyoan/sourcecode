<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<meta charset="utf-8">
<title>注册界面</title>
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.cn.js"></script>
</head>
<body>
	<div class="wrap login_wrap">
		<div class="content">

			<div class="logo"></div>

			<div class="login_box">

				<div class="login_form">
					<div class="login_title">注册</div>
					<form action="<%=path %>company/regCompany.so" method="post" id="regCompany">
						<div class="form_text_ipt">
							<input type="text" name="name" id="name" placeholder="公司名称" />
						</div>
						<div class="ececk_warning">
							<span>公司名称不能为空</span>
						</div>

						<div class="form_text_ipt">
							<input type="text" name="account" id="account" placeholder="账户，5-18个字符" />
						</div>
						<div class="ececk_warning">
							<span>账户名称不能为空</span>
						</div>

						<div class="form_text_ipt">
							<input name="pwd" id="pwd" type="password" placeholder="密码：6-18个字符">
						</div>
						<div class="ececk_warning">
							<span>密码不能为空</span>
						</div>

						<div class="form_text_ipt">
							<input name="repassword" id="rpwd" type="password" placeholder="重复密码">
						</div>
						<div class="ececk_warning">
							<span>密码不能为空</span>
						</div>

						<div class="form_text_ipt">
							<input type="text" name="tel" id="tel" placeholder="公司座机号，11位" />
						</div>
						<div class="ececk_warning">
							<span>公司座机号不能为空</span>
						</div>

						<div class="form_text_ipt">
							<input type="text" name="address" id="address" placeholder="公司地址" />
						</div>
						<div class="ececk_warning">
							<span>公司地址不能为空</span>
						</div>

						<div class="form_text_ipt">
							<input type="text" name="people" id="people" placeholder="体检带队人姓名" />
						</div>
						<div class="ececk_warning">
							<span>体检带队人姓名不能为空</span>
						</div>

						<div class="form_text_ipt">
							<input type="text" name="phone" id="phone" placeholder="带队人手机号" />
						</div>
						<div class="ececk_warning">
							<span>带队人手机号不能为空</span>
						</div>

						<div class="form_text_ipt">
							<input name="code" type="text" placeholder="验证码">
						</div>
						<div class="ececk_warning">
							<span>验证码不能为空</span>
						</div>

						<div class="form_btn">
							<button type="button" onclick="doSubmitForm();">注册</button>
						</div>
						<div class="form_reg_btn">
							<span>已有帐号？</span><a href="login_company.html">马上登录</a>
						</div>
					</form>
					<br />
				</div>
			</div>
		</div>
	</div>
	<div style="text-align: center;"></div>
</body>


<script type="text/javascript">
	$(function() {
		$("#regCompany").validate({
			rules : {
				name : {
					required : true
				},
				account : {
					required : true,
					maxlength : 20,
					minlength : 5
				},
				pwd : {
					required : true,
					maxlength : 20,
					minlength : 6
				},
				tel : {
					required : true,
					number : true
				},
				address : {
					required : true
				},
				people : {
					required : true
				},
				phone : {
					required : true,
					number : true
				}
			}
		});

		$("#name").blur(function() {
			if ($("#name").val()=="") {
				return;
			}
			$.ajax({
				type : "post",
				dataType : "text",
				data : {'name' : $("#name").val()},
				url : "<%=path%>company/queryName.so",
				success : function(retData) {
					if(retData=="0"){
						alert("公司名已被注册");
					}
				},
				error : function() {
					alert('服务器连接失败');
				}
			});
		});

		$("#account").blur(function() {
			if ($("#account").val() == "") {
				return;
			}
			$.ajax({
				type : "post",
				dataType : "text",
				data : {'account' : $("#account").val()},
				url : "<%=path%>company/queryAccount.so",
				success : function(retData) {
					if(retData=="0"){
						alert("用户名已被注册");
					}
				},
				error : function() {
					alert('服务器连接失败');
				}
			});
		});

		$("#tel").blur(function() {
			if ($("#tel").val() == "") {
				return;
			}
			$.ajax({
				url : "<%=path%>company/queryTel.so",
				type : "post",
				dataType : "text",
				data : {'tel' : $("#tel").val()},
				success : function(retData) {
					if(retData=="0"){
						alert("座机号码已被注册");
					}
				},
				error : function() {
					alert('服务器连接失败');
				}
			});
		});
	});
	
	function doSubmitForm(){
		var form = document.getElementById('regCompany');
		form.submit();
	}
</script>
</html>
