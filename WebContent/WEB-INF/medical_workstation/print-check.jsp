<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
<link rel="stylesheet" href="<%=path%>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path%>css/style.css" />
<script src="<%=path%>js/jquery-1.8.3.min.js"></script>
<title>体检报告打印</title>
</head>

<body>
<input type="button" value="全部打印" onclick="pAll();"/>
	<c:forEach items="${checkMap }" var="c" varStatus="s">
	<!-- abegin -->
	<!-- begin -->
	<div style="width:600px; margin:10px auto;">
		<div style="display: inline;">
			<div style="float: left">
				<span>传一体检中心</span>
			</div>
			<div style="float: right">
				<span>体检日期：${ctime }</span>
			</div>
			<div style="clear: both;"></div>
		</div>
		<hr />
		<div>
			<span style="padding: 40px;">姓名：${c.key }</span>
			<c:forEach items="${c.value }" var="v" end="${exitId }">
				<span style="padding: 10px;">性别：${v.sex }</span>
				<span style="padding: 10px;">年龄：${v.age }</span>
				<span style="padding: 5px;">体检序号：${s.count }</span>
				<span style="padding: 30px;">体检码：${v.check_num }</span>
				<c:if test="1=1">
					<c:set var="exitId" value="0"></c:set>
				</c:if>
			</c:forEach>
		</div>
		<hr />
		<span>体检项目信息列表：</span>
		<div style="width:95%;margin:0 auto;">
		<table width="600" border="0">
			<tr>
				<th width="150">检查科室</th>
				<th width="150">项目名</th>
				<th width="150">细项检查</th>
				<th width="150">医生签名</th>
			</tr>
			<c:forEach items="${c.value }" var="v">
				<tr>
					<td>${v.prname }</td>
					<td>${v.pname }</td>
					<td>${v.dname }</td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
		</div>
		<!-- end -->
		<div style="page-break-after: always;"></div>
		<input type="button" value="打印" onclick="preview(${s.count });"/>
		<hr />
		<br />
		<br />
		<br />
	</div>
	</c:forEach>
	<!-- aend -->
</body>
<script type="text/javascript">

function pAll(){
	bdhtml=window.document.body.innerHTML;//获取当前页的html代码 
	sprnstr="<!-- abegin -->";//设置打印开始区域 
	eprnstr="<!-- aend -->";//设置打印结束区域 
	prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)); //从开始代码向后取html 
	prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html 
	
	var reg = new RegExp("<input type=\"button\" value=\"打印\" onclick=\"preview((.*?));\">	","g");
	
	prnhtml=prnhtml.replace(reg,"");
	window.document.body.innerHTML=prnhtml; 
 	window.print(); 	
	window.document.body.innerHTML=bdhtml; 
}

function preview(k) { 
	bdhtml=window.document.body.innerHTML;//获取当前页的html代码 
	sprnstr="<!-- begin -->";//设置打印开始区域 
	eprnstr="<!-- end -->";//设置打印结束区域 
	prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)); //从开始代码向后取html 
	prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html 
	window.document.body.innerHTML=prnhtml; 
 	window.print(); 
	window.document.body.innerHTML=bdhtml; 
}

</script>
</html>