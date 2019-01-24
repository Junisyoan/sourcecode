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
<title>更新账号</title>
</head>
<body>
<form id = "cForm">
	<input type = "hidden" name = "company_id" value = "${company.company_id}">
	<table>
		<tr>
			<td>公司名</td>
			<td><input type = "text" name="name" id="name" value="${company.name}"></td>
		</tr>
		<tr>
			<td>账户名</td>
			<td><input type = "text" name="account" id = "account" value="${company.account}"></td></tr>
		<tr>
			<td>旧密码</td>
			<td><input type = "password" name="oldpwd" id ="oldpwd"></td>
		</tr>
		<tr>
			<td>新密码</td>
			<td><input type = "password" name="pwd" id ="pwd"></td>
		</tr>
		<tr>
			<td>确定密码</td>
			<td><input type = "password" name="comfirmPwd" id ="comfirmPwd"></td>
		</tr>
		<tr>
			<td>公司电话</td>
			<td><input type = "text" name="tel" id="tel" value="${company.tel}"></td>
		</tr>
		<tr>
			<td>公司地址</td>
			<td><input type = "text" name="address" id = "address" value="${company.address}"></td>
		</tr>
		<tr>
			<td>领队人</td>
			<td><input type = "text" name="people" id = "people" value="${company.people}"></td></tr>
		<tr>
			<td>领队人电话</td>
			<td><input type = "text" name="phone" id ="phone" value="${company.phone}"></td>
		</tr>
		<tr>
			<td>存储金额</td>
			<td><input type = "text" name="deposit" id="deposit" value="${company.deposit}"></td>
		</tr>
		<tr>
			<td><input type = "submit" value = "提交"></td>
			<td><input type = "button" value = "返回" onclick="javascript:window.location.href='<%=path%>companys/companysVeiw.handle'"></td>
		</tr>
	</table>
</form>
</body>
<script src="<%=path%>js/jquery.min.js"></script>
<script src="<%=path%>js/jquery.validate.min.js"></script>
<script src="<%=path%>js/jquery.validate.cn.js"></script>

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
		oldpwd:{
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
		}
	},
	messages:{
		name:"名称不能为空",
		account:"账号名不能为空",
		oldpwd:"密码不能为空",
		pwd:"密码不能为空",
		confirmPwd:"最大值不能为空",
		tel:"名称不能为空",
		address:"计量单位不能为空",
		people:"最小值不能为空",
		phone:"最大值不能为空",
		deposit:"最大值不能为空"
	},
    submitHandler: function (form) {  //通过之后回调
    	$.ajax({
    		type:"POST",
    		dataType:"text",
    		url:"<%=path%>company/updateCompany.handle",
    		data:$('#cForm').serialize(),
    		success:function(msg){
    			alert(msg);
				if(msg == "修改成功"){
					window.location.href="<%=path%>companys/companysVeiw.handle";
				}else{
					window.location.href="";
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