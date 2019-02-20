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
</head>




<body>
<center>
 <i style="color:#F60; ">***必须按要求填写***</i></center>
<form action="<%=path%>usermanage/updeteuser.handle" method="post" id="ccc">
<ul class="clearfix">
     <li> <label class="label_name"   >序号</label>  <input name="user_id" type="text"  readonly="readonly" class="text_add" id="user_id" value="${updetename}"/></li>
     	<li> <label class="label_name"   >部门角色id</label><input name="role_dept_id" type="text"  class="text_add" id="role_dept_id"/><i style="color:#F60; ">只能修改已拥有的部门角色id</i></li>
     	  <li><label class="label_name">账号</label><input name="account" type="text"  class="text_add" id="account"/><i style="color:#F60; ">*</i></li>
      <li><label class="label_name">密码</label><input name="pwd" type="password"  class="text_add" id="pwd"/><i style="color:#F60; ">*</i></li>
      <li><label class="label_name">参数ID</label><input name="param_id" type="text"  class="text_add" id="param_id"/><i style="color:#F60; ">角色是医生时需加(2常规检查室,3彩超室,4检验室)</i></li>
      <li><label class="label_name">性别</label><input name="sex" type="text"  class="text_add" id="sex"/><i style="color:#F60; ">只能男.女</i></li>
      <li><label class="label_name">联系人身份</label><input name="IDcard" type="text"  class="text_add" id="IDcard"/><i style="color:#F60; ">*</i></li>
      <li><label class="label_name">联系电话</label><input name="phone" type="text"  class="text_add" id="phone"/><i style="color:#F60; ">11位数数字</i></li>
      <li><label class="label_name">联系地址</label><input name="address" type="text"  class="text_add" id="address"/><i style="color:#F60; ">*</i></li>
       <li> <label class="label_name">状态</label><input name="state" type="text"  class="text_add" id="state"/><i style="color:#F60; ">启用*禁用</i></li>
 
     	</ul>
<input type="submit" value="提交">

</form>
<button onclick="javascript:window.history.back();">返回</button>
</body>



 
</html>