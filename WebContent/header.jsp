<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
<<<<<<< HEAD
			+ request.getContextPath() + "/";
=======
	+ request.getContextPath() + "/";
>>>>>>> 913a1fbc9f69b47369d61595ee77865e690e91a4
%>
<div class="header-bg">
<div class="wrap">
	<div class="logo">
  		<a href="<%=path%>home/findindex.so"><img src="<%=path%>/image/index1/logo.png" alt="体检中心"> </a>
 	</div>
	<div class="search">
	    <button class="yellow-button" onclick="javascript:location.href='<%=path%>login_company.jsp'"><span>登录</span></button>
        <button class="yellow-button" onclick="javascript:location.href='<%=path%>reg/reg.jsp'"><span>注册</span></button>
	</div>
   <div class="clear"></div>
</div>
</div>
	<div class="clear"></div>
<div class="nav1-bg">
<div class="wrap">
	<div class="nav"> 
 	<ul>
<<<<<<< HEAD
 		<li class="active"><a href="<%=path%>home/findindex.so">HOME</a></li>
 		<li><a href="<%=path%>home/findabout.so">关于</a></li>
 		<li><a href="<%=path%>home/findcombo.so">热门套餐</a></li>
 		<li><a href="combos.jsp">套餐介绍</a></li>
		<li><a href="<%=path%>home/findencyclopedia.so">体检百科</a></li>
 		<li><a href="<%=path%>home/findcontact.so">联系我们</a></li>
=======
 		<li class="active"><a href="index.jsp">HOME</a></li>
 		<li><a href="<%=path %>about.jsp">关于</a></li>
 		<li><a href="<%=path %>services.html">服务类别</a></li>
 		<li><a href="<%=path %>comboshow/introduce.so">套餐介绍</a></li>
		<li><a href="<%=path %>projects.jsp">项目介绍</a></li>
 		<li><a href="<%=path %>contact.jsp">联系我们</a></li>
>>>>>>> 913a1fbc9f69b47369d61595ee77865e690e91a4
 	</ul>      
  	</div>
  	<div class="clear"></div>
</div>
</div>
