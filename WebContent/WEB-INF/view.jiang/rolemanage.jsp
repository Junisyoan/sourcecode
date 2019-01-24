<%@ page language="java" contentType="text/html; charset=utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String path=request.getScheme()+"://"+request.getServerName()+":"
	+request.getServerPort()+request.getContextPath()+"/";	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" />
  <!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
  <link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
  <link rel="stylesheet" href="<%=path %>css/style.css"/>
<title>角色管理</title>
<script type="text/javascript"></script>
<script src="<%=path %>js/jquery.min.js"></script>
<script src="<%=path %>js/jquery.validate.min.js"></script>
<script src="<%=path %>js/jquery.validate.cn.js"></script>
</head>

<body>
<div class="page-content">
<div class="gys_style">
 <div class="Manager_style">
    <div class="title_name">添加角色</div>
    <button type="button" class="btn btn-primary" id="Add_Product_btn">添加角色</button>
    <div class="Add_Manager_style">
    <div id="Add_Product_style" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
     <form action="<%=path%>rolemanage/addrole.handle" method="post" id="ddd" >
     <ul class="clearfix">
      <li><label class="label_name">新角色</label> <input name="name" type="text"  class="text_add" id="name"/><i style="color:#F60; ">*</i></li>
      </ul>    
   		 </form>
     </div>       
      </div>
      </div>
    </div>
    </div>
    <div class="Manager_style">
     <span class="title_name">产品信息</span>
     <table class="table table-striped table-bordered table-hover">
      <thead>
       <tr>
        <th>序号</th>
        <th>角色</th>
        <th>操作</th>
        
       </tr>
      </thead>
      <tbody>
       <c:forEach items="${roleall}" var="u" varStatus="s">
       <tr>
        <td>${u.role_id}</td><td>${u.name}</td> 
        <td><button type="button" class="btn btn-info Product_Details">详情</button><button type="button" class="btn btn-primary">修改</button> <button type="button" class="btn btn-warning">删除</button></td>
       </tr>
       </c:forEach> 
      </tbody>
     </table>
  
  </div> 
 </div>    
</div>

<!--添加属性样式-->
<div class="Attributes_style" id="add_Attributes_style" style="display:none">
 <input name="" type="text"  class="Attributestext" id="shuxin"/><!--<button type="button" class="btn btn-primary">添加</button>-->
</div>

		<script src="<%=path %>assets/js/jquery.min.js"></script>
		

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

	
<script src="<%=path %>assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">

$('#Add_Product_btn').on('click', function(){
    layer.open({
        type: 1,
        title: '添加角色',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Add_Product_style'),
		btn:['提交','取消'],
		yes: function(index, layero){		
		 if($("#name").val()==""){
			  layer.alert('新角色名称不能为空!',{
              title: '提示框',								
			  icon:0,			    
			 });
			return false;
               } 
	        else{	
				var aaa = document.getElementById("ddd");
		        	aaa.submit();		  
			   	
			     
		  } 
		}
    })
});
</script>
</body>
</html>

 
</html>