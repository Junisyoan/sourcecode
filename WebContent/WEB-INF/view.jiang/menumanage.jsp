<%@ page language="java" import="java.util.*"
	contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
	  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" /> 
  <link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
  <link rel="stylesheet" href="<%=path %>css/style.css"/>
<title>无标题文档</title>
  
<link href="<%=path %>js2/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=path %>js2/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css">

<script src="<%=path %>js2/jquery-1.8.3.min.js"></script>
<script src="<%=path %>js2/datatables.bootstrap.min.js"></script>
<script src="<%=path %>js2/jquery.dataTables.min.js"></script>

</head>

<body>
<div class="page-content">
<div class="gys_style">
<div class="Manager_style">
   <div class="title_name">添加菜单</div>
    <button type="button" class="<%=path%>btn btn-primary" id="add_butn">添加菜单</button>
     <div class="Add_Manager_style">
    		  
    <div id="Add_Product_style" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
    
    	<form action="<%=path%>menumanage/addmenuid.handle" method="post" id="add">
  		   <ul class="clearfix">
     
      
<!--       <li><label class="label_name">菜单序号</label><input name="menu_id" type="text"  class="text_add" id="menu_id"  /><i style="color:#F60; ">*</i></li> -->
      <li><label class="label_name">菜单名</label><input name="name" type="text"  class="text_add" id="name" onblur="loadAjax()"/></li>
      <li><label class="label_name">路径</label><input name="link" type="text"  class="text_add" id="link"/></li>
     
         
      </ul>  
      </form> 
       </div>       
      </div>
      </div>
    </div>
    </div>
    </div>
    </div>
<table id="test" class="table table-striped table-bordered" style="60%">   
<thead>
 
<tr>
<th>菜单序号</th>
<th>菜单名</th>
<th>路径</th>
 <th>操作</th>
</tr>
</thead>
<tbody>
<c:forEach items="${tbmenuall}" var="u" varStatus="s">
<tr>
<td>${u.menu_id}</td>
<td>${u.name}</td>
<td>${u.link}</td>

<td><input type="checkbox" value="5" /></td>
</tr>
    </c:forEach> 
 
</tbody>

</table>
</body>

		<script src="<%=path %>assets/js/jquery.min.js"></script>
 

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

	 
<script src="<%=path %>assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$('#test').DataTable();
});


$('#add_butn').on('click', function(){
 
    layer.open({
        type: 1,
        title: '添加菜單',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Add_Product_style'),
		btn:['提交','取消'],
		yes: function(index, layero){		
		 
// 		 ------------------------------------------
			 if($("#name").val()==""){
				  layer.alert('菜单名不能为空!',{
	             title: '提示框',								
				  icon:0,			    
				 });
				return false;
	              } 
// 			 ------------------------------------------
			 if($("#link").val()==""){
				  layer.alert('地址不能为空!',{
	            title: '提示框',								
				  icon:0,			    
				 });
				return false;
	             }
// 			 
		        else{
		        	var aaa = document.getElementById("add");
		        	aaa.submit();
	 
				  layer.close(index);      
			  } 
			}
	    })
	});
function loadAjax(){
	var name = $("#name").val();
	 
		$.ajax({
			 type:"POST",
			 url:"<%=path%>menumanage/addmenuid.handle",
//				 contentType:"application/text;charset=utf-8",
			 data:{
				 "name":name
			 },
			 dataType:"text",
			 error:function(){
				 alert('ajax请求请求错误...');
			 },
			 success:function(data){
				 alert("ajax="+data); 
				 if(data=="01"){
					 alert("菜单名可以用");
				 }else{
					 alert("菜单名已存在...");
				 }
				
				
// 				 var datato=data.val();
				
<%-- 				 window.location.href="<%=path%>usermanage/adddeptto.action"; --%>
			 }
		
		});
 
	
}
</script>
</html>
