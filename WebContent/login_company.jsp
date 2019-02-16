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
    <link rel="stylesheet" type="text/css" href="css/medical_workstation_css/company-login.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".name input").focus(function(){
                $(this).prev("i").css({"background-image":"url(image/medical_workstation/user2.png)"});
            });
            $(".name input").blur(function(){
                $(this).prev("i").css({"background-image":"url(image/medical_workstation/user1.png)"});
            });
            $(".password input").focus(function(){
                $(this).prev("i").css({"background-image":"url(image/medical_workstation/password2.png)"});
            });
            $(".password input").blur(function(){
                $(this).prev("i").css({"background-image":"url(image/medical_workstation/password1.png)"});
            });
        });
    </script>
</head>
<body>
    <div class="container">
        <div class="wrap">
            <header><em><img src="<%=path%>/image/index1/logo.png"></em><span>传一团检体检中心</span></header>
            <article>
                <section>
                    <aside>
                        <em>
                            <img src="image/medical_workstation/user.png">
                        </em>
                         <form action="company/loginCompany.handle?login=12" method="post">
                            <p class="name"><i></i><input type="text" name="userName" name="userName" class="userName" placeholder="请输入用户名"></p>
                            <p class="password"><i></i><input type="password" name="password" class="pwd" placeholder="请输入密码"></p>
                            <button>登录</button>
                            <p class="remember"><input type="checkbox" name="remember">记住密码</p>
                            <p class="regist"><span>没有账号?</span><a href="reg_company.html">立即注册</a></p>
                            <div class="clear"></div>
                        </form>
                    </aside>
                   
                </section>               
            </article>
            <footer>
                <ul>
                    <li><a href="#">联系我们</a></li>
                    <li><a href="#">关于我们</a></li>
                    <li><a href="#">人才招聘</a></li>
                    <li><a href="#">友情链接</a></li>
                    <li><a href="#">公司地址</a></li>
                    <li><a href="#">关注我们</a></li>
                </ul>
                <p>本网站版权归╳╳╳技术有限公司所有，未经许可，不得转载。</p>
            </footer>
        </div>
    </div>
</body>
</html>
