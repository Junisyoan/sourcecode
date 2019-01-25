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
<meta charset="UTF-8">
<title>添加项目</title>
</head>
<body>
<form id = "cForm" onsubmit="return putIn()">
	<label>名称</label><input type = "text" name="name" id = "name"/>
	<label>价钱</label><input type = "text" name="price" id = "price"/>
	<label>科室</label><input type = "text" name="paramName" id = "paramName" value="检验室"/>
	<table>
		<tr>
			<th>选择</th>
			<th>名称</th>
		</tr>
		<tbody id = "detailBody"></tbody>
	</table>
	<input type="button" value="上一页" onclick="prev()"/>
	<input type="button" value="下一页" onclick="next()"/>
	<input type="submit" value="提交"/>
	<input type="button" value="返回" onclick="javascript:window.location.href='<%=path%>project/projectsVeiw.handle'"/>
</form>
</body>
<script src="<%=path%>js/jquery.min.js"></script>
<script src="<%=path%>js/jquery.validate.min.js"></script>
<script src="<%=path%>js/jquery.validate.cn.js"></script>
<script>
var detailList = new Array();
var current = 0;
var row = 3;
var totalPage;
var idArray  = new Array();

function createDetail(detail_id,detail_name){
	var detail = new Object();
	detail.id = detail_id;
	detail.name = detail_name;
	return detail;
}

function show(){
	$("#detailBody").empty();  
	
	for(var i = current*row;i < Math.min((current+1)*row,detailList.length);i++){
		
		var td1=$("<td></td>");
		var td2=$("<td></td>").text(detailList[i].name);
		
		var checkbox=$("<input type='checkbox' value='"+detailList[i].id+"'/>");
		
		if(idArray.indexOf(detailList[i].id) >= 0){
			checkbox.attr("checked",'true');
		}
		
		var tr=$("<tr></tr>");
		
		$(td1).append(checkbox);  
		$(tr).append(td1,td2); 
		
		$("#detailBody").append(tr);
	}
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
		show();
	}
}

function next(){
	save();
	if(current >= totalPage){
		alert("当前为最后一页");
	}else{
		current ++;
		show();
	}
}

$(document).ready(function(){
	<c:forEach items="${details}" var = "d" >
		var detail = createDetail("${d.detail_id}","${d.name}");
		detailList.push(detail);
	</c:forEach>
	
});

$(document).ready(function(){
	var len = detailList.length;
	
	if(len%row == 0){
		totalPage = len/row-1;
	}else{
		totalPage = len/row;
	}
	
	show();
});
</script>
<script>
function putIn(){
	save();
	
	if(idArray.length > 0){
		return true;
	}else{
		alert("未选择细项");
		return false;
	}
}

$("#cForm").validate({
    onsubmit: true,// 是否在提交是验证
    onfocusout: false,// 是否在获取焦点时验证
    onkeyup: false,// 是否在敲击键盘时验证
    rules:{
		name:{
			required:true
		},
		price:{
			required:true
		}
	},
	messages:{
		name:"名称不能为空",
		price:"价钱不能为空"
	},
    submitHandler: function (form) {  //通过之后回调
    	$.ajax({
    		url:"addProject.handle",
    		type:"post",
    		dataType:"text",
    		data:{
    			"name":$("#name").val(),
    			"price":$("#price").val(),
    			"param.name":$("#paramName").val(),
    			"idArray":idArray,
    		},
    		traditional: true,
    		success:function(msg){
    			if(msg == "ok"){
    				var rt = confirm("添加成功,是否继续添加细项？");
    				if(rt){
    					window.location.href="";
    				}else{
    					window.location.href="<%=path%>project/projectsVeiw.handle";
    				}
    			}else{
    				alert(msg);
    			} 
    		}
    	});
    },
    invalidHandler: function (form, validator) {  //不通过回调
        return false;
    }
});
</script>
</html>