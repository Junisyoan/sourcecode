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
<form method = "post" id = "cForm">
	<table>
		<tr>
			<td>名称</td>
			<td><input type = "text" name="name" id="name" autofocus="autofocus"></td>
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
			<td><input type = "text" name="type" id = "type"></td>
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
$("#cForm").validate({
    onsubmit: true,// 是否在提交是验证
    onfocusout: false,// 是否在获取焦点时验证
    onkeyup: false,// 是否在敲击键盘时验证
    rules:{
		name:{
			required:true
		},
		unit:{
			required:true
		},
		min:{
			required:true
		},
		max:{
			required:true
		}
	},
	messages:{
		name:"名称不能为空",
		unit:"计量单位不能为空",
		min:"最小值不能为空",
		max:"最大值不能为空"
	},
    submitHandler: function (form) {  //通过之后回调
    	$.ajax({
    		type:"POST",
    		dataType:"text",
    		url:"detail/addDetail.handle",
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