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
<title>权限管理</title>
  
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
   <div class="title_name">添加人员</div>
    <button type="button" class="<%=path%>btn btn-primary" id="add_butn">添加人员</button>
      <div class="Add_Manager_style">
    		 <form method="post" id = "aFrom" method="post">
     		部门	<input type="text" name="dept"/>
     		账号	<input type="text" name="account"/> 
     		性别	<input type="text" name="sex"/>
     		联系电话		<input type="text" name="phone"/><br/>
     		身份证	<input type="text" name="IDcard"/>
     		地址	<input type="text" name="address"/> 
     		<li> <label class="label_name">状态</label>
        <select name="state" id="state"   style=" width:170px;">
       
            <option value="启用">启用</option>
            
            <option value="禁用">禁用</option> 
             
        </select></li>
     		 
  			<input type="button" class="<%=path%>btn btn-primary" value="查询" onclick="putIn()">
  	 	</form>  
    		  
    		  
    <div id="Add_Product_style" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
    
    	<form action="<%=path%>usermanage/adduser.handle" method="post" id="ddd">
  		   <ul class="clearfix">
     
     	<li> <label class="label_name">部门</label> 
        <select name="dept" id="dept" value="${u.name}"  onblur="loadAjax()" style=" width:170px;"> 
       <c:forEach items="${maplistdept}" var="u" varStatus="s">
            <option value="${u.name}">${u.name}</option> 
            </c:forEach> 
        </select></li> 
        
        <li>   <label  class="label_name"> 联系人</label><input type="text" id="name" name="name"/>   </li> 
<!--         <li>   <label  class="label_name">   角色1</label><input type="text" id="doctor" name="doctor"/>   </li>  -->
     <li> <label class="label_name">角色</label>  
         <select name="doctor" id="doctor"  style=" width:170px;"> 
        
       </select></li>


            
      <li><label class="label_name">账号</label><input name="account" type="text"  class="text_add" id="account"/><i style="color:#F60; ">*</i></li>
      <li><label class="label_name">密码</label><input name="pwd" type="password"  class="text_add" id="pwd"/></li>
      <li><label class="label_name">性别</label><input name="sex" type="text"  class="text_add" id="sex"/></li>
      <li><label class="label_name">联系人身份</label><input name="IDcard" type="text"  class="text_add" id="IDcard"/></li>
      <li><label class="label_name">联系电话</label><input name="phone" type="text"  class="text_add" id="phone"/></li>
      <li><label class="label_name">联系地址</label><input name="address" type="text"  class="text_add" id="address"/></li>
       <li> <label class="label_name">状态</label>
        <select name="state"  style=" width:170px;">
            <option value="启用">启用</option> 
            <option value="禁用" >禁用</option>
        </select></li>
         
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
        <th>序号</th>
        <th>联系人</th>
        <th>账号</th>
        <th>部门</th>
        <th>性别</th>
        <th>联系电话</th>
        <th>身份证</th>
        <th>地址</th>
        <th>状态</th>
        <th>操作</th>
       </tr>
</thead>
<tbody id="companyBody">
<c:forEach items="${maplist}" var="u" varStatus="s">
       <tr>
        <td>${u.user_id}</td> <td>${u.name}</td> <td>${u.account}</td>  <td> ${u.deptname} </td><td>${u.sex}</td> <td>${u.phone}</td> 
         <td>${u.IDcard}</td>  <td>${u.address}</td> <td>${u.state}</td> 
          <td><button type="button" class="btn btn-info Product_Details" name="${u.user_id}">详细</button>
          <button type="button" class="btn btn-primary" onclick="updete()" name="${u.user_id}">修改</button> 
          <button type="button" class="btn btn-primary" onclick="updetestate('${u.state}','${u.user_id}')" name="${u.state}&${u.user_id}"  id="state">状态切换</button>
           <button type="button" class="btn btn-warning" onclick="delect()" name="${u.user_id}">删除</button></td> 
           
   
         </tr>
 	
        </c:forEach> 
 
</tbody>

</table>
</body>
   
<script src="<%=path %>assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$('#test').DataTable();
});

function putIn(){
	$.ajax({
		url:"<%=path%>usermanage/selectCompany.handle",
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
		
		var td1=$("<td></td>").text(companys[i].user_id);
		var td2=$("<td></td>").text(companys[i].name);
		var td3=$("<td></td>").text(companys[i].account);
		var td4=$("<td></td>").text(companys[i].deptname);
		var td5=$("<td></td>").text(companys[i].sex);
		var td6=$("<td></td>").text(companys[i].phone);
		var td7=$("<td></td>").text(companys[i].IDcard);
		var td8=$("<td></td>").text(companys[i].address);
		var td9=$("<td></td>").text(companys[i].state);
		var td10=$("<td></td>");
		
		var input1=$("<button type='button' class='btn btn-warning' onclick='updetestate('"+companys[i].state+"','"+companys[i].user_id+"')' name='"+companys[i].state+"&"+companys[i].user_id+"'>切换状态</button>");
  	
		var input2=$("<button type='button' class='btn btn-warning' onclick='delect()' name='"+companys[i].user_id+"'>删除</button>");
		var input3=$("<button type='button' class='btn btn-warning' onclick='updete()' name='"+companys[i].user_id+"'>修改</button>"); 
		var tr=$("<tr></tr>");
		
		$(td10).append(input1,input2,input3);  
		$(tr).append(td1,td2,td3,td4,td5,td6,td7,td8,td9,td10); 
		$("#companyBody").append(tr);
	}
}




// --------------
$('#add_butn').on('click', function(){
	 
    layer.open({
        type: 1,
        title: '添加/修改人员',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Add_Product_style'),
		btn:['提交','取消'],
		yes: function(index, layero){		
		 if($("#account").val()==""){
			 layer.alert('账号不能为空!',{
	              title: '提示框',								
				  icon:0,			    
				 });
				return false;
	               } 
// 		 ------------------------------------------
			 if($("#pwd").val()==""){
				  layer.alert('密码不能为空!',{
	             title: '提示框',								
				  icon:0,			    
				 });
				return false;
	              } 
// 			 ------------------------------------------
			 if($("#phone").val()==""|| $("#addcess").val()==""|| $("#sex").val()==""|| $("#IDcard").val()==""){
				  layer.alert('信息不能为空!',{
	            title: '提示框',								
				  icon:0,			    
				 });
				return false;
	             }
// 			 ---------------------------------------------------
			 var sex=document.getElementById("sex").value; 
			  if(sex!="男" && sex!="女"){
					
				  layer.alert('性别只能是男女!',{
	             title: '提示框',		
			  });
				  return false;
              } 
			  
// 			-------------------------------------------------------------
			 if($("#phone").val().length!=11 ){
				 var number=document.getElementById("phone").value; 
				
				 if(parseInt(number)!=number){
					
				  layer.alert('电话号码只能是为11位数字!',{
	             title: '提示框',								
				  icon:0,			    
				 });
				return false;
	              } 
				}
		        else{
		        	var aaa = document.getElementById("ddd");
		        	aaa.submit();
	 
				  layer.close(index);      
			  } 
			}
	    })
	});


//删除
function delect(e){ 
	var e=e||event;
	var t =e.target || e.srcElement;
	var delectname=t.name;
	var re=confirm("确定删除此项？");
	
	if(re){ 
	 $.ajax({
		 type:"POST",
		 url:"<%=path%>usermanage/delect.handle", 
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
			 location.href="<%=path%>usermanage/select.handle";
			 
		 }
			
		 },
	 });
	
	}else{
		alert("错误");
	}
}

//修改updete
function updete(a){
	var a=a||event;
	var t =a.target || a.srcElement;
	var updetename=t.name;
	var re=confirm("确定修改此项？");
	if(re){ 
		var form = document.createElement("Form");
		form.action="<%=path%>usermanage/updete2.handle";
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
function loadAjax(){
	var dept = $("#dept").val();
	 
		$.ajax({
			 type:"POST",
			 url:"<%=path%>usermanage/adddept.handle", 
			 data:{
				 "dept":dept
			 },
			 dataType:"json",
			 error:function(){
				 alert('ajax请求请求错误...');
			 },
			 success:function(data){ 
				 $("#doctor").empty();  /*先清空數據*/
// 			 	
				 for(var i = 0;i <data.length;i++){
					 
					 var dc=document.getElementById("doctor").value;
					 
					 dc = data[i].name; 
 						var op=$("<option></option>").text(dc);
					  
 						$("#doctor").append(op);
					}
				 
			 }
		
		});
 
	
}
//修改状态
function updetestate(s,id){
	var re=confirm("确定修改状态？"); 
	 
	if(re){ 
		 $.ajax({
			 url:"<%=path%>usermanage/updetestate.handle",
			 type:"post",
			 dataType:"text",
			 data:{'userid':id,'statet':s},
			 success:function(ret){
				 if(ret=="1"){
					 alert("修改成功");
				 }else{
					 alert("修改失敗");
				 }
				 location.href="<%=path%>usermanage/select.handle";
				 
			 },
			 error:function(){
				 alert('服務器無響應');
			 }
		 });
	 
	}
	else{
		alert("错误");
	}
  
}
 
</script>
</html>
