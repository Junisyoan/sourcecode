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
 
<form action="<%=path%>menumanage/updetemenu2.handle" method="post" id="ccc">
<ul class="clearfix">
     <li> <label class="label_name"   >序号</label>  <input name="menu_id" type="text"  readonly="readonly" class="text_add" id="menu_id" value="${updetename}"/></li>
     	<li> <label class="label_name"   >菜单名</label><input name="name" type="text"  class="text_add" id="name"/><i style="color:#F60; ">只能修改成未拥有的菜单名</i></li>
     	  <li><label class="label_name">路径</label><input name="link" type="text"  class="text_add" id="link"/><i style="color:#F60; ">*</i></li>
      	
     	</ul>
<input type="submit" value="提交">

</form>
</body>
 
</html>