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
<title>套餐</title>
<style type="text/css">
	.textarea {
      width:50px;
      border:1px solid #ccc;
      min-height:50px;
      max-height:50px;
      overflow: auto;
      font-size: 14px;
      outline: none;
 	}
</style>
</head>
<body>
<form method = "post" id = "cFrom">
	<label>名称</label><input type = "text" name="name" id="name"/>
	<label>价钱</label>
		<input type = "text" name="min" id="min"/>
	<label>至</label>
		<input type = "text" name="max" id="max"/>
	<input type="button" value="查询" onclick="putIn()">
	<div>
		<input type="button" value="新增" onclick="javascript:window.location.href='<%=path %>combo/addComboPage.handle'"/>
	</div>
	<table>
		<tr>
			<th>名称</th>
			<th>价钱</th>
			<th>包含项目</th>
			<th>操作</th>
		</tr>
		<tbody id = "comboBody">
		<c:forEach items="${combos}" var = "c">
		<tr>
			<td>${c.name}</td>
			<td>${c.price}</td>
			<td>
				<div class="textarea">
					<c:forEach items="${c.projects}" var = "p">
						<span>${p.name}</span><br/>
					</c:forEach>
				</div>
			</td>
			<td>
				<input type = "button" value="删除" onclick="remove()" name="${c.combo_id}">
				<input type = "button" value="修改" onclick="change()" name="${c.combo_id}">
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
		url:"<%=path%>combo/selectCombo.handle",
		type:"POST",
		dataType:"JSON",
		data:$("#cFrom").serialize(),
		success:function(combo){
			show(combo);
		},
		error:function(){
			alert("异常");
		}
	});
}
function remove(e){
	var e = e || event;
	var t = e.target || e.srcElement;
	var combo_id = t.name;
	
	var rt = confirm("确定删除此项?");
	if(rt){
		$.ajax({
			url:"<%=path%>combo/deleteCombo.handle",
			type:"POST",
			dataType:"JSON",
			data:"combo_id="+combo_id,
			success:function(combos){
				show(combos);
			},
			error:function(){
				alert("异常");
			}
		});
	}
}
function show(combos){
	$("#comboBody").empty();  
	
	for(var i = 0;i < combos.length;i++){
		
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
		
		var input1=$("<input type='button' value='删除' onclick='remove()' name='"+combos[i].combo_id+"'/>");
		var input2=$("<input type='button' value='修改' onclick='change()' name='"+combos[i].combo_id+"'/>");
		
		$(td3).append(div);  
		$(td4).append(input1,input2);  
		$(tr).append(td1,td2,td3,td4); 
		$("#comboBody").append(tr);
	}
}
</script>
<script type="text/javascript">
function change(e){
	var e = e || event;
	var t = e.target || e.srcElement;
	var combo_id = t.name;
	
	var form = document.createElement("Form");
	form.action="<%=path%>combo/updatePage.handle";
	form.method="post";
	form.style.display="none";
	
	var option = document.createElement("input");
	option.name="combo_id";
	option.value=combo_id;
	
	form.appendChild(option);
	document.body.appendChild(form);
	
	form.submit();
}
</script>
</html>