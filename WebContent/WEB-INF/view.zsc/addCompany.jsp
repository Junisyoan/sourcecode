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
<title>添加账号</title>
</head>
<body>
<form method = "post" id = "cForm"  onsubmit="return putIn()">			
	<input type="hidden" id = "checkValue" name="checkValue">
	<table>
		<tr>
			<td>公司名</td>
			<td><input type = "text" name="name" id="name" autofocus="autofocus"></td>
		</tr>
		<tr>
			<td>账户名</td>
			<td><input type = "text" name="account" id = "account" onblur="checkName()"></td></tr>
		<tr>
			<td>密码</td>
			<td><input type = "password" name="pwd" id ="pwd"></td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td><input type = "password" name="confirmPwd" id="confirmPwd"></td>
		</tr>
		<tr>
			<td>公司电话</td>
			<td><input type = "text" name="tel" id="tel"></td>
		</tr>
		<tr>
			<td>公司地址</td>
			<td><input type = "text" name="address" id = "address"></td>
		</tr>
		<tr>
			<td>领队人</td>
			<td><input type = "text" name="people" id = "people"></td></tr>
		<tr>
			<td>领队人电话</td>
			<td><input type = "text" name="phone" id ="phone"></td>
		</tr>
		<tr>
			<td>存储金额</td>
			<td><input type = "text" name="deposit" id="deposit"></td>
		</tr>
		<tr>
			<td><input type = "submit" value = "提交"></td>
			<td><input type = "button" value = "返回" onclick="javascript:window.location.href='<%=path %>companys/companysVeiw.handle'"></td>
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
	if(check == 0)alert("该账号已存在");
}

function checkName(){
	if($("#name").val() == ""){
		return;
	}
	
	$.ajax({
		url:"<%=path%>companys/checkName.handle",
		type:"POST",
		dataType:"text",
		data:{
			account:$("#account").val()
		},
		success:function(msg){
			if(msg == "该账号已存在"){
				check = 0;
				alert("该账号已存在");
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
    onfocusout: false,// 是否在获取焦点时验证
    onkeyup: false,// 是否在敲击键盘时验证
    rules:{
		name:{
			required:true
		},
		account:{
			required:true
		},
		pwd:{
			required:true
		},
		confirmPwd:{
			required:true
		},
		tel:{
			required:true
		},
		address:{
			required:true
		},
		people:{
			required:true
		},
		phone:{
			required:true
		},
		deposit:{
			required:true
		},
		checkValue:{
			min:1
		}
	},
	messages:{
		name:"名称不能为空",
		account:"账号名不能为空",
		pwd:"密码不能为空",
		confirmPwd:"最大值不能为空",
		tel:"名称不能为空",
		address:"计量单位不能为空",
		people:"最小值不能为空",
		phone:"最大值不能为空",
		deposit:"最大值不能为空",
		checkValue:""
	},
    submitHandler: function (form) {  //通过之后回调
    	$.ajax({
    		type:"POST",
    		dataType:"text",
    		url:"company/addCompany.handle",
    		data:$('#cForm').serialize(),
    		success:function(msg){
    			if(msg == "添加成功"){
    				var rt = confirm("添加成功,是否继续添加细项？");
    				if(rt){
    					window.location.href="";
    				}else{
    					window.location.href="<%=path%>companys/companysVeiw.handle";
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