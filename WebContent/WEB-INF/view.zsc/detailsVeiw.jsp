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
    <title>细项管理</title>
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
   <div class="title_name">细项查询</div>
    <button type="button" class="<%=path%>btn btn-primary" id="add_butn">添加细项</button>
     <div class="Add_Manager_style">
     <form method="post" id = "aFrom" method="post">
     		名称	<input type="text" name="name"/>
     		类型	<select name="type" style="width:160px;height:30px;margin-left:10px;">
					<option></option>
					<option>普通</option>
					<option>检验</option>
					<option>彩超</option>
				</select>
  			<input type="button" class="<%=path%>btn btn-primary" value="查询" onclick="putIn()">
  	 </form>
     <div id="Add_Product_style" style="display:none">
     <div class="page-content">
     <div class="add_user_style clearfix">
    	<form  id = "addForm">
  			<ul class="clearfix">
     			<li>
     				<label class="label_name">名称</label>
     				<input type = "text" name="name" id="name1" autofocus="autofocus" onblur="checkName1()">
     			</li>
        		<li>
     				<label class="label_name">计量单位</label>
     				<input type = "text" name="unit" id = "unit1">
     			</li>
     			<li>
     				<label class="label_name">最小值</label>
     				<input type = "text" name="min" id ="min1">
     			</li>
     			<li>
     				<label class="label_name">最大值</label>
     				<input type = "text" name="max" id="max1">
     			</li>
     			<li>
     				<label class="label_name">类型</label>
     				<select name="type" id="type1" style="width:160px;height:30px;margin-left:10px;">
						<option>普通</option>
						<option>检验</option>
						<option>彩超</option>
					</select>
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
     				<label class="label_name">名称</label>
     				<input type = "text" name="name" id="name" autofocus="autofocus" onblur="checkName()">
     			</li>
        		<li>
     				<label class="label_name">计量单位</label>
     				<input type = "text" name="unit" id = "unit">
     			</li>
     			<li>
     				<label class="label_name">最小值</label>
     				<input type = "text" name="min" id ="min">
     			</li>
     			<li>
     				<label class="label_name">最大值</label>
     				<input type = "text" name="max" id="max">
     			</li>
     			<li>
     				<label class="label_name">类型</label>
     				<select name="type" id="type" style="width:160px;height:30px;margin-left:10px;">
						<option>普通</option>
						<option>检验</option>
						<option>彩超</option>
					</select>
				</li>
      		</ul> 
      		<input type = "hidden" id = "detail_id" name = "detail_id">
      	 </form> 
      </div>       
    </div>
  </div>
 </div>
</div>
 </div>   
</div>
	<div class="page-content">
		<div class="Manager_style">
			<div class="title_name">细项列表</div>
			<table id="test" class="table table-striped table-bordered" style="">
				<thead>
					<tr>
						<th>序号</th>
						<th>名称</th>
						<th>计量单位</th>
						<th>下限</th>
						<th>上限</th>
						<th>类型</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="detailBody">
					<c:forEach items="${details}" var="d" varStatus="s">
						<tr>
							<td>${s.count}</td>
							<td>${d.name}</td>
							<td>${d.unit}</td>
							<td>${d.min}</td>
							<td>${d.max}</td>
							<td>${d.type}</td>
							<td>
								<button type="button" class="btn btn-warning" onclick="remove()"
									name="${d.detail_id}">删除</button>
								<button type="button" class="btn btn-primary" onclick="change()"
									name="${d.detail_id}">修改</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$('#test').DataTable();
	});
</script>
<!-- 查 -->
<script type="text/javascript">
function putIn(){
	$.ajax({
		url:"<%=path%>detail/selectDetail.handle",
		type:"POST",
		dataType:"JSON",
		data:$("#aFrom").serialize(),
		success:function(details){
			show(details);
		},
		error:function(){
			alert("异常");
		}
	});
}
function show(details){
	$("#detailBody").empty();  
	
	for(var i = 0;i < details.length;i++){
		var td0=$("<td></td>").text(i+1);
		var td1=$("<td></td>").text(details[i].name);
		var td2=$("<td></td>").text(details[i].unit);
		var td3=$("<td></td>").text(details[i].max);
		var td4=$("<td></td>").text(details[i].min);
		var td5=$("<td></td>").text(details[i].type);
		var td6=$("<td></td>");
		
		var input1=$("<button type='button' class='btn btn-warning' onclick='remove()' name='"+details[i].detail_id+"'>删除</button>");
		var input2=$("<button type='button' class='btn btn-warning' onclick='change()' name='"+details[i].detail_id+"'>修改</button>");

		var tr=$("<tr></tr>");
		
		$(td6).append(input1,input2);  
		$(tr).append(td0,td1,td2,td3,td4,td5,td6); 
		$("#detailBody").append(tr);
	}
}
</script>
<!-- 删 -->
<script>
function remove(e){
	var e = e || event;
	var t = e.target || e.srcElement;
	var detail_id = t.name;
	
	var rt = confirm('确定删除此项?');
	
	if(rt > 0){
		$.ajax({
			url:"<%=path%>detail/deleteDetail.handle",
			type:"POST",
			dataType:"text",
			data:"detail_id="+detail_id,
			success:function(msg){
				alert(msg);
    			if(msg == "删除成功"){
					window.location.href="<%=path%>detail/detailsVeiw.handle";
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
var numCheck = /^[1-9]d*.d*|0.d*[1-9]d*$/;
var numCheck1 = /^[0-9]*$/;
var check;
function checkName(){
	if($("#name").val() == ""){
		return;
	}
	$.ajax({
		url:"<%=path%>detail/checkName.handle",
		type:"POST",
		dataType:"text",
		data:{
			name:$("#name").val(),
			id:$("#detail_id").val()
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
	document.getElementById("detail_id").value = t.name;
	
	var parent = t.parentNode.parentNode;
	var mag = parent.getElementsByTagName("td");
	var input = document.getElementById("Update_Product_style").getElementsByTagName("input");

	for(var i=0;i <4;i++){
		input[i].value = mag[i+1].innerHTML;
	}
	
	 var sel = document.getElementById("type");
	    for (var i = 0; i < sel.options.length; i++)
	    {
	        if (sel.options[i].text == mag[5].innerHTML)
	        {
	        	sel.options[i].remove();
	            break;  
	        } 
	    }
	$("#type").prepend("<option>"+mag[5].innerHTML+"</option>"); 
	sel.options[0].selected=true;
    
    layer.open({
        type: 1,
        title: '修改细项',
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
				
			}if($('#unit').val()==""){
				layer.alert('计量单位不能为空!',{title: '提示框',icon:0,});
					return false;
					
			}if(!(numCheck.test($('#min').val())||numCheck1.test($('#min').val()))){
				layer.alert('最小值必须是数值!',{title: '提示框',icon:0,});
					return false;
					
			}if(!(numCheck.test($('#max').val())||numCheck1.test($('#max').val()))){
				layer.alert('最大值必须是数值!',{title: '提示框',icon:0,});
					return false;
			}
			var a = Number($('#min').val());
			var b = Number($('#max').val());
			if(a > b){
				layer.alert('最大值必须大于等于最小值!',{title: '提示框',icon:0,});
					return false;
			}
			
			$.ajax({
	    		type:"POST",
	    		dataType:"text",
	    		url:"<%=path%>detail/updateDetail.handle",
	    		data:$('#updateForm').serialize(),
	    		success:function(msg){
	    			alert(msg);
	    			if(msg == "修改成功"){
    					window.location.href="<%=path%>detail/detailsVeiw.handle";
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
	if($("#name1").val() == ""){
		return;
	}
	$.ajax({
		url:"<%=path%>detail/checkName.handle",
		type:"POST",
		dataType:"text",
		data:{
			name:$("#name1").val()
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
        title: '添加细项',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Add_Product_style'),
		btn:['提交','取消'],
		yes: function(index, layero){	
			
			if($('#name1').val()==""){
				 layer.alert('名称不能为空!',{
		              title: '提示框',								
					  icon:0,			    
					 });
					return false;
					
			}if(check1 == 0){
				 layer.alert('该名称已存在!',{
		              title: '提示框',								
					  icon:0,			    
					 });
				return false;
				
			}if($('#unit1').val()==""){
				layer.alert('计量单位不能为空!',{
		              title: '提示框',								
					  icon:0,			    
					 });
					return false;
					
			}if(!(numCheck.test($('#min1').val())||numCheck1.test($('#min1').val()))){
				layer.alert('最小值必须是数值!',{
		              title: '提示框',								
					  icon:0,			    
					 });
					return false;
					
			}if(!(numCheck.test($('#max1').val())||numCheck1.test($('#max1').val()))){
				layer.alert('最大值必须是数值!',{
		              title: '提示框',								
					  icon:0,			    
					 });
					return false;
					
			}
			var a = Number($('#min1').val());
			var b = Number($('#max1').val());
			if(a > b){
				layer.alert('最大值必须大于等于最小值!',{
		              title: '提示框',								
					  icon:0,			    
					 });
					return false;
			}
			
			$.ajax({
	    		type:"POST",
	    		dataType:"text",
	    		url:"<%=path%>detail/addDetail.handle",
	    		data:$('#addForm').serialize(),
	    		success:function(msg){
	    			alert(msg);
	    			if(msg == "添加成功"){
    					window.location.href="<%=path%>detail/detailsVeiw.handle";
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