<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*"
	contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
	  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" /> 
  <link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
  <link rel="stylesheet" href="<%=path %>css/style.css"/>
<title>角色管理</title>
  
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
      <div class="title_name">添加角色</div>
    <button type="button" class="btn btn-primary" id="Add_Product_btn">添加角色</button>
    <div class="Add_Manager_style">
    
    	<form method="post" id = "aFrom" method="post">
     		角色名	<input type="text" name="name"/>
     		  
  			<input type="button" class="<%=path%>btn btn-primary" value="查询" onclick="putIn()">
  	 	</form>  
    
    <div id="Add_Product_style" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
     <form action="<%=path%>rolemanage/addrole.handle" method="post" id="ddd" >
     <ul class="clearfix">
<!--       <li><label class="label_name">新角色ID</label> <input name="role_id" type="text"  class="text_add" id="role_id"/><i style="color:#F60; ">*</i></li> -->
      <li><label class="label_name">新角色</label> <input name="name" type="text"  class="text_add" id="name"/><i style="color:#F60; ">*</i></li>
<!--       <li><label class="label_name">归属ID</label> <input name="dept_id" type="text"  class="text_add" id="dept_id"/><i style="color:#F60; ">*部门ID</i></li> -->
      </ul>    
   		 </form>
     </div>       
      </div>
      </div>
      
      
    </div>
    </div>
    </div>
    </div>
    <div class="page-content">
<div class="gys_style">
<div class="Manager_style">
<table id="test" class="table table-striped table-bordered" style="60%">   
<thead>
 
 
      <tr>
        <th>序号</th>
        <th>角色</th>
        <th>操作</th>
        
       </tr>
</thead>
<tbody id="companyBody">
<c:forEach items="${roleall}" var="u" varStatus="s">
       <tr>
        <td>${u.role_id}</td>
        <td>${u.name}</td> 
        <td> 
   
     	 <button type="button" class="btn btn-primary" onclick="updect()"  name="${u.role_id}">修改</button>
         <button type="button" class="btn btn-warning" onclick="delectrole()" name="${u.role_id}">删除</button>
         </td>
       </tr>
       </c:forEach> 
 
</tbody>

</table>
</div>
</div>
</div>
<div class="Add_Manager_style">
    <div id="Add_Product_styleed" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
     <form action="<%=path%>rolemanage/updectrole.handle" method="post" id="ccc" >
     <ul class="clearfix">
       <li><label class="label_name">序号</label> <input name="nameed" type="text" value="${u.role_id}"  readonly="readonly" class="text_add" id="nameed"   /><i style="color:#F60; ">*</i></li>  
       <li><label class="label_name">新角色名称</label> <input name="newname" type="text"  class="text_add" id="newname"/><i style="color:#F60; ">*</i></li>  
      </ul>    
   		 </form>
     </div>       
      </div>
      </div>
    </div> 
</body>
   
<script src="<%=path %>assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$('#test').DataTable();
});


function putIn(){
	$.ajax({
		url:"<%=path%>rolemanage/selectCompany.handle",
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
		
		var td1=$("<td></td>").text(companys[i].role_id); 
		var td2=$("<td></td>").text(companys[i].name); 
		var td3=$("<td></td>");
		
		var input1=$("<button type='button' class='btn btn-warning' onclick='updect()' name='"+companys[i].role_id+"'>修改</button>"); 
	 	var input2=$("<button type='button' class='btn btn-warning' onclick='delectrole()' name='"+companys[i].role_id+"'>删除</button>");
		var tr=$("<tr></tr>");
		
		$(td3).append(input1,input2);  
		$(tr).append(td1,td2,td3); 
		$("#companyBody").append(tr);
	}
}

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
//修改角色
function updect(a){
	var a=a||event;
	var t =a.target || a.srcElement;
	var id=t.name;
	
	 document.getElementById("nameed").value=id;
	
	
    layer.open({ 
        type: 1,
        title: '修改角色',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Add_Product_styleed'),
		btn:['提交','取消'],
		yes: function(index, layero){		
		 if($("#newname").val()==""){ 
			  layer.alert('修改角色名称不能为空!',{
              title: '提示框',								
			  icon:0,			    
			 });
			return false;
               } 
	        else{
	        	 
				var aaa = document.getElementById("ccc");
		        	aaa.submit();		  
			   	
			     
		  } 
		}
    })
}
function delectrole(a){
	var a=a||event;
	var t =a.target || a.srcElement;
	var updetename=t.name;
	var re=confirm("确定刪除？   刪除前请确保此角色与部门无关联");
	if(re){ 
		var form = document.createElement("Form");
		form.action="<%=path%>rolemanage/delectrole.handle";
		form.method="post";
		form.style.display="none";
		
		var opupdetename= document.createElement("input");
		opupdetename.name="updetename";
		opupdetename.value=updetename;
	  
		form.appendChild(opupdetename); 
		document.body.appendChild(form);
		
		form.submit(); 
<%-- 		 location.href="<%=path%>rolemanage/select.handle"; --%>
		}else{
			alert("错误");
		}
	  
}

function updeterole(a){
	var a=a||event;
	var t =a.target || a.srcElement;
	var updetename=t.name;
	var re=confirm("确定修改？");
	if(re){ 
		var form = document.createElement("Form");
		form.action="<%=path%>rolemanage/updectrole.handle";
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
