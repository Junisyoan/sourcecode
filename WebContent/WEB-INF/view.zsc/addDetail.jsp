<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加细项</title>
</head>
<body>
<form id = "cForm" onsubmit="putIn()">
	<table>
		<tr>
			<td>名称</td>
			<td>
				<input type = "text" name="name" id="name" autofocus="autofocus" onblur="checkName()">
				<input type="hidden" id = "checkValue" name="checkValue">
			</td>
		</tr>
		<tr>
			<td>计量单位</td>
			<td><input type = "text" name="unit" id = "unit"></td></tr>
		<tr>
			<td>最小值</td>
			<td><input type = "text" name="min" id ="min"></td>
		</tr>
		<tr>
			<td>最大值</td>
			<td><input type = "text" name="max" id="max"></td>
		</tr>
		<tr>
			<td>类型</td>
			<td>
				<select name="type" id="type">
					<option>普通</option>
					<option>检验</option>
					<option>影像</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><input type = "submit" value = "提交"></td>
			<td><input type = "button" value = "返回" onclick="javascript:window.location.href='<%=path%>detail/detailsVeiw.handle'"></td>
		</tr>
	</table>
</form>
</body>
<script src="<%=path%>js/jquery.min.js"></script>
<script src="<%=path%>js/jquery.validate.min.js"></script>
<script src="<%=path%>js/jquery.validate.cn.js"></script>
<script>
var check;

function putIn(){
	document.getElementById("checkValue").value=check;
	if(check == 0)alert("该名称已存在");
}

function checkName(){
	if($("#name").val() == ""){
		return;
	}
	
	$.ajax({
		url:"<%=path%>detail/checkName.handle",
		type:"POST",
		dataType:"text",
		data:{
			name:$("#name").val()
		},
		success:function(msg){
			if(msg == "该名称已存在"){
				check = 0;
				alert("该名称已存在");
			}else{
				check = 1;
			} 
		},
		error : function() {
			alert("异常！");
		}
	});
}
</script>
<script>
$("#cForm").validate({
    onsubmit: true,// 是否在提交是验证
    onfocusout: true,// 是否在获取焦点时验证
    onkeyup: false,// 是否在敲击键盘时验证
    rules:{
		name:{
			required:true
		},
		unit:{
			required:true
		},
		min:{
			required:true,
			digits:true
		},
		max:{
			required:true,
			digits:true
		},
		checkValue:{
			min:1
		}
	},
	messages:{
		name:"名称不能为空",
		unit:"计量单位不能为空",
		min:"必须输入数字",
		max:"必须输入数字",
		checkValue:""
	},
    submitHandler: function (form) {  //通过之后回调
    	$.ajax({
    		type:"POST",
    		dataType:"text",
    		url:"<%=path%>detail/addDetail.handle",
    		data:$('#cForm').serialize(),
    		success:function(msg){
    			if(msg == "添加成功"){
    				var rt = confirm("添加成功,是否继续添加细项？");
    				if(rt){
    					window.location.href="";
    				}else{
    					window.location.href="<%=path%>detail/detailsVeiw.handle";
    				}
    			}else{
    				alert(msg);
    			} 
    		},
    		error : function(msg) {
    			alert("异常！"+msg);
    		}
    	});
    },
    invalidHandler: function (form, validator) {  //不通过回调
        return false;
    }
});
</script>
</html>