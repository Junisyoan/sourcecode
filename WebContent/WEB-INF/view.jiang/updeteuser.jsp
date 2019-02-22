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
<center>
<%--  <i style="color:#F60; ">***必须按要求填写***</i></center> --%>
<%-- <form action="<%=path%>usermanage/updeteuser.handle" method="post" id="ccc"> --%>
<!-- <ul class="clearfix"> -->
<%--      <li> <label class="label_name"   >序号</label>  <input name="user_id" type="text"  readonly="readonly" class="text_add" id="user_id" value="${updetename}"/></li> --%>
<!--      	<li> <label class="label_name"   >部门角色id</label><input name="role_dept_id" type="text"  class="text_add" id="role_dept_id"/><i style="color:#F60; ">只能修改已拥有的部门角色id</i></li> -->
<!--      	  <li><label class="label_name">账号</label><input name="account" type="text"  class="text_add" id="account"/><i style="color:#F60; ">*</i></li> -->
<!--       <li><label class="label_name">密码</label><input name="pwd" type="password"  class="text_add" id="pwd"/><i style="color:#F60; ">*</i></li> -->
<!--       <li><label class="label_name">参数ID</label><input name="param_id" type="text"  class="text_add" id="param_id"/><i style="color:#F60; ">角色是医生时需加(2常规检查室,3彩超室,4检验室)</i></li> -->
<!--       <li><label class="label_name">性别</label><input name="sex" type="text"  class="text_add" id="sex"/><i style="color:#F60; ">只能男.女</i></li> -->
<!--       <li><label class="label_name">联系人身份</label><input name="IDcard" type="text"  class="text_add" id="IDcard"/><i style="color:#F60; ">*</i></li> -->
<!--       <li><label class="label_name">联系电话</label><input name="phone" type="text"  class="text_add" id="phone"/><i style="color:#F60; ">11位数数字</i></li> -->
<!--       <li><label class="label_name">联系地址</label><input name="address" type="text"  class="text_add" id="address"/><i style="color:#F60; ">*</i></li> -->
<!--        <li> <label class="label_name">状态</label><input name="state" type="text"  class="text_add" id="state"/><i style="color:#F60; ">启用*禁用</i></li> -->
 
<!--      	</ul> -->
<!-- <input type="submit" value="提交"> -->

<!-- </form> -->
<!-- <button onclick="javascript:window.history.back();">返回</button> -->


<h1>修改菜单</h1>

 

<form name="validateForm1"  action="<%=path%>usermanage/updeteuser.handle" method="post" id="ccc">

<table width="800" border="0" class="ad" cellpadding="0" cellspacing="1" bgcolor="#999999" id="testTable">

 　　<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		序号 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		<input name="user_id" type="text" id="user_id" value="${updetename}" readonly="readonly"  reg="^\w{2}\d+$" tip="游戏商名称[2个字母简写]+用户ID[数字] 如: sd10059"/>

		</td>

	</tr>

	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		部门 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

  			<select name="role_dept_id" id="role_dept_id" value="${u.role_dept_id}"    style=" width:153px;"> 
      		 <c:forEach items="${tb_deptlist}" var="u" varStatus="s">
            <option value="${u.role_dept_id}">${u.name}</option> 
            </c:forEach> 
        </select>
		<i style="color:#F60; "> *</i>



		</td>

	</tr>

	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		账号 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		<input name="account" type="text" id="account" reg="^\d{3}-\d{8}$|^\d{4}-\d{7}$" tip="国内电话号码，格式: 0832-4405222 或 021-87888822"/><i style="color:#F60; "> *</i>

		</td>

	</tr>

	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		密码 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		<input name="pwd" type="password" id="pwd" reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="邮箱地址，如wangking717@qq.com" /><i style="color:#F60; "> 请输入已存在的上级菜单ID</i>

		</td>

	</tr>
	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		性别 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

<!-- 		<input name="sex" type="text" id="groupname" reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="邮箱地址，如wangking717@qq.com" /><i style="color:#F60; "> 请输入已存在的上级菜单ID</i> -->
				<select name="sex" id="sex"   style=" width:152px;">
       
           			 <option value="男">男</option>
            
           			 <option value="女">女</option> 
             
       			 </select> 
		</td>

	</tr>
	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		姓名 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		<input name="name" type="text" id="name" reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="邮箱地址，如wangking717@qq.com" /><i style="color:#F60; "> 尽量别同名</i>

		</td>
	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		身份 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		<input name="IDcard" type="text" id="IDcard" reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="邮箱地址，如wangking717@qq.com" /><i style="color:#F60; "> 请输入身份信息</i>

		</td>

	</tr>
	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		电话 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		<input name="phone" type="text" id="phone" reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="邮箱地址，如wangking717@qq.com" /><i style="color:#F60; "> 请输入正确的电话号码</i>

		</td>

	</tr>
	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		地址 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		<input name="address" type="text" id="address" reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="邮箱地址，如wangking717@qq.com" /><i style="color:#F60; "> 请输入联系地址</i>

		</td>

	</tr>
	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">


	
		状态: 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

<!-- 		<input name="state" type="text" id="groupname" reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="邮箱地址，如wangking717@qq.com" /><i style="color:#F60; "> 请输入已存在的上级菜单ID</i> -->
			 
      		  	<select name="state" id="state"   style=" width:152px;">
       
           			 <option value="启用">启用</option>
            
           			 <option value="禁用">禁用</option> 
             
       			 </select> 
		</td>

	</tr>
	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		科室 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">
 
 				<select name="param_id" id="param_id" value="${u.param_id}"    style=" width:153px;"> 
      			 <c:forEach items="${parameterlist}" var="u" varStatus="s">
      			 <c:if test="${u.name!='科室'}">
          	 	 <option value="${u.param_id}">${u.name}</option> 
          	 	 </c:if>
         	   </c:forEach> 
      		  </select>
		<i style="color:#F60; "> *</i>
 
 
 
		</td>

	</tr>
	
	<tr bgcolor="#ffffff">

		<td align="right" bgcolor="#EEEEEE" width="150px" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		邮箱 : 

		</td>

		<td align="left" style="padding-left: 5px; padding-top: 4px; padding-bottom: 4px; padding-right: 18px;">

		<input name="mail" type="text" id="mail" reg="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="邮箱地址，如wangking717@qq.com" /><i style="color:#F60; "> 请输入正确的邮箱信息</i>

		</td>

	</tr>
 

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