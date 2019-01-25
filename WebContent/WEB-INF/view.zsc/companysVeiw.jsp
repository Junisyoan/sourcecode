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
	<label>公司名</label><input type = "text" name="name" id="name"/>
	<label>账户名</label><input type = "text" name="account" id="account"/>
	<label>电话号码</label><input type = "text" name="tel" id="tel"/>
	<label>地址</label><input type = "text" name="address" id="address"/>
	<label>领队人</label><input type = "text" name="people" id="people"/>
	<label>领队人电话</label><input type = "text" name="phone" id="phone"/>
	<label>账户金额</label><input type = "text" name="min" id="min"/>
	<label>至</label><input type = "text" name="max" id="max"/>
	<input type="button" value="查询" onclick="putIn()">
	<div>
		<input type="button" value="新增" onclick="javascript:window.location.href='<%=path %>companys/insertPage.handle'"/>
	</div>
	<table>
		<tr>
			<th>公司名</th>
			<th>账户名</th>
			<th>电话号码</th>
			<th>地址</th>
			<th>领队人</th>
			<th>领队人电话</th>
			<th>账户金额</th>
			<th>操作</th>
		</tr>
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
			<td>
				<input type = "button" value="删除" onclick="remove()" name="${c.company_id}">
				<input type = "button" value="修改" onclick="change()" name="${c.company_id}">
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
		url:"<%=path%>companys/selectCompany.handle",
		type:"POST",
		dataType:"JSON",
		data:$("#cFrom").serialize(),
		success:function(companys){
			show(companys);
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
			url:"<%=path%>companys/deleteCompany.handle",
			type:"POST",
			dataType:"JSON",
			data:"company_id="+company_id,
			success:function(companys){
				show(companys);
			},
			error:function(){
				alert("异常");
			}
		});
	}
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
		var td8=$("<td></td>");
		
		var input1=$("<input type='button' value='删除' onclick='remove()' name='"+companys[i].company_id+"'/>");
		var input2=$("<input type='button' value='修改' onclick='change()' name='"+companys[i].company_id+"'/>");

		var tr=$("<tr></tr>");
		
		$(td8).append(input1,input2);  
		$(tr).append(td1,td2,td3,td4,td5,td6,td7,td8); 
		$("#companyBody").append(tr);
	}
}
</script>
<script type="text/javascript">
function change(e){
	var e = e || event;
	var t = e.target || e.srcElement;
	var company_id = t.name;
	
	var form = document.createElement("Form");
	form.action="<%=path%>companys/updatePage.handle";
	form.method="post";
	form.style.display="none";
	
	var option = document.createElement("input");
	option.name="company_id";
	option.value=company_id;
	
	form.appendChild(option);
	document.body.appendChild(form);
	
	form.submit();
}
</script>
</html>