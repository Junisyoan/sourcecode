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
    		  
    		  	  
    		<form method="post" id = "aFrom" method="post">
     		<i style="color:#F60; ">必填</i>菜单id	<input type="text" name="menu_id"/>
     		菜单名	<input type="text" name="name"/>
     		菜单路径<input type="text" name="link"/>
     		<i style="color:#F60; ">必填</i>上级菜单<input type="text" name="superior"/>
     		  
  			<input type="button" class="<%=path%>btn btn-primary" value="查询" onclick="putIn()">
  	 	</form>  
    		  
    		  
    		  
    <div id="Add_Product_style" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
    
    	<form action="<%=path%>menumanage/addmenu.handle" method="post" id="add">
  		   <ul class="clearfix">
     
      
      <li><label class="label_name">菜单序号</label><input name="menu_id" type="text"  class="text_add" id="menu_id"  /><i style="color:#F60; ">*</i></li>
      <li><label class="label_name">菜单名</label><input name="name" type="text"  class="text_add" id="name" onblur="loadAjax()"/></li>
      <li><label class="label_name">路径</label><input name="link" type="text"  class="text_add" id="link"/></li>
      <li><label class="label_name">上级菜单</label><input name="superior" type="text"  class="text_add" id="superior"/></li>
     
         
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
<th>上级菜单</th>
 <th>操作</th>
</tr>
</thead>
<tbody id="companyBody">
<c:forEach items="${tbmenuall}" var="u" varStatus="s">
<tr>
<td>${u.menu_id}</td>
<td>${u.name}</td>
<td>${u.link}</td>
<td>${u.superior}</td>
<td>  <button type="button" class="btn btn-primary" onclick="updete()" name="${u.menu_id}">修改</button>
  <button type="button" class="btn btn-primary" onclick="delect()" name="${u.menu_id}">刪除</button></td>
<!-- <td><input type="checkbox" value="5" /></td> -->
</tr>
    </c:forEach> 
 
</tbody>

</table>
</body>

<%-- 		<script src="<%=path %>assets/js/jquery.min.js"></script> --%>
 

<!-- 		<script type="text/javascript"> -->
<!-- //   			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>"); -->
<!--  	</script>   -->

	 
<script src="<%=path %>assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$('#test').DataTable();
});

function putIn(){
	$.ajax({
		url:"<%=path%>menumanage/selectCompany.handle",
		type:"POST",
		dataType:"JSON",
		data:$("#aFrom").serialize(),
		success:function(companys){
			show(companys);
		},
		error:function(){
			alert("异常");
		}
	});
}

function show(companys){
	 
	$("#companyBody").empty();  
	
	for(var i = 0;i < companys.length;i++){
		
		var td1=$("<td></td>").text(companys[i].menu_id); 
		var td2=$("<td></td>").text(companys[i].name); 
		var td3=$("<td></td>").text(companys[i].link); 
		var td4=$("<td></td>").text(companys[i].superior); 
		var td5=$("<td></td>");
		
		var input1=$("<button type='button' class='btn btn-warning' onclick='updete()' name='"+companys[i].menu_id+"'>修改</button>"); 
	 	var input2=$("<button type='button' class='btn btn-warning' onclick='delect()' name='"+companys[i].menu_id+"'>删除</button>");
		var tr=$("<tr></tr>");
		
		$(td5).append(input1,input2);  
		$(tr).append(td1,td2,td3,td4,td5); 
		$("#companyBody").append(tr);
	}
}

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
				
<%-- 				 window.location.href="<%=path%>menumanage/adddeptto.action"; --%>
			 }
		
		});
 
	
}

function delect(e){ 
	var e=e||event;
	var t =e.target || e.srcElement;
	var delectname=t.name;
	var re=confirm("确定删除此项？");
	
	if(re){
	alert(delectname);
	 $.ajax({
		 type:"POST",
		 url:"<%=path%>menumanage/delect.handle", 
		 data:{
			 "delectname":delectname
			 },
		 dataType:"text",
		 error:function(){
			 alert('ajax请求请求错误...啦');
		 },
		 success:function(data){
		 if(data=="00"){
			 alert("删除成功"); 
<%-- 			 location.href="<%=path%>menumanage/select.handle"; --%>
		 }
			
		 },
	 });
	
	}else{
		alert("错误");
	}
}

//修改updete第一步
function updete(a){
	var a=a||event;
	var t =a.target || a.srcElement;
	var updetename=t.name;
	var re=confirm("确定修改此项？");
	if(re){
//			alert(updetename);
		var form = document.createElement("Form");
		form.action="<%=path%>menumanage/updete1.handle";
		form.method="post";
		form.style.display="none";
		
		var opupdetename= document.createElement("input");
		opupdetename.name="updetename";
		opupdetename.value=updetename;
	  
		form.appendChild(opupdetename); 
		document.body.appendChild(form);
		
		form.submit();
		
		 
		}else{
			alert("错误");
		}
	  
}

</script>
</html>
