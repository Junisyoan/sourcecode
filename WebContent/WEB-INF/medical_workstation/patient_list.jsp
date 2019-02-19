<%@ page language="java" import="java.util.*"
	contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
 <![endif]-->
<link rel="stylesheet" href="<%=path%>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path%>css/style.css" />
<script src="<%=path%>js/jquery-1.8.3.min.js"></script>
<script src="<%=path %>js/jquery.dataTables.min.js"></script>
<script src="<%=path %>js/datatables.bootstrap.min.js"></script>
<script src="<%=path%>js/jquery-ui.1.12.1.js"></script>
<script src="<%=path%>assets/layer/layer.js" type="text/javascript"></script>
<title>人员列表</title>
</head>

<body>
	<div class="page-content">
		<div class="Manager_style">
			<span class="title_name">相关操作</span>
			<button type="button" class="btn btn-info" onclick="javascript:$('#addDialog').dialog('open');">添加临时人员</button>
			<button type="button" id="all" class="btn btn-primary"	onclick="allOpen('${fid}');">生成账单</button>
			<button type="button" id="goback" class="btn btn-waring" onclick="javascript:window.history.back();">返回</button>
		</div>
		<div class="Manager_style">
			<span class="title_name">人员列表</span>
			<table id="patientTable"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>身份证号</th>
						<th>手机号</th>
						<th>套餐</th>
						<th>操作</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${patientList}" var="p" varStatus="s">
						<tr>
							<td>${s.count}</td>
							<td>${p.name}</td>
							<td>${p.sex}</td>
							<td>${p.age}</td>
							<td>${p.ID}</td>
							<td>${p.phone}</td>
							<td>${p.comboName }</td>
							<td>
								<button type="button" class="btn btn-info"
									onclick="upPatient('${p.comboName }','${p.name}','${p.sex}','${p.age}','${p.ID}','${p.phone}','${s.count}');">临时修改</button>
								<button type="button" class="btn btn-waring"
									onclick="delPatient('${s.count}','${p.name}');">临时删除</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 弹出框 -->
	<div id="addDialog" title="增加人员">
		<form action="<%=path%>nurse/addPatient.handle" method="post">
			<table width="600" border="0" cellpadding="2">
				<tr>
					<td>套餐名：</td>
					<td><input type="text" name="comboName" id="comboName" /></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="name" id="name" /></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="text" name="sex" id="sex" /></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" name="age" id="age" /></td>
				</tr>
				<tr>
					<td>身份证号：</td>
					<td><input type="text" name="ID" id="ID" /></td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td><input type="text" name="phone" id="phone" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="增加" /></td>
					<td><input type="reset" value="清空" /></td>
				</tr>
			</table>
		</form>

	</div>

	<div id="updateDialog" title="修改人员" align="center" style="display:none">
		<form id="updateP" action="<%=path%>nurse/updatePatient.handle" method="post" style="align: center;">
			<table width="400" border="0" cellpadding="2">
				<tr>
					<td>套餐名：</td>
					<td><input type="text" name="comboName" id="upComboName" /></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="name" id="upName" /></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="text" name="sex" id="upSex" /></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" name="age" id="upAge" /></td>
				</tr>
				<tr>
					<td>身份证号：</td>
					<td><input type="text" name="ID" id="upID" /></td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td><input type="text" name="phone" id="upPhone" /></td>
				</tr>
			</table>
			<div style="display:none">
				<input type="text" name="id" id="count"></input>
			</div>
		</form>
	</div>
	<div id="loadgif" style="width:66px;height:66px;position:absolute;top:50%;left:50%;">
		<img alt="加载中..." src="<%=path%>image/loading.gif"/>
	</div>
</body>
<script type="text/javascript">

$(function(){
	$("#loadgif").hide();
});

$('#upComboName').blur(function(){
	var c = $('#upComboName').val();
	$.ajax({
		url:"<%=path%>nurse/queryComboName.handle",
		type:"post",
		dataType:"text",
		data:{'comboName':c},
		success:function(strRet){
			if(strRet=="0"){
				alert('套餐不存在');
			}
		},
		error:function(){
			
		}
	});
});
function delPatient(id,n){
	if(confirm("确认删除"+n+"?")){
		$("#loadgif").show();
		$.ajax({
			type:"post",
			url:"<%=path%>nurse/delPatient.handle",
			dataType:"text",
			data:{'id':id},
			success:function(retData){
				if(retData=="1"){
					alert("删除成功");
					location.href='<%=path%>nurse/getList.handle';
				}
			},
			error:function(){
				alert('服务器无响应');
			}
		});
		$("#loadgif").hide();
	}
	
}

function upPatient(combo,name,sex,age,ID,phone,id){
	document.getElementById('upComboName').value=combo;
	document.getElementById('upName').value=name;
	document.getElementById('upSex').value=sex;
	document.getElementById('upAge').value=age;
	document.getElementById('upID').value=ID;
	document.getElementById('upPhone').value=phone;
	document.getElementById('count').value=id;
    layer.open({ 
		type: 1,
        title: '修改人员',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#updateDialog'),
		btn:['提交','取消'],
		yes: function(index, layero){
			var a = document.getElementById('upAge').value;
			var i =document.getElementById('upID').value;
			var p =document.getElementById('upPhone').value;
			if(parseInt(a)<16||parseInt(a)>150){
				layer.alert('年龄错误!',{title: '提示框',icon:0,});
			}else if(i.length>18||i.length<18){
				layer.alert('身份证错误!',{title: '提示框',icon:0,});
			}else if(p.length<11||p.length>11){
				layer.alert('手机号码错误!',{title: '提示框',icon:0,});
			}else if($("#upComboName").val()==""
				 ||$("#upName").val()==""
				 ||$("#upSex").val()==""
				 ||$("#upAge").val()==""
				 ||$("#upID").val()==""
			     ||$("#upPhone").val()==""){ 
				layer.alert('不能为空!',{title: '提示框',icon:0,});
				return false;
			}else{
				var aaa = document.getElementById("updateP");
				aaa.submit();		  
			} 
		}
    })
}

function allOpen(fid){
	var s = confirm("确定生成吗？");
	if(s){
		$.ajax({
			type:"post",
			dataType:"text",
			url:"<%=path%>nurse/allOpen.handle?fid="+fid,
			success:function(retData){
				if(retData=="1"){
					location.href="<%=path%>nurse/getFileList.handle";
					alert("生成成功");
				}else{
					alert("生成失败");
				}
			},
			error:function(){
				alert('服务器无响应');
			}
		});
	}
}

$(function(){
	$('#patientTable').DataTable();
	$('#addDialog').dialog({
		 autoOpen: false,
	      show: {
	        effect: "blind",
	        duration: 1000
	      },
	      hide: {
	        effect: "explode",
	        duration: 1000
	      }
	});
});

$(function(){
	$('#comboName').on('blur',function(){
		var comboName = document.getElementById('combo').value;
		$.ajax({
			type:"post",
			url:"<%=path%>company/queryCombo.handle?comboName="+comboName,
			dataType:"text",
			success:function(retData){
				if(retData=="1"){
					alert("生成成功");
				}else if(retData=="0"){
					alert("生成失败");
				}
				location.href="<%=path%>nurse/getBillerNoPay.handle";
			},
			error:function(){
				alert("服务器无响应");
			}
		});
	});
});
</script>
</html>