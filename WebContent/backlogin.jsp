<%@ page language="java" import="java.util.*"
	contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>健康团检系统后台登录</title>
 <script src="<%=path%>js/jquery.min.js"></script>
  <script src="<%=path%>js/jquery.validate.min.js"></script>
  <script src="<%=path%>js/jquery.validate.cn.js"></script>  
  <script src="<%=path %>assets/js/jquery.min.js"></script>
  <script src="<%=path %>assets/layer/layer.js" type="text/javascript"></script>  
  <link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" />
  <link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
  <link rel="stylesheet" href="<%=path %>css/style.css"/>
  <link href="<%=path %>js2/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="<%=path %>js2/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css">
  <script src="<%=path %>js2/jquery-1.8.3.min.js"></script>
  <script src="<%=path %>js2/datatables.bootstrap.min.js"></script>
  <script src="<%=path %>js2/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>css/backlogin.css" />
<script>

// function turn(){
	
<%-- 	window.location.href="<%=path%>user/findRoleOne.handle"; --%>
	
// }

var show_num = [];
function passwordIsTrue(){
	
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
		 url:"<%=path%>user/login.handle",
		 data:{
			 "account":account,
			 "pwd":pwd,
			 "login":"login"
			 },
		 dataType:"text",
		 error:function(){
			 alert('ajax请求请求错误...');
		 },
		 success:function(data){
			if(data=="管理员"){
				alert("登陆后台成功！！");
				window.location.href="<%=path%>user/index.handle";
			}else{
				alert(data);
			}
			
		 },
	 });
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
<script>
var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
	function forgetPassWord(){
		layer.open({
	        type: 1,
	        title: '寻找密码',
			shadeClose: true, //点击遮罩关闭层
	        area: ['600px' , ''],
	        content: $('#Add_Product_style'),
			btn:['提交','取消'],
			yes: function(index, layero){	
				if(!reg.test($('#mailAddress').val())){
					layer.alert('邮箱格式有误!',{title: '提示框',icon:0,});
					return false;
					
				}
				$.ajax({
		    		type:"POST",
		    		dataType:"text",
		    		url:"<%=path%>forgetPassword/changePwd.handle",
		    		data:{
		    			"mailAddress":$('#mailAddress').val(),
		    			"login":"login"
		    		},
		    		success:function(msg){
		    			layer.alert(msg);
		    			if(msg == "密码重置成功，已发送至您的邮箱"){
		    				layer.close(index);
		    			}
		    		},
		    		error : function(msg) {
		    			alert("异常！"+msg);
		    		}
		    	});
				}
			})
	}
</script>

<style>
.left{
	text-align:left
}
.right{
 	text-align:right
}
.forgetPwd{
	font-size:80%;
	color:blue;
}
.forgetPwd.hand:hover   {cursor:move}   
</style>
</head>

<body background="<%=path%>image/bkg.jpg">
	<div id="Add_Product_style" style="display: none;">
		<div class="page-content">
			<div class="add_user_style clearfix">
				<form id="addForm">
					<ul class="clearfix">
						<li>
							<label class="label_name" style="margin-left:50px;">邮箱：</label> 
							<input type="text" name="mailAddress" id="mailAddress" style="width:400px;">
						</li>
					</ul>
				</form>
			</div>
		</div>
	</div>
	<p id="top">后台登录</p>
	<div id="login" style = "width:330px;">
		<form method="post">
			<table width="330">
				<tr>
					<td height="33" colspan="3">后台登录</td>
				</tr>
				<tr>
					<td width="65" height="30" class="right">用户名:</td>
					<td width="222" colspan="2" class="left"><input type="text" name="account"
						id="account" /></td>
				</tr>
				<tr>
					<td height="23" class="right">密码:</td>
					<td colspan="2" class="left">
						<input type="password" name="pwd" id="pwd"/>
						<span class="forgetPwd" id = "forgetPwd" onclick = "forgetPassWord()">忘记密码</span>
					</td>
				</tr>
				<tr>
            	<td class="right">验证码:</td>
            		<td class="left" style="width:82px;">
            			<input type="text" value="" placeholder="请输入验证码" class="input-val" style="width:80px;"/>
            		</td>
            		<td class="left">
            			<canvas id="canvas" width="100" height="40"></canvas>
            		</td>
           		</tr>
				<tr>
					<td height="35" colspan="3">
					<input type="button" onclick="passwordIsTrue()" value="登录" style="width: 100px;" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

