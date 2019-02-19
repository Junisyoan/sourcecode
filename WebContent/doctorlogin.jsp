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
<link href="<%=path %>css/login.css" rel="stylesheet" type="text/css" />
<script src="<%=path%>js/jquery-1.4.2.min.js" ></script>

<script type="text/javascript" >

var show_num = [];

function login(){
	
	 var account = document.getElementById("account").value;
	 var pwd = document.getElementById("pwd").value;
	 var val = $(".input-val").val().toLowerCase();
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

	 $.ajax({
		 type:"POST",
		 url:"<%=path%>doctor/login.handle?login=1",
		 data:{
			 "account":account,
			 "pwd":pwd,
			 },
		 dataType:"text",
		 error:function(){
			 alert('ajax请求请求错误...');
		 },
		 success:function(data){
			if(data!=""){
				alert("登陆成功！您的身份为"+data+"!");
						window.location.href="<%=path %>doctor/toindex.handle?login=2";
			}else{
				alert("登录失败，账号密码错误");
			}
			
		 },
	 });

}

$(function(){
    draw(show_num);
})

function cli(){
    draw(show_num);
}

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
        var deg = Math.random() * 30 * Math.PI / 180;//产生0~30
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



</head>

<body class="login">
	<div class="login_logo" style="margin-top:68px;font-size:35px;">医生工作站</div>
<div class="login_m">
	<div class="login_boder">
	
<%-- 	<form  action="<%=path%>doctor/login.handle?login=1" method="post"> --%>
	
		<div class="login_padding">
			<div>
				用户名<input type="text" id="account" name="account" class="txt_input txt_input2" style="width:250px;margin-top:20px"/>
			</div>
			
			<div>
				密&nbsp;&nbsp;&nbsp;码<input type="password" name="pwd" id="pwd" class="txt_input" style="width:250px"/>
			</div>
			<div style="width:350px;height:55px;border:0px solid red">
			
				<div style="float:left">验证码<input type="text" value="" placeholder="请输入验证码" class="input-val txt_input" style="width:120px;height:38px;border-radius: 3px;margin-top:5px"/></div>
				<div style="float:left;margin-left:8px"><canvas onclick="cli()" id="canvas" width="120" height="40" style="border:0px solid red;"></canvas></div>
			
			</div>
			<div class="rem_sub">
				
				<label>
				<a onclick="login()">
					<input type="button" class="sub_button" name="button" value="登录" style="margin-top:15px;" />
				</a>
				</label>
			</div>
		</div>
		
<!-- 		</form> -->
	</div><!--login_boder end-->
</div><!--login_m end-->

<br />
<br />
<p align="center">版权所有：传一科技</p>

</body>
</html>