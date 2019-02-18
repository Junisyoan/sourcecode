<%@ page contentType="text/html; charset=utf-8" language="java"
import="java.sql.*" errorPage=""%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>css/medical_workstation_css/company-login.css">
    <script type="text/javascript" src="<%=path%>js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".name input").focus(function(){
                $(this).prev("i").css({"background-image":"url(<%=path%>image/medical_workstation/user2.png)"});
            });
            $(".name input").blur(function(){
                $(this).prev("i").css({"background-image":"url(<%=path%>image/medical_workstation/user1.png)"});
            });
            $(".password input").focus(function(){
                $(this).prev("i").css({"background-image":"url(<%=path%>image/medical_workstation/password2.png)"});
            });
            $(".password input").blur(function(){
                $(this).prev("i").css({"background-image":"url(<%=path%>image/medical_workstation/password1.png)"});
            });
        });
    </script>
<script>

var show_num = [];

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

function check(){
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
}
</script>
</head>
<body>
    <div class="container">
        <div class="wrap">
            <header><em></em><span>HealthCare体检中心</span></header>
            <article>
                <section>
                    <aside>
                        <em>
                            <img src="<%=path%>image/medical_workstation/user.png">
                        </em>
                         <form action="company/loginCompany.handle?login=12" method="post" onsubmit="return check()">
                            <p class="name"><i></i><input type="text" name="userName" name="userName" class="userName" placeholder="请输入用户名"></p>
                            <p class="password"><i></i><input type="password" name="password" class="pwd" placeholder="请输入密码"></p>
                            <p>
                            <input type="text" value="" placeholder="请输入验证码" class="input-val" style="width:140px;"/>
                            <canvas id="canvas" width="100" height="40"></canvas></p>
                            <button>登录</button>
                            <p class="remember"><input type="checkbox" name="remember">记住密码</p>
                            <p class="regist"><span>没有账号?</span><a href="reg_company.html">立即注册</a></p>
                            <div class="clear"></div>
                        </form>
                    </aside>
                </section>               
            </article>
        </div>
    </div>
</body>
</html>
