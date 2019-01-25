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
<title>体检报告打印</title>
<style>
input {
	border-top-style: none;
	border-right-style: none;
	border-left-style: none;
	border-bottom-style: solid;
	text-align: center;
}
</style>
</head>

<body>
	<c:forEach items="${patientlist}" var="p" varStatus="s">
		<c:if test="${s.index == 0}">
			<form action="" style="border: 1px solid #000; margin: 50px 140px;">
				<div style="float: left; margin-left: 75px;">健康体检中心</div>
				<div style="float: right; margin-right: 75px;">体检日期：${p.time}</div>
				<p>&nbsp;</p>
				<hr style="width: 1200px; color: black;">
				<p>&nbsp;</p>
				<p style="margin-left: 180px;">
					团&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;体: <input type="text"
						value="${p.n2}" disabled="disabled"
						style="width: 410px; border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
				</p>
				<p style="margin-left: 180px;">
					团体序号: <input type="text" value="XXXXXXXX" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
					体检号码： <input type="text" value="${p.check_num}" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
				</p>
				<p style="margin-left: 180px;">
					姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名: <input type="text"
						value="${p.n1}" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
					性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别： <input type="text"
						value="${p.sex}" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
				</p>
				<p style="margin-left: 180px;">
					年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄: <input type="text"
						value="${p.age}" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
					手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机： <input type="text"
						value="${p.phone}" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
				</p>
				<p style="margin-left: 230px;">
					打印时间：<input type="text" value="XXXX-XX-XX" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
				</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<h1 align="center">健康体检中心</h1>
				<h1 align="center">体检报告</h1>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
			</form>
			<form action="" style="border: 1px solid #000; margin: 50px 140px;">
				<div style="float: left; margin-left: 75px;">健康体检中心</div>
				<div style="float: right; margin-right: 75px;">体检日期：${p.time}</div>
				<p>&nbsp;</p>
				<hr style="width: 1200px;">
					<p>&nbsp;</p>
					<p style="margin-left: 90px;">尊敬的：XXX</p>
					<p style="margin-left: 120px;">感谢你来到XXXXXXXX进行健康体检！</p>
					<p style="margin-left: 120px;">为了增加您对健康体检的认识，我们在此特别向您说明，健康体检检查的目的在于及时的了解自身的健康情况，提</p>
					<p style="margin-left: 90px;">高健康环保意识，如果此次检查在正常范围内，只表示您选择的体检项目所反映的身体健康情况，由于体检手段及项目</p>
					<p style="margin-left: 90px;">所限，并不能完全排除身体潜在疾病，若有疾病症状出现，请及时到医院就医。</p>
					<p style="margin-left: 120px;">"健康是人生最宝贵的"。不良的生活习惯和行为会损坏您的健康，我们真诚希望您保持科学健康的生活方式，定期</p>
					<p style="margin-left: 90px;">
						接受健康检查，在您最需要的时候请随时与我们联系，欢迎您再次光临XXXXXXXXXX。
						<p style="margin-left: 120px;">
							祝您，健康快乐！
							<p>&nbsp;</p>
			</form>
		</c:if>
	</c:forEach>
</body>
</html>