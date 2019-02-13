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
    <title>套餐查询</title>
  <style type="text/css">
  	#aFrom input {
      margin-top:10px;
 	}
	.textarea {
      width:150px;
      border:1px solid #ccc;
      min-height:80px;
      max-height:80px;
      overflow: auto;
      font-size: 14px;
      outline: none;
      margin:0 auto;
 	}
 	.checkList{
 		width:400px;
 		margin:0 auto;
 	}
 	.btnList{
		width: 300px;
		height: 50px;
		margin: 10px 0 0 160px;
 	}
 	.checkList th,.checkList td {
    border: 1px #E6E6FA solid;
    font-weight: 100;
    line-height: 25px;
    font-size: 15px;
    text-align: center;
}
</style>
</head>
<body>
<div class="page-content">
<div class="gys_style">
 <div class="Manager_style">
   <div class="title_name">套餐查询</div>
    <button type="button" class="<%=path%>btn btn-primary" id="add_butn">添加套餐</button>
     <div class="Add_Manager_style">
     
     <form method="post" id = "aFrom" method="post">
     		名称	<input type="text" name="name"/>
     		价钱	<input type="text" name="min"/>
     		至	<input type="text" name="max"/>
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
     				<label class="label_name">价钱</label>
     				<input type = "text" name="price" id="price1">
     			</li>
      		</ul>  
     			<label class="label_name">选择项目</label>
     			<table class="checkList">
					<tr>
						<th style="width:50px;">选择</th>
						<th>名称</th>
					</tr>
					<tbody id = "projectBody1"></tbody>
				</table>
				<div class="btnList">
					<input type="button" value="上一页" onclick="prev()" /> 
						<span id = "current1"></span>
						<span>/</span>
						<span id = "total1"></span>
					<input type="button" value="下一页" onclick="next()" />
					<input type="text" id = "page1" style = "width:50px;"/>
					<input type="button" value="跳转" onclick="jump()" />
				</div>
      	 </form> 
      </div>       
    </div>
  </div>
  	 
  	 <div id="Update_Product_style" style="display:none">
     <div class="page-content">
     <div class="add_user_style clearfix">
    	<form  id = "updateForm">
  			<ul class="clearfix">
     			<li>
     				<label class="label_name">名称</label>
     				<input type = "text" name="name" id="name" autofocus="autofocus" onblur="checkName1()">
     			</li>
     			<li>
     				<label class="label_name">价钱</label>
     				<input type = "text" name="price" id="price">
     			</li>
      		</ul> 
      			<label class="label_name">选择项目</label>
     			<table class="checkList">
					<tr>
						<th style="width:50px;">选择</th>
						<th>名称</th>
					</tr>
					<tbody id = "projectBody"></tbody>
				</table>
				<div class="btnList">
					<input type="button" value="上一页" onclick="prev()" /> 
						<span id = "current"></span>
						<span>/</span>
						<span id = "total"></span>
					<input type="button" value="下一页" onclick="next()" />
					<input type="text" id = "page" style = "width:50px;"/>
					<input type="button" value="跳转" onclick="jump()" />
				</div> 
      		<input type="hidden" id = "combo_id" name = "combo_id">
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
			<div class="title_name">套餐列表</div>
			<table id="test" class="table table-striped table-bordered" style="">
				<thead>
					<tr>
						<th>序号</th>
						<th>名称</th>
						<th>价钱</th>
						<th>包含项目</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="comboBody">
					<c:forEach items="${combos}" var="c" varStatus="s">
						<tr>
							<td>${s.count}</td>
							<td>${c.name}</td>
							<td>${c.price}</td>
							<td>
								<div class="textarea">
									<c:forEach items="${c.projects}" var="p">
										<span>${p.name}</span>
										<br />
									</c:forEach>
								</div>
							</td>
							<td>
								<button type="button" class="btn btn-warning" onclick="remove()"
									name="${c.combo_id}">删除</button>
								<button type="button" class="btn btn-primary" onclick="change()"
									name="${c.combo_id}">修改</button>
							</td>
							<c:forEach items="${c.projects}" var="p">
								<input type="hidden" name="projectId" value="${p.project_id}">
							</c:forEach>
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
<!-- 通用 -->
<script>
var projectList = new Array();
var idArray  = new Array();
var current;
var row = 5;
var totalPage;
var state;

var numCheck = /^[1-9]d*.d*|0.d*[1-9]d*$/;

function createProject(project_id,project_name){
	var project = new Object();
	project.id = project_id;
	project.name = project_name;
	return project;
}

function save(){
	var checkBoxs = $('input[type="checkbox"]');
	
	for(var i=0;i < checkBoxs.length;i++){
		var num = checkBoxs[i].value;
		
		/* 如果多选框被选择，并且不存在与记录数组中，则添加进去 */
		if(checkBoxs[i].checked && idArray.indexOf(num) == -1){
			idArray.push(num);
		}
		/* 如果多选框未被选择 */
		else if(!checkBoxs[i].checked){
			/* 遍历判断是否存在与记录数组中 */
			for(var j=0;j < idArray.length;j++){
				/* 如果存在则删除 */
				if (idArray[j] == num){
					idArray.splice(j,1);
				}
		 	}
		}
	}
}

function prev(){
	save();
	if(current <= 0){
		alert("当前为最前页");
	}else{
		current --;
		if(state=="add"){
			show1();
			$("#current1").text(current+1);
		}else{
			show();
			$("#current").text(current+1);
		}
	}
}
function next(){
	save();
	if(current >= totalPage){
		alert("当前为最后一页");
	}else{
		current ++;
		if(state=="add"){
			show1();
			$("#current1").text(current+1);
		}else{
			show();
			$("#current").text(current+1);
		}
	}
}

function jump(){
	if(state=="add"){
		var page = $("#page1").val();
		if(!numCheck1.test($('#page1').val())){
			layer.alert('跳转时必须是数值!',{title: '提示框',icon:0,});
				return false;
		}
		var a = Number($('#page1').val());
		if(a<1||a>totalPage+1){
			layer.alert('输入数值不在跳转范围!',{title: '提示框',icon:0,});
			return false;
		}
		save();
		current = a-1;
		show1();
		$("#current1").text(current+1);
	}else{
		var page = $("#page").val();
		if(!numCheck1.test($('#page').val())){
			layer.alert('跳转时必须是数值!',{title: '提示框',icon:0,});
				return false;
		}
		var a = Number($('#page').val());
		if(a<1||a>totalPage+1){
			layer.alert('输入数值不在跳转范围!',{title: '提示框',icon:0,});
			return false;
		}
		save();
		current = a-1;
		show();
		$("#current").text(current+1);
	}
}
</script>
<!-- 查 -->
<script type="text/javascript">
function putIn(){
	if($('#min').val() != ""&&!(numCheck.test($('#min').val())||numCheck1.test($('#min').val()))){
		layer.alert('最小值必须是数值!',{
              title: '提示框',								
			  icon:0,			    
			 });
			return false;
	}
	if($('#max').val() != ""&&!(numCheck.test($('#max').val())||numCheck1.test($('#max').val()))){
		layer.alert('最大值必须是数值!',{
              title: '提示框',								
			  icon:0,			    
			 });
			return false;
	}
	$.ajax({
		url:"<%=path%>combo/selectCombo.handle",
		type:"POST",
		dataType:"JSON",
		data:$("#aFrom").serialize(),
		success:function(combos){
			showCombos(combos);
		},
		error:function(){
			alert("异常");
		}
	});
}
function showCombos(combos){
	$("#comboBody").empty();  
	
	for(var i = 0;i < combos.length;i++){
		var td0=$("<td></td>").text(i+1);
		var td1=$("<td></td>").text(combos[i].name);
		var td2=$("<td></td>").text(combos[i].price);
		var td3=$("<td></td>");
		var td4=$("<td></td>");
		var tr=$("<tr></tr>");
		
		var div=$("<div></div>").addClass("textarea"); 
		for(var j = 0;j < combos[i].projects.length;j++){
			var divn = $("<div></div>").text(combos[i].projects[j].name);
			$(div).append(divn);
		}
		
		var input1=$("<button type='button' class='btn btn-warning' onclick='remove()' name='"+combos[i].combo_id+"'>删除</button>");
		var input2=$("<button type='button' class='btn btn-warning' onclick='change()' name='"+combos[i].combo_id+"'>修改</button>");
		
		$(td3).append(div);  
		$(td4).append(input1,input2);  
		$(tr).append(td0,td1,td2,td3,td4); 
		
		for(var j = 0;j < combos[i].projects.length;j++){
			var projectId = $("<input type='hidden' name = 'detailId' value='"+combos[i].projects[j].project_id+"'>");
			$(tr).append(projectId);
		}
		
		$("#comboBody").append(tr);
	}
}
</script>
<!-- 删 -->
<script>
function remove(e){
	var e = e || event;
	var t = e.target || e.srcElement;
	var combo_id = t.name;
	
	var rt = confirm("确定删除此项?");
	if(rt){
		var form = document.createElement("Form");
		form.action="<%=path%>combo/deleteCombo.handle";
		form.method="post";
		form.style.display="none";
		
		var option = document.createElement("input");
		option.name="combo_id";
		option.value=combo_id;
		
		form.appendChild(option);
		document.body.appendChild(form);
		
		form.submit();
	}
}
</script>
<!-- 改 -->
<script>
var check;
function checkName(){
	if($("#name").val() == ""){
		return;
	}
	
	$.ajax({
		url:"<%=path%>combo/checkName.handle",
		type:"POST",
		dataType:"text",
		data:{
			name:$("#name").val(),
			id:"${combo.combo_id}"
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

function show(){
	
	$("#projectBody").empty();  
	
	for(var i = current*row;i < Math.min((current+1)*row,projectList.length);i++){
		
		var td1=$("<td></td>");
		var td2=$("<td></td>").text(projectList[i].name);
		
		var checkbox=$("<input type='checkbox' value='"+projectList[i].id+"'/>");
		
		if(idArray.indexOf(projectList[i].id) >= 0){
			checkbox.attr("checked",'true');
		}
		
		var tr=$("<tr></tr>");
		
		$(td1).append(checkbox);  
		$(tr).append(td1,td2); 
		
		$("#projectBody").append(tr);
	}
}

function change(e){
	state = "update";
	current = 0;
	idArray  = new Array();
	var len = projectList.length;
	
	if(len%row == 0){
		totalPage = len/row-1;
	}else{
		totalPage = Math.floor(len/row);
	}
	
	$("#total").text(totalPage+1);
	$("#current").text("1");
	
	var e = e || event;
	var t = e.target || e.srcElement;
	document.getElementById("combo_id").value = t.name;
	
	var parent = t.parentNode.parentNode;
	var mag = parent.getElementsByTagName("td");
	var input = document.getElementById("Update_Product_style").getElementsByTagName("input");
	var project_id = parent.getElementsByTagName("input");
	
	for(var i=0;i <2;i++){
		input[i].value = mag[i].innerHTML;
	}
	
	for(var i=0;i <project_id.length;i++){
		idArray.push(project_id[i].value);
	}
	
	show();
	
	layer.open({
        type: 1,
        title: '修改项目',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Update_Product_style'),
		btn:['提交','取消'],
		yes: function(index, layero){	
			save();
			
			if($('#name').val()==""){
				 layer.alert('名称不能为空!',{
		              title: '提示框',								
					  icon:0,			    
					 });
					return false;
					
			}if(check == 0){
				 layer.alert('该名称已存在!',{
		              title: '提示框',								
					  icon:0,			    
					 });
				return false;
				
			}if(!numCheck.test($('#price').val())){
				layer.alert('价格必须是数值!',{
		              title: '提示框',								
					  icon:0,			    
					 });
					return false;
					
			}if(idArray.length == 0){
				layer.alert('未选择细项!',{
		              title: '提示框',								
					  icon:0,			    
					 });
					return false;
			}
			
			$.ajax({
	    		type:"POST",
	    		dataType:"text",
	    		url:"<%=path%>combo/updateCombo.handle",
	    		data:{
	    			"combo_id":$("#combo_id").val(),
	    			"name":$("#name").val(),
	    			"price":$("#price").val(),
	    			"idArray":idArray
	    		},
	    		traditional: true,
	    		success:function(msg){
	    			alert(msg);
	    			if(msg == "修改成功"){
	    				window.location.href="<%=path%>combo/combosVeiw.handle";
	    			}
	    		},
	    		error : function() {
	    			alert("异常！");
	    		}
	    	});
			}
		})
	};
</script>
<!-- 增 -->
<script>
function show1(){
	
	$("#projectBody1").empty();  
	
	for(var i = current*row;i < Math.min((current+1)*row,projectList.length);i++){
		
		var td1=$("<td></td>");
		var td2=$("<td></td>").text(projectList[i].name);
		
		var checkbox=$("<input type='checkbox' value='"+projectList[i].id+"'/>");
		
		if(idArray.indexOf(projectList[i].id) >= 0){
			checkbox.attr("checked",'true');
		}
		
		var tr=$("<tr></tr>");
		
		$(td1).append(checkbox);  
		$(tr).append(td1,td2); 
		
		$("#projectBody1").append(tr);
	}
}

$(document).ready(function(){
	<c:forEach items="${projects}" var = "p" >
		var project = createProject("${p.project_id}","${p.name}");
		projectList.push(project);
	</c:forEach>
});

var check1;
function checkName1(){
	if($("#name1").val() == ""){
		return;
	}
	$.ajax({
		url:"<%=path%>combo/checkName.handle",
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
	state = "add";
	current = 0;
	idArray  = new Array();
	var len = projectList.length;
	
	if(len%row == 0){
		totalPage = len/row-1;
	}else{
		totalPage = Math.floor(len/row);
	}

	$("#total1").text(totalPage+1);
	$("#current1").text("1");
	
	show1();
	
    layer.open({
        type: 1,
        title: '添加套餐',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Add_Product_style'),
		btn:['提交','取消'],
		yes: function(index, layero){	
			save();
			
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
				
			}if(!numCheck.test($('#price1').val())){
				layer.alert('价格必须是数值!',{
		              title: '提示框',								
					  icon:0,			    
					 });
					return false;
					
			}if(idArray.length == 0){
				layer.alert('未选择细项!',{
		              title: '提示框',								
					  icon:0,			    
					 });
					return false;
					
			}
			
			$.ajax({
	    		type:"POST",
	    		dataType:"text",
	    		url:"<%=path%>combo/addCombo.handle",
	    		data:{
	    			"name":$("#name1").val(),
	    			"price":$("#price1").val(),
	    			"idArray":idArray
	    		},
	    		traditional: true,
	    		success:function(msg){
	    			if(msg == "ok"){
	    				alert("添加成功");
    					window.location.href="<%=path%>combo/combosVeiw.handle";
	    			}else{
	    				alert("添加失败");
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