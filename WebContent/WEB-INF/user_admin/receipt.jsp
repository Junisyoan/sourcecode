<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<body>
<!-- begin -->
<div align="center">
<h3>X组体检中心</h3>
<h4>体检收费收据</h4>
</div>
<div>
<span>收费日期：</span>
<br/>
<table align="center" width="600" border="0" cellpadding="2">
	<thead>
    <tr>
    <th width="200">套餐</th>
    <th width="200">金额</th>
    </tr>
	</thead>
  <tfoot>
  	<tr>
    <td>收费员：</td>
    <td></td>
    <td></td>
    </tr>
  </tfoot>
  <tbody>
  <c:forEach items="${pList }" var="p">
  	<tr>
  	<td>${p.comboName }</td>
  	<td>${p.a }</td>
  	</tr>
  </c:forEach>
  </tbody>
</table>
<!-- end -->
<input type="button" value="打印" onclick="p();" />
</div>
<script type="text/javascript">
function p(){
	bdhtml=window.document.body.innerHTML;//	获取当前页的html代码 
	sprnstr="<!-- begin -->";//	设置打印开始区域 
	eprnstr="<!-- end -->";//	设置打印结束区域 
	prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)); //	从开始代码向后取html 
	prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//	从结束代码向前取html 
	
	window.document.body.innerHTML=prnhtml; 
 	window.print(); 	
	window.document.body.innerHTML=bdhtml; 
}

</script>
</body>
</html>