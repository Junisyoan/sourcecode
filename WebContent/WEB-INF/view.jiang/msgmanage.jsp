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
<title>留言板</title>
  
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
   <div class="title_name">留言板</div>
    <button type="button" class="<%=path%>btn btn-primary" id="add_butn">批量删除</button>
      <div class="Add_Manager_style">
    		   
    <div id="Add_Product_style" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
    
  		 <form action="<%=path%>contact/deletemsg.handle"  method="post" id = "aFrom"  > 
    		序号开始    <input type="text" name="begin" id="begin"/>&nbsp <i style="color:#F60; ">开始序号必须存在</i>    </br></br>
    		结束序号    <input type="text" name="end"    id="end"/>&nbsp<i style="color:#F60; ">结束序号必须存在</i> 
     	    
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
<th>联系人</th>
<th>邮箱</th>
<th>电话</th>
 <th>留言信息</th>
 <th>信息读取记录</th> 
</tr>
</thead>
<tbody id="companyBody"> 
 <c:forEach items="${msglist}" var="u" varStatus="s">
 <c:if test="${u.state eq '未读'}"> 
 <tr>
 <td>  ${u.msg_id} </td>
 <td>  ${u.name} </td>
 <td>  ${u.email} </td>
 <td>  ${u.phone} </td>
 <td>  ${u.msg} </td>
 <td>  ${u.state} </td> 
 </tr>
 </c:if>
 </c:forEach>
 
</tbody>
<tbody id="companyBody"> 
  <c:forEach items="${msglist}" var="u" varStatus="s">
 <c:if test="${u.state eq '已读'}"> 
 <tr>
 <td>  ${u.msg_id} </td>
 <td>  ${u.name} </td>
 <td>  ${u.email} </td>
 <td>  ${u.phone} </td>
 <td>  ${u.msg} </td>
 <td>  ${u.state} </td> 
 </tr>
 </c:if>
 </c:forEach>
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
        title: '批量删除',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Add_Product_style'),
		btn:['提交','取消'],
		yes: function(index, layero){		
		 
// 		 ------------------------------------------
			 if($("#begin").val()==""){
				  layer.alert('删除开始序号不能为空',{
	             title: '提示框',								
				  icon:0,			    
				 });
				return false;
	              } 
// 			 ------------------------------------------
			 if($("#end").val()==""){
				  layer.alert('删除结束序号不能为空',{
	             title: '提示框',								
				  icon:0,			    
				 });
				return false;
	              } 
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
