<%@ page language="java" contentType="text/html; charset=utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String path=request.getScheme()+"://"+request.getServerName()+":"
	+request.getServerPort()+request.getContextPath()+"/";	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"></script>
<script src="<%=path %>js/jquery.min.js"></script>
<script src="<%=path %>js/jquery.validate.min.js"></script>
<script src="<%=path %>js/jquery.validate.cn.js"></script>

<script type="text/javascript" src="<%=path %>jss/jquery-1.3.2.min.js"></script> 
<script type="text/javascript" src="<%=path %>jss/easy_validator.pack.js"></script> 
<script type="text/javascript" src="<%=path %>jss/jquery.bgiframe.min.js"></script> 
<link  href="<%=path %>jss/validate.css" rel="stylesheet" type="text/css" />
</head>
 
<body>
 
<%-- <form action="<%=path%>menumanage/updetemenu2.handle" method="post" id="ccc"> --%>
<!-- <ul class="clearfix"> -->
<%--      <li> <label class="label_name"   >序号</label>  <input name="menu_id" type="text"  readonly="readonly" class="text_add" id="menu_id" value="${updetename}"/></li> --%>
<!--      	<li> <label class="label_name"   >菜单名</label><input name="name" type="text"  class="text_add" id="name"/><i style="color:#F60; ">只能修改成未拥有的菜单名</i></li> -->
<!--      	  <li><label class="label_name">路径</label><input name="link" type="text"  class="text_add" id="link"/><i style="color:#F60; ">*</i></li> -->
<!--      	  <li><label class="label_name">上级菜单</label><input name="superior" type="text"  class="text_add" id="superior"/><i style="color:#F60; ">*</i></li> -->
      	
<!--      	</ul> -->
<!-- <input type="submit" value="提交"> -->
<!-- <button onclick="window.history.back();">返回</button> -->
<!-- </form> -->

<h1>修改菜单</h1>

 

<form name="validateForm1" action="<%=path%>menumanage/updetemenu2.handle" method="post" id="ccc">

<table width="800" border="0" class="ad" cellpadding="0" cellspacing="1" bgcolor="#999999" id="testTable">

 　　<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		序号 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		<input name="menu_id" type="text" id="flightno" value="${updetename}" reg="^\w{2}\d+$" tip="游戏商名称[2个字母简写]+用户ID[数字] 如: sd10059"/>

		</td>

	</tr>

	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		菜单名 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		<input name="name" type="text" id="floatNum" reg="^[\u4e00-\u9fa5]+$" tip="只允许中文字符"/><i style="color:#F60; "> 菜单名</i>

		</td>

	</tr>

	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		路径 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		<input name="link" type="text" id="str" reg="^\d{3}-\d{8}$|^\d{4}-\d{7}$" tip="国内电话号码，格式: 0832-4405222 或 021-87888822"/><i style="color:#F60; "> *</i>

		</td>

	</tr>

	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		上级菜单ID : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		<input name="superior" type="text" id="groupname" reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="邮箱地址，如wangking717@qq.com" /><i style="color:#F60; "> 请输入已存在的上级菜单ID</i>

		</td>

	</tr>

<!-- 	<tr bgcolor="#ffffff"> -->

<!-- 		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;"> -->

<!-- 		来自哪里 :  -->

<!-- 		</td> -->

<!-- 		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;"> -->

<!-- 		<select id="from" name="from" reg="[^0]" tip="一定要选择哟"> -->

<!-- 		  <option value="0">－－请选择你来自哪里－－</option> -->

<!-- 		  <option value="a">北京</option> -->

<!-- 		  <option value="b">上海</option> -->

<!-- 		  <option value="c">四川</option> -->

<!-- 		</select> <span name="easyTip"></span> -->

<!-- 		</td> -->

<!-- 	</tr> -->

	<tr bgcolor="#ffffff">

	<td colspan="2" align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

	<input type="submit" name="submit" value=" 提交 " id="submit" />
	<button onclick="window.history.back();">返回</button>
	</td>

	</tr>

</table>

</form>
</body>
 
</html>