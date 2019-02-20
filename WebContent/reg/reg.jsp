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
							<input type="text" name="people" id="people" placeholder="紧急联系人姓名" />
						</div>
						<div class="ececk_warning">
							<span>体检带队人姓名不能为空</span>
						</div>

						<div class="form_text_ipt">
							<input type="text" name="phone" id="phone" placeholder="紧急联系人手机号" />
						</div>
						<div class="ececk_warning">
							<span>带队人手机号不能为空</span>
						</div>

<!-- 						<div class="form_text_ipt"> -->
<!-- 							<input name="code" type="text" placeholder="验证码"> -->
<!-- 						</div> -->
<!--             			<div class="right">验证码:</div> -->
<!--             			<div class="form_text_ipt"> -->
            				<input type="text" id="c" placeholder="请输入验证码" style="padding:10px;"/>
<!--             			</div> -->
            			<div class="left">
            				<canvas id="canvas" width="100" height="40"></canvas>
            			</div>

						<div class="form_btn">
							<button type="button" onclick="doSubmitForm();">注册</button>
						</div>
						<div class="form_reg_btn">
							<button type="button" onclick="javascript:window.history.back();">返回</button>
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
<script>
var show_num = [];
function passwordIsTrue(){
	
	var val = $("#c").val().toLowerCase();
    var num = show_num.join("");
    
    if(val==''){
        alert('请输入验证码！');
        return false;
    }else if(val != num){
    	 alert('验证码错误！请重新输入！');
         $(".input-val").val('');
         draw(show_num);
         return false;
    }
    return true;
 }

$(function(){
    draw(show_num);

    $("#canvas").on('click',function(){
        draw(show_num);
    })
})

function draw(show_num) {
    var canvas_width=$('#canvas').width();
    var canvas_height=$('#canvas').height();
    var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
    var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
    canvas.width = canvas_width;
    canvas.height = canvas_height;
    var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
    var aCode = sCode.split(",");
    var aLength = aCode.length;//获取到数组的长度
    
    for (var i = 0; i <= 3; i++) {
        var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
        var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
        var txt = aCode[j];//得到随机的一个内容
        show_num[i] = txt.toLowerCase();
        var x = 10 + i * 20;//文字在canvas上的x坐标
        var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
        context.font = "bold 23px 微软雅黑";

        context.translate(x, y);
        context.rotate(deg);

        context.fillStyle = randomColor();
        context.fillText(txt, 0, 0);

        context.rotate(-deg);
        context.translate(-x, -y);
    }
    for (var i = 0; i <= 5; i++) { //验证码上显示线条
        context.strokeStyle = randomColor();
        context.beginPath();
        context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
        context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
        context.stroke();
    }
    for (var i = 0; i <= 30; i++) { //验证码上显示小点
        context.strokeStyle = randomColor();
        context.beginPath();
        var x = Math.random() * canvas_width;
        var y = Math.random() * canvas_height;
        context.moveTo(x, y);
        context.lineTo(x + 1, y + 1);
        context.stroke();
    }
}

function randomColor() {//得到随机的颜色值
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb(" + r + "," + g + "," + b + ")";
}

</script>
<style>
.left{
	text-align:left
}
.right{
 	text-align:right
}
</style>

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
		if(passwordIsTrue()){
			form.submit();
		}
	}
</script>
</html>
