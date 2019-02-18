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
    <link rel="stylesheet" type="text/css" href="<%=path %>css/medical_workstation_css/company-login.css">
    <script type="text/javascript" src="<%=path %>js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".name input").focus(function(){
                $(this).prev("i").css({"background-image":"url(<%=path %>image/medical_workstation/user2.png)"});
            });
            $(".name input").blur(function(){
                $(this).prev("i").css({"background-image":"url(<%=path %>image/medical_workstation/user1.png)"});
            });
            $(".password input").focus(function(){
                $(this).prev("i").css({"background-image":"url(<%=path %>image/medical_workstation/password2.png)"});
            });
            $(".password input").blur(function(){
                $(this).prev("i").css({"background-image":"url(<%=path %>image/medical_workstation/password1.png)"});
            });
        });
    </script>
</head>
<body>
    <div class="container">
        <div class="wrap">
            <header><em></em><span>HealthCare</span></header>
            <article>
                <section>
                    <aside>
                        <em>
                            <img src="<%=path%>image/medical_workstation/user.png">
                        </em>
                         <form action="nurse/loginUser.handle?login=9" method="post">
                            <p class="name"><i></i><input type="text" name="account" id="account" class="account" placeholder="请输入用户名"></p>
                            <p class="password"><i></i><input type="password" name="pwd" id="pwd" class="pwd" placeholder="请输入密码"></p>
                            <button>登录</button>
                        </form>
                    </aside>
                   
                </section>               
            </article>
        </div>
    </div>
</body>
</html>
