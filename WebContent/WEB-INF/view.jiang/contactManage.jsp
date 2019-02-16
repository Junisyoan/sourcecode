<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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
<title>公司信息管理</title>
  
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
   <div class="title_name">公司信息管理</div>
    <button type="button" class="<%=path%>btn btn-primary" id="add_butn">修改公司信息</button>
      <div class="Add_Manager_style">
    		   
    <div id="Add_Product_style" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
    
   <form action="<%=path%>contact/upcontact.handle"  method="post" id = "aFrom"  > 
    		序号    <input type="text" name="name" value="${tb_contact.contact_id}"/>&nbsp
     		公司名&nbsp&nbsp	&nbsp<input type="text" name="power_id" value="${tb_contact.name}"/>&nbsp </br>
     		地区	<input type="text" name="menu_id" value="${tb_contact.province}"/>&nbsp
     		详细地址    <input type="text" name="name" value="${tb_contact.area}"/>&nbsp</br>
     		固话    <input type="text" name="name" value="${tb_contact.tel}"/>&nbsp
     		手机 &nbsp&nbsp &nbsp&nbsp&nbsp  <input type="text" name="name" value="${tb_contact.phone}"/>&nbsp</br>
     		传真    <input type="text" name="name" value="${tb_contact.fax}"/>&nbsp
     		邮箱 &nbsp&nbsp &nbsp &nbsp&nbsp <input type="text" name="name" value="${tb_contact.email}"/>&nbsp</br>
     		  
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

<th>序号</th>
<th>公司名</th>
<th>所在地区</th>
<th>具体地址</th>
 <th>固话</th>
 <th>手机</th>
 <th>传真</th>
 <th>邮箱</th>
</tr>
</thead>
<tbody id="companyBody"> 
<tr>
<td>${tb_contact.contact_id}</td>
<td>${tb_contact.name}</td>
<td>${tb_contact.province}</td>
<td>${tb_contact.area}</td>
<td>${tb_contact.tel}</td>
<td>${tb_contact.phone}</td>
<td>${tb_contact.fax}</td>
<td>${tb_contact.email}</td>
 
</tr>
    
 
</tbody>

</table>
</body>
 
<script src="<%=path %>assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$('#test').DataTable();
});
 

$('#add_butn').on('click', function(){
 
    layer.open({
        type: 1,
        title: '修改公司信息',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Add_Product_style'),
		btn:['提交','取消'],
		yes: function(index, layero){		
		 
// 		 ------------------------------------------
			 if($("#contact_id").val()==""){
				  layer.alert('id不能为空',{
	             title: '提示框',								
				  icon:0,			    
				 });
				return false;
	              } 
// 			 ------------------------------------------
		 
// 			 
		        else{
		        	var aaa = document.getElementById("aFrom");
		        	aaa.submit();
	 
				  layer.close(index);      
			  } 
			}
	    })
	});
  
</script>
</html>
