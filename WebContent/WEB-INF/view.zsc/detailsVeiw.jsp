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
<title>添加细项</title>
</head>
<body>
<form method = "post" id = "cFrom">
	<label>名称</label><input type = "text" name="name" id="name"/>
	<label>类型</label><input type = "text" name="type" id="type"/>
	<input type="button" value="查询" onclick="putIn()">
	<div>
		<input type="button" value="新增" onclick="javascript:window.location.href='<%=path %>detail/insertPage.handle'"/>
	</div>
	<table>
		<tr>
			<th>名称</th>
			<th>计量单位</th>
			<th>上限</th>
			<th>下限</th>
			<th>类型</th>
			<th>操作</th>
		</tr>
		<tbody id = "detailBody">
		<c:forEach items="${details}" var = "d">
		<tr>
			<td>${d.name}</td>
			<td>${d.unit}</td>
			<td>${d.max}</td>
			<td>${d.min}</td>
			<td>${d.type}</td>
			<td>
				<input type = "button" value="删除" onclick="remove()" name="${d.detail_id}">
				<input type = "button" value="修改" onclick="change()" name="${d.detail_id}">
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</form>
</body>
<script src="<%=path%>js/jquery.min.js"></script>
<script src="<%=path%>js/jquery.validate.min.js"></script>
<script src="<%=path%>js/jquery.validate.cn.js"></script>
<script type="text/javascript">
function putIn(){
	
	$.ajax({
		url:"<%=path%>derail/selectDetail.handle",
		type:"POST",
		dataType:"JSON",
		data:$("#cFrom").serialize(),
		success:function(details){
			show(details);
		},
		error:function(){
			alert("异常");
		}
	});
}
function remove(e){
	var e = e || event;
	var t = e.target || e.srcElement;
	var detail_id = t.name;
	
	var rt = confirm("确定删除此项?");
	if(rt){
		$.ajax({
			url:"<%=path%>derail/deleteDetail.handle",
			type:"POST",
			dataType:"JSON",
			data:"detail_id="+detail_id,
			success:function(details){
				show(details);
			},
			error:function(){
				alert("异常");
			}
		});
	}
}
function show(details){
	$("#detailBody").empty();  
	
	for(var i = 0;i < details.length;i++){
		
		var td1=$("<td></td>").text(details[i].name);
		var td2=$("<td></td>").text(details[i].unit);
		var td3=$("<td></td>").text(details[i].max);
		var td4=$("<td></td>").text(details[i].min);
		var td5=$("<td></td>").text(details[i].type);
		var td6=$("<td></td>");
		
		var input1=$("<input type='button' value='删除' onclick='remove()' name='"+details[i].detail_id+"'/>");
		var input2=$("<input type='button' value='修改' onclick='change()' name='"+details[i].detail_id+"'/>");

		var tr=$("<tr></tr>");
		
		$(td6).append(input1,input2);  
		$(tr).append(td1,td2,td3,td4,td5,td6); 
		$("#detailBody").append(tr);
	}
}
</script>
<script type="text/javascript">
function change(e){
	var e = e || event;
	var t = e.target || e.srcElement;
	var detail_id = t.name;
	
	var form = document.createElement("Form");
	form.action="<%=path%>derail/updatePage.handle";
	form.method="post";
	form.style.display="none";
	
	var option = document.createElement("input");
	option.name="detail_id";
	option.value=detail_id;
	
	form.appendChild(option);
	document.body.appendChild(form);
	
	form.submit();
}
</script>
</html>