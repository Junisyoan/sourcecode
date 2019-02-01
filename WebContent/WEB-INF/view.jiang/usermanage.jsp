<%@ page language="java" import="java.util.*"
	contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
	  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" />
 
  <link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
  <link rel="stylesheet" href="<%=path %>css/style.css"/>
<title>人员设置</title>
</head>

<body>
<div class="page-content">
<div class="gys_style">
 <div class="Manager_style">
   <div class="title_name">添加人员</div>
    <button type="button" class="<%=path%>btn btn-primary" id="add_butn">添加人员</button>
     <div class="Add_Manager_style">
    		 <form action="<%=path%>usermanage/selectlittle.handle" method="post" id="select3">
     			部门	<input type="text" id="depts" name="depts"/> <i style="color:#F60; ">必填</i>	联系人	<input type="text" id="users" name="users"/><i style="color:#F60; ">必填</i> 
     				联系电话	<input type="text" id="phones" name="phones"/><i style="color:#F60; ">必填</i>
  				<input type="submit" value="查询" />
  			 </form>
    <div id="Add_Product_style" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
    
    	<form action="<%=path%>usermanage/adduser.handle" method="post" id="ddd">
  		   <ul class="clearfix">
     
     	<li> <label class="label_name">部门</label>
        <select name="cardstatef" id="dept" onblur="loadAjax()" style=" width:170px;">
       
            <option value="外科">外科</option>
            
            <option value="内科">内科</option>
               
            <option value="管理员">管理员</option> 
             
        </select></li>
        
        <li>   <label  class="label_name">   角色</label><input type="text" id="doctor" name="doctor"/>
        
        
       </li> 
            
      <li><label class="label_name">账号</label><input name="account" type="text"  class="text_add" id="account"/><i style="color:#F60; ">*</i></li>
      <li><label class="label_name">密码</label><input name="pwd" type="password"  class="text_add" id="pwd"/></li>
      <li><label class="label_name">性别</label><input name="sex" type="text"  class="text_add" id="sex"/></li>
      <li><label class="label_name">联系人身份</label><input name="IDcard" type="text"  class="text_add" id="IDcard"/></li>
      <li><label class="label_name">联系电话</label><input name="phone" type="text"  class="text_add" id="phone"/></li>
      <li><label class="label_name">联系地址</label><input name="address" type="text"  class="text_add" id="address"/></li>
       <li> <label class="label_name">状态</label>
        <select name="state"  style=" width:170px;">
            <option value="禁用" >禁用</option>
            <option value="启用">启用</option> 
        </select></li>
         
      </ul>  
      </form> 
      <div class="Remark"><label class="label_name">备注</label><textarea name="" cols="" rows="" style=" width:436px; height:200px; padding:5px;"></textarea></div>
 <!--     <div class="btn_operating"><button  type="button" class="btn btn-primary" id="submit">保存</button><button  type="button" class="btn btn-warning">重置</button></div>-->
      </div>       
      </div>
      </div>
    </div>
    </div>
    <div class="Manager_style">
     <span class="title_name">人员信息</span>
     <table class="table table-striped table-bordered table-hover">
      <thead>
       <tr>
        <th>序号</th>
        <th>部门</th>
        <th>联系人</th>
        <th>性别</th>
        <th>联系电话</th>
        <th>身份证</th>
        <th>地址</th>
        <th>状态</th>
        <th>操作</th>
       </tr>
      </thead>
      <tbody>

	 <c:forEach items="${maplist}" var="u" varStatus="s">
       <tr>
        <td>${u.user_id}</td> <td>${u.name}</td> <td>${u.account}</td>  <td>${u.sex}</td> <td>${u.phone}</td> 
         <td>${u.IDcard}</td>  <td>${u.address}</td> <td>${u.state}</td> 
          <td><button type="button" class="btn btn-info Product_Details" name="${u.user_id}">详细</button>
          <button type="button" class="btn btn-primary" onclick="updete()" name="${u.user_id}">修改</button>
<%--           <button type="button" class="<%=path%>btn btn-primary2" id="updete" name="${u.user_id}">修改</button> --%>
          <button type="button" class="btn btn-primary" onclick="updetestate()" name="${u.state}&${u.user_id}"  id="state">状态切换</button>
           <button type="button" class="btn btn-warning" onclick="delect()" name="${u.user_id}">删除</button></td> 
           
   
         </tr>
 	
        </c:forEach> 
       
      </tbody>
     </table>
      <div class="page_style">
  <select name="" size="1">
    <option value="1">10</option>
    <option value="2">20</option>
    <option value="3">30</option>
  </select>
  <a href="" class="icon-step-backward page_btn" ></a>
  <a href="" class="icon-caret-left page_btn"></a>
  第
  <select name="" size="1">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
  </select>
  共2页
   <a href="" class=" icon-caret-right page_btn"></a>
  <a href="" class="icon-step-forward page_btn"></a>
   </div>
  </div> 
 </div>   
<!--  -++++--- -->
 
  <div class="Manager_style">
   <div class="title_name">修改人员</div>
    <button type="button" class="<%=path%>btn btn-primary2" id="updete">添加人员</button>
     <div class="Add_Manager_style">
    <div id="Add_Product_style" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
    
    	<form action="<%=path%>usermanage/updete.handle" method="post" id="bbb">
  		   <ul class="clearfix">
     
     	<li> <label class="label_name"   >部门</label>
        <select name="cardstatef" id="dept" onblur="loadAjax()" style=" width:170px;">
       
            <option value="外科">外科</option>
            
            <option value="内科">内科</option>
               
            <option value="管理员">管理员</option> 
             
        </select></li>
        
        <li>   <label  class="label_name">   角色</label><input type="text" id="doctor" name="doctor"/>
        
        
        </label></li>
     <li><label class="label_name">账号</label><input name="account" type="text"  class="text_add" id="account"/><i style="color:#F60; ">*</i></li>
      <li><label class="label_name">密码</label><input name="pwd" type="password"  class="text_add" id="pwd"/></li>
      <li><label class="label_name">性别</label><input name="sex" type="text"  class="text_add" id="sex"/></li>
      <li><label class="label_name">联系人身份</label><input name="IDcard" type="text"  class="text_add" id="IDcard"/></li>
      <li><label class="label_name">联系电话</label><input name="phone" type="text"  class="text_add" id="phone"/></li>
      <li><label class="label_name">联系地址</label><input name="address" type="text"  class="text_add" id="address"/></li>
       <li> <label class="label_name">状态</label>
        <select name="state"  style=" width:170px;">
            <option value="禁用" >禁用</option>
            <option value="启用">启用</option> 
        </select></li>
         
      </ul>  
      </form> 
      <div class="Remark"><label class="label_name">备注</label><textarea name="" cols="" rows="" style=" width:436px; height:200px; padding:5px;"></textarea></div>
 <!--     <div class="btn_operating"><button  type="button" class="btn btn-primary" id="submit">保存</button><button  type="button" class="btn btn-warning">重置</button></div>-->
      </div>       
      </div>
      </div>
    </div>
    </div>
 
<!--   -----++++ -->
</div>

<!--  ------------------- -->
    
     
<!-- ------------------    	  -->
<div class="" id="Product_Details" style="display:none">
 <div class="page-content">

  <div class="Product_Details Order_Details_style">
  <div class="Numbering"><b>修改人员信息</b></div> 
    <div>
   <ul class="clearfix"> 
  
  	 <li> <label class="label_name"   >部门</label>
        <select name="cardstatef" id="dept" onblur="loadAjax()" style=" width:170px;">
       
            <option value="外科">外科</option>
            
            <option value="内科">内科</option>
               
            <option value="管理员">管理员</option> 
             
        </select></li>
      <li><label class="label_name">账号</label><input name="account" type="text"  class="text_add" id="account"/><i style="color:#F60; ">*</i></li>
      <li><label class="label_name">密码</label><input name="pwd" type="password"  class="text_add" id="pwd"/></li>
      <li><label class="label_name">性别</label><input name="sex" type="text"  class="text_add" id="sex"/></li>
      <li><label class="label_name">联系人身份</label><input name="IDcard" type="text"  class="text_add" id="IDcard"/></li>
      <li><label class="label_name">联系电话</label><input name="phone" type="text"  class="text_add" id="phone"/></li>
      <li><label class="label_name">联系地址</label><input name="address" type="text"  class="text_add" id="address"/></li>
       <li> <label class="label_name">状态</label>
   
   </ul>
  </div>
  </div>
  <div> 
  <div class="add_Attributes"><button class="btn btn-primary Attribute_btn" type="button">添加属性</button></div>
   <table class="table table-striped table-bordered table-hover">
    <thead>
     <tr><th>序号</th><th>产品属性</th><th>操作</th></tr>
    </thead>
    <tbody>
     <tr>
      <td>1</td>
      <td>属性名称1</td>
      <td><button type="button" class="btn btn-primary">修改属性</button><button type="button" class="btn btn-warning">删除</button></td>
     </tr>
      <tr>
      <td>2</td>
      <td>属性名称2</td>
      <td><button type="button" class="btn btn-primary">修改属性</button><button type="button" class="btn btn-warning">删除</button></td>
     </tr>
      <tr>
      <td>3</td>
      <td>属性名称3</td>
      <td><button type="button" class="btn btn-primary">修改属性</button><button type="button" class="btn btn-warning">删除</button></td>
     </tr>
      <tr>
      <td>4</td>
      <td>属性名称4</td>
      <td><button type="button" class="btn btn-primary">修改属性</button><button type="button" class="btn btn-warning">删除</button></td>
     </tr>
    </tbody>
   </table>
  </div>
  <div class="add_Attributes"><button class="btn btn-primary Attribute_btn" type="button">添加属性</button></div>
</div></div>
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
$('.Product_Details').on('click', function(){
    layer.open({
        type: 1,
        title: '修改人员信息',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['720px' , '500px'],
        content: $('#Product_Details')
    });
}); 
$('.Attribute_btn').on('click', function(){
    layer.open({
        type: 1,
        title: '添加属性',
		shadeClose: true, //点击遮罩关闭层
        area : ['330px' , '180px'],
        content:$('#add_Attributes_style'),
		btn:['提交','取消'],
		yes: function(index, layero){	
		 if($("#shuxin").val()==""){
			  layer.alert('属性名称不能为空!',{
              title: '提示框',								
			  icon:0,			    
			 });
			return false;
               } 
	        else{			  
			  layer.alert('添加成功！',{
               title: '提示框',				
			   icon:0,		
			  }); 
			  layer.close(index);      
		  } 
		
		}
    });
});
// // ----修改人员
// $('#updete').on('click', function(){
	 
//     layer.open({
//         type: 1,
//         title: '修改人员',
// 		shadeClose: true, //点击遮罩关闭层
//         area: ['600px' , ''],
//         content: $('#Add_Product_style'),
// 		btn:['提交','取消'],
// 		yes: function(index, layero){		
// 		 if($("#account").val()==""){
// 			 layer.alert('账号不能为空!',{
// 	              title: '提示框',								
// 				  icon:0,			    
// 				 });
// 				return false;
// 	               } 
// 		  else{
// 	        	var bbb = document.getElementById("bbb");
// 	        	aler("修改數據");
// 	        	bbb.submit();

// 			  layer.close(index);      
// 		  } 
// 		}
//   })
// });



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
// 		var delectname=	document.getElementById("name").value;
		var e=e||event;
		var t =e.target || e.srcElement;
		var delectname=t.name;
		var re=confirm("确定删除此项？");
		
		if(re){
		alert(delectname);
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
// 			alert(updetename);
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
// 				 contentType:"application/text;charset=utf-8",
				 data:{
					 "dept":dept
				 },
				 dataType:"text",
				 error:function(){
					 alert('ajax请求请求错误...');
				 },
				 success:function(data){
					 alert("ajax="+data); 
					 if(data=="01"){
						 $("#doctor").val("内科医生");
					 }else if(data=="02"){
						 $("#doctor").val("外科医生");
					 }else{
						 $("#doctor").val("管理员");
					 }
					
					
					 var datato=data.val();
					
					 window.location.href="<%=path%>usermanage/adddeptto.action";
				 }
			
			});
	 
		
	}
	//修改状态
	function updetestate(b){
		var b=b||event;
		var t =b.target || b.srcElement;
		var stateandid=t.name;
// 		 alert(stateandid);
		    var sArr=stateandid.split("&")
		    var state=sArr[0];
		    var userid=sArr[1];
		  
		
		 
		var re=confirm("确定修改状态？");
		if(re){
// 			alert(state);
			var form = document.createElement("Form");
			form.action="<%=path%>usermanage/updetestate.handle";
			form.method="post";
			form.style.display="none";
			
			var opstate= document.createElement("input");
			opstate.name="statet";
			opstate.value=state;
			var opuserid= document.createElement("input");
			opuserid.name="userid";
			opuserid.value=userid;
			
			form.appendChild(opstate);
			form.appendChild(opuserid);
			document.body.appendChild(form);
			
			form.submit();
			 
		 
		}
		else{
			alert("错误");
		}
	  
	}
</script>
</body>
</html>
