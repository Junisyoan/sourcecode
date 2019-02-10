<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="<%=path%>js/jquery.min.js"></script>
  <script src="<%=path%>js/jquery.validate.min.js"></script>
  <script src="<%=path%>js/jquery.validate.cn.js"></script>  
  <script src="<%=path %>assets/js/jquery.min.js"></script>
  <script src="<%=path %>assets/layer/layer.js" type="text/javascript"></script>  
  <link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" />
  <link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
  <link rel="stylesheet" href="<%=path %>css/style.css"/>
  <link href="<%=path %>js2/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="<%=path %>js2/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css">
  <script src="<%=path %>js2/jquery-1.8.3.min.js"></script>
  <script src="<%=path %>js2/datatables.bootstrap.min.js"></script>
  <script src="<%=path %>js2/jquery.dataTables.min.js"></script>
    <title>添加细项</title>
   <style type="text/css">
	#aFrom input {
      margin-top:10px;
 	}
</style>
</head>
<body>
<div class="page-content">
<div class="gys_style">
 <div class="Manager_style">
   <div class="title_name">添加账号</div>
    <button type="button" class="<%=path%>btn btn-primary" id="add_butn">添加细项</button>
     <div class="Add_Manager_style">
     <form method="post" id = "aFrom" method="post">
     		公司名	<input type="text" name="name"/>
     		账户名	<input type="text" name="account"/>
     		电话号码	<input type="text" name="tel"/>
     		地址		<input type="text" name="address"/><br/>
     		领队人	<input type="text" name="people"/>
     		领队人电话	<input type="text" name="phone"/>
     		账户金额	<input type="text" name="min"/>
     		至		<input type="text" name="max"/>
  			<input type="button" class="<%=path%>btn btn-primary" value="查询" onclick="putIn()">
  	 </form>
     <div id="Add_Product_style" style="display:none">
     <div class="page-content">
     <div class="add_user_style clearfix">
    	<form  id = "addForm">
  			<ul class="clearfix">
     			<li>
     				<label class="label_name">公司名</label>
     				<input type = "text" name="name" id="name1" autofocus="autofocus" onblur="checkName1()">
     			</li>
        		<li>
     				<label class="label_name">账户名</label>
     				<input type = "text" name="account" id = "account1">
     			</li>
     			<li>
     				<label class="label_name">密码</label>
     				<input type = "text" name="pwd" id ="pwd1">
     			</li>
     			<li>
     				<label class="label_name">确认密码</label>
     				<input type = "text" name="confirmPwd" id="confirmPwd1">
     			</li>
     			<li>
     				<label class="label_name">公司电话</label>
     				<input type = "text" name="tel" id = "tel1">
     			</li>
     			<li>
     				<label class="label_name">公司地址</label>
     				<input type = "text" name="address" id ="address1">
     			</li>
     			<li>
     				<label class="label_name">领队人</label>
     				<input type = "text" name="people" id="people1">
     			</li>
     			<li>
     				<label class="label_name">领队人电话</label>
     				<input type = "text" name="phone" id = "phone1">
     			</li>
     			<li>
     				<label class="label_name">存储金额</label>
     				<input type = "text" name="deposit" id ="deposit1">
     			</li>
      		</ul>  
      	 </form> 
      </div>       
    </div>
  </div>
  <div id="Update_Product_style" style="display:none">
     <div class="page-content">
     <div class="add_user_style clearfix">
    	<form  id = "updateForm" onsubmit="return putIn()">
  			<ul class="clearfix">
     			<li>
     				<label class="label_name">公司名</label>
     				<input type = "text" name="name" id="name" autofocus="autofocus" onblur="checkName1()">
     			</li>
        		<li>
     				<label class="label_name">账户名</label>
     				<input type = "text" name="account" id = "account">
     			</li>
     			<li>
     				<label class="label_name">公司电话</label>
     				<input type = "text" name="tel" id = "tel">
     			</li>
     			<li>
     				<label class="label_name">公司地址</label>
     				<input type = "text" name="address" id ="address">
     			</li>
     			<li>
     				<label class="label_name">领队人</label>
     				<input type = "text" name="people" id="people">
     			</li>
     			<li>
     				<label class="label_name">领队人电话</label>
     				<input type = "text" name="phone" id = "phone">
     			</li>
     			<li>
     				<label class="label_name">存储金额</label>
     				<input type = "text" name="deposit" id ="deposit">
     			</li>
      		</ul>  
      		<input type = "hidden" id = "company_id" name = "company_id">
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
			<th>公司名</th>
			<th>账户名</th>
			<th>电话号码</th>
			<th>地址</th>
			<th>领队人</th>
			<th>领队人电话</th>
			<th>账户金额</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
      </thead>
      <tbody id = "companyBody">
      	<c:forEach items="${companys}" var = "c">
		<tr>
			<td>${c.name}</td>
			<td>${c.account}</td>
			<td>${c.tel}</td>
			<td>${c.address}</td>
			<td>${c.people}</td>
			<td>${c.phone}</td>
			<td>${c.deposit}</td>
			<td>${c.state}</td>
			<td>
				<c:choose>
					<c:when test="${c.state == '禁用'}">
						<button type="button" class="btn btn-warning" onclick="stateChange()" name="${c.company_id}">启用</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-warning" onclick="stateChange()" name="${c.company_id}">禁用</button>
					</c:otherwise>
				</c:choose>
				<button type="button" class="btn btn-warning" onclick="remove()" name="${c.company_id}">删除</button>
          		<button type="button" class="btn btn-primary" onclick="change()" name="${c.company_id}">修改</button>
				<button type="button" class="btn btn-warning" onclick="resetPwd()" name="${c.company_id}">重置密码</button>
			</td>
		</tr>
		</c:forEach>
	  </tbody>
    </table>
</body>
<script type="text/javascript">
	$(function(){
		$('#test').DataTable();
	});
</script>
<script type="text/javascript">
function stateChange(e){
	var e = e || event;
	var t = e.target || e.srcElement;
	var state = t.innerText;
	var company_id = t.name;
	
	if(state != "禁用"){
		state="在用";
	}
	
	$.ajax({
		url:"<%=path%>companys/stateChange.handle",
		type:"POST",
		dataType:"text",
		data:{
			"company_id":company_id,
			"state":state
		},
		success:function(msg){
			alert(msg);
			if(msg.indexOf("成功") != -1){
				window.location.href="<%=path%>companys/companysVeiw.handle";
			}
		},
		error:function(){
			alert("异常");
		}
	});
	
	<%-- var form = document.createElement("Form");
	form.action="<%=path%>companys/stateChange.handle";
	form.method="post";
	form.style.display="none";
		
	var option1 = document.createElement("input");
	option1.name="company_id";
	option1.value=company_id;
	
	var option2 = document.createElement("input");
	option2.name="state";
	if(state == "禁用"){
		option2.value="禁用";
	}else{
		option2.value="在用";
	}
	
	form.appendChild(option1);
	form.appendChild(option2);
	document.body.appendChild(form);
		
	form.submit(); --%>
}
</script>
<!-- 查 -->
<script type="text/javascript">
function putIn(){
	$.ajax({
		url:"<%=path%>companys/selectCompany.handle",
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
		var td1=$("<td></td>").text(companys[i].name);
		var td2=$("<td></td>").text(companys[i].account);
		var td3=$("<td></td>").text(companys[i].tel);
		var td4=$("<td></td>").text(companys[i].address);
		var td5=$("<td></td>").text(companys[i].people);
		var td6=$("<td></td>").text(companys[i].phone);
		var td7=$("<td></td>").text(companys[i].deposit);
		var td8=$("<td></td>").text(companys[i].state);
		var td9=$("<td></td>");
		
		var input1;
		
		if(companys[i].state == "禁用"){
			input1=$("<button type='button' class='btn btn-warning' onclick='remove()' name='"+companys[i].company_id+"'>启用</button>");
		}else{
			input1=$("<button type='button' class='btn btn-warning' onclick='remove()' name='"+companys[i].company_id+"'>禁用</button>");
		}
		
		var input2=$("<button type='button' class='btn btn-warning' onclick='remove()' name='"+companys[i].company_id+"'>删除</button>");
		var input3=$("<button type='button' class='btn btn-warning' onclick='change()' name='"+companys[i].company_id+"'>修改</button>");
		var input4=$("<button type='button' class='btn btn-warning' onclick='resetPwd()' name='"+companys[i].company_id+"'>重置密码</button>");
		var tr=$("<tr></tr>");
		
		$(td9).append(input1,input2,input3,input4);  
		$(tr).append(td1,td2,td3,td4,td5,td6,td7,td8,td9); 
		$("#companyBody").append(tr);
	}
}
</script>
<!-- 重置密码 -->
<script>
function resetPwd(e){
	var e = e || event;
	var t = e.target || e.srcElement;
	var company_id = t.name;
	
	var rt = confirm("确定重置此账号密码?");
	if(rt){
		$.ajax({
			url:"<%=path%>companys/resetPwd.handle",
			type:"POST",
			dataType:"text",
			data:"company_id="+company_id,
			success:function(msg){
    			if(msg == "重置密码成功"){
    				alert("密码已重置为：123456");
					window.location.href="<%=path%>companys/companysVeiw.handle";
    			}else{
    				alert("密码重置失败");
    			}
			},
			error:function(){
				alert("异常");
			}
		});
	}
}
</script>
<!-- 删 -->
<script>
function remove(e){
	var e = e || event;
	var t = e.target || e.srcElement;
	var company_id = t.name;
	
	var rt = confirm("确定删除此项?");
	if(rt){
		$.ajax({
			url:"<%=path%>companys/deleteCompany.handle",
			type:"POST",
			dataType:"text",
			data:"company_id="+company_id,
			success:function(msg){
				alert(msg);
    			if(msg == "删除成功"){
					window.location.href="<%=path%>companys/companysVeiw.handle";
    			}
			},
			error:function(){
				alert("异常");
			}
		});
	}
}
</script>
<!-- 改 -->
<script>
var numCheck = /^[0-9]+\.{0,1}[0-9]{0,2}$/;
var check;
function checkName(){
	if($("#account").val() == ""){
		return;
	}
	$.ajax({
		url:"<%=path%>companys/checkName.handle",
		type:"POST",
		dataType:"text",
		data:{
			account:$("#account").val(),
			id:$("#company_id").val()
		},
		success:function(msg){
			if(msg == "该名称已存在"){
				check = 0;
				layer.alert('该名称已存在!',{title: '提示框',icon:0,});
			}else{
				check = 1;
			} 
		},
		error : function() {
			alert("异常！");
		}
	});
}
function change(e){
	var e = e || event;
	var t = e.target || e.srcElement;
	document.getElementById("company_id").value = t.name;
	
	var parent = t.parentNode.parentNode;
	var mag = parent.getElementsByTagName("td");
	var input = document.getElementById("Update_Product_style").getElementsByTagName("input");

	for(var i=0;i <7;i++){
		input[i].value = mag[i].innerHTML;
	}

    layer.open({
        type: 1,
        title: '修改账号',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Update_Product_style'),
		btn:['提交','取消'],
		yes: function(index, layero){
			if($('#name').val()==""){
				 layer.alert('名称不能为空!',{title: '提示框',icon:0,});
					return false;
					
			}if(check == 0){
				 layer.alert('该名称已存在!',{title: '提示框',icon:0,});
					return false;
				
			}if($('#account').val()==""){
				layer.alert('账号不能为空!',{title: '提示框',icon:0,});
					return false;
					
			}if(!numCheck.test($('#tel').val())){
				layer.alert('手机号必须是数值!',{title: '提示框',icon:0,});
					return false;
					
			}if($('#address').val()==""){
				layer.alert('地址不能为空!',{title: '提示框',icon:0,});
				return false;
				
			}if($('#people').val()==""){
				layer.alert('领队人不能为空!',{title: '提示框',icon:0,});
				return false;
				
			}if(!numCheck.test($('#phone').val())){
				layer.alert('手机号必须是数值!',{title: '提示框',icon:0,});
					return false;
			}if(!numCheck.test($('#deposit').val())){
				layer.alert('金额必须是数值!',{title: '提示框',icon:0,});
				return false;
			}
			
			$.ajax({
	    		type:"POST",
	    		dataType:"text",
	    		url:"<%=path%>companys/updateCompany.handle",
	    		data:$('#updateForm').serialize(),
	    		success:function(msg){
	    			alert(msg);
	    			if(msg == "修改成功"){
						window.location.href="<%=path%>companys/companysVeiw.handle";
	    			}else{
	    				alert(msg);
	    			} 
	    		},
	    		error : function(msg) {
	    			alert("异常！"+msg);
	    		}
	    	});
			}
		})
	};
</script>
<!-- 增 -->
<script>
var check1;
function checkName1(){
	if($("#account1").val() == ""){
		return;
	}
	$.ajax({
		url:"<%=path%>companys/checkName.handle",
		type:"POST",
		dataType:"text",
		data:{
			account:$("#account1").val()
		},
		success:function(msg){
			if(msg == "该名称已存在"){
				check1 = 0;
				layer.alert('该名称已存在!',{title: '提示框',icon:0,});
			}else{
				check1 = 1;
			} 
		},
		error : function() {
			alert("异常！");
		}
	});
}
$('#add_butn').on('click', function(){	
    layer.open({
        type: 1,
        title: '添加账号',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Add_Product_style'),
		btn:['提交','取消'],
		yes: function(index, layero){	
			
			if($('#name1').val()==""){
				 layer.alert('名称不能为空!',{title: '提示框',icon:0,});
					return false;
					
			}if(check1 == 0){
				 layer.alert('该名称已存在!',{title: '提示框',icon:0,});
					return false;
				
			}if($('#account1').val()==""){
				layer.alert('账号不能为空!',{title: '提示框',icon:0,});
					return false;
					
			}if(!numCheck.test($('#tel1').val())){
				layer.alert('手机号必须是数值!',{title: '提示框',icon:0,});
					return false;
					
			}if($('#address1').val()==""){
				layer.alert('地址不能为空!',{title: '提示框',icon:0,});
				return false;
				
			}if($('#people1').val()==""){
				layer.alert('领队人不能为空!',{title: '提示框',icon:0,});
				return false;
				
			}if(!numCheck.test($('#phone1').val())){
				layer.alert('手机号必须是数值!',{title: '提示框',icon:0,});
					return false;
			}if(!numCheck.test($('#deposit1').val())){
				layer.alert('金额必须是数值!',{title: '提示框',icon:0,});
				return false;
			}
			
			$.ajax({
	    		type:"POST",
	    		dataType:"text",
	    		url:"<%=path%>companys/addCompany.handle",
	    		data:$('#addForm').serialize(),
	    		success:function(msg){
	    			alert(msg);
	    			if(msg == "添加成功"){
    					window.location.href="<%=path%>companys/companysVeiw.handle";
	    			}else{
	    				alert(msg);
	    			} 
	    		},
	    		error : function(msg) {
	    			alert("异常！"+msg);
	    		}
	    	});
			}
		})
	});
</script>
</html>