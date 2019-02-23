<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*,java.text.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String datetime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间
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
<title>体检报告预览</title>
<style>
input {
	border-top-style: none;
	border-right-style: none;
	border-left-style: none;
	border-bottom-style: solid;
	text-align: center;
}

.PageNext {
	page-break-after: always;
}
</style>
</head>
<body>
	<!-- abegin -->
	<c:forEach items="${patientlist}" var="p" varStatus="s">
		<c:if test="${s.index == 0}">
			<form action="" style="border: 1px solid #000; margin: 50px 140px;">
				<div style="float: left; margin-left: 75px;">
					<h3>健康体检中心</h3>
				</div>
				<div style="float: right; margin-right: 75px;">
					<h3>体检日期：${p.time}</h3>
				</div>
				<p>&nbsp;</p>
				<hr style="width: 1200px; color: black;" />
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<h4 style="margin-left: 160px;">
					团&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;体: <input type="text"
						value="${p.n2}" disabled="disabled"
						style="width: 410px; border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
				</h4>
				<h4 style="margin-left: 160px;">
					团体序号: <input type="text" value="${p.company_id}"
						disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
					体检号码： <input type="text" value="${p.check_num}" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
				</h4>
				<h4 style="margin-left: 160px;">
					姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名: <input type="text"
						value="${p.n1}" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
					性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别： <input type="text"
						value="${p.sex}" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
				</h4>
				<h4 style="margin-left: 160px;">
					年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄: <input type="text"
						value="${p.age}" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
					手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机： <input type="text"
						value="${p.phone}" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
				</h4>
				<h4 style="margin-left: 210px;">
					打印时间：<input type="text" value="<%=datetime%>" disabled="disabled"
						style="border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: solid; text-align: center;" />
						<img
						src="${pageContext.servletContext.contextPath}/uploadFile/${p.n2}/${p.check_num}.jpeg"
						width="180" height="50" />
				</h4>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<h1 align="center">健康体检中心</h1>
				<h1 align="center">体检报告</h1>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p style="line-height: 1.6;">&nbsp;</p>
				<h4 align="center">1</h4>
				<p>&nbsp;</p>
			</form>
			<form action="" style="border: 1px solid #000; margin: 50px 140px;">
				<div style="float: left; margin-left: 75px;">
					<h3>健康体检中心</h3>
				</div>
				<div style="float: right; margin-right: 75px;">
					<h3>体检日期：${p.time}</h3>
				</div>
				<p>&nbsp;</p>
				<hr style="width: 1200px;" />
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 17px; line-height: 1.8;">尊敬的：${p.n1}</blockquote>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 17px; line-height: 1.8;">感谢你来到HealthCare体检中心进行健康体检！</blockquote>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 17px; line-height: 1.8;">为了增加您对健康体检的认识，我们在此特别向您说明，健康体检检查的目的在于及时的了解自身的健康情况，提高健康环保意识，如果此次检查在正常范围内，只表示您选择的体检项目所反映的身体健康情况，由于体检手段及项目所限，并不能完全排除身体潜在疾病，若有疾病症状出现，请及时到医院就医。</blockquote>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 17px; line-height: 1.8;">健康的生活方式，定期接受健康检查，在您最需要的时候请随时与我们联系，欢迎您再次光临HealthCare体检中心。</blockquote>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 17px; line-height: 1.8;">祝您，健康快乐！</blockquote>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p style="line-height: 2.2;">&nbsp;</p>
				<h4 align="center">2</h4>
				<p>&nbsp;</p>
			</form>
			<form action="" style="border: 1px solid #000; margin: 50px 140px;">
				<div style="float: left; margin-left: 75px;">
					<h3>健康体检中心</h3>
				</div>
				<div style="float: right; margin-right: 75px;">
					<h3>体检日期：${p.time}</h3>
				</div>
				<p>&nbsp;</p>
				<hr style="width: 1200px;" />
				<div class="Manager_style">
					<span class="title_name">体检项目列表</span>
					<table class="table table-striped table-bordered table-hover"
						id="item">
						<thead>
							<tr>
								<th>序号</th>
								<th>体检人</th>
								<th>科室</th>
								<th>项目</th>
								<th>体检时间</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${patientlist2}" var="p2" varStatus="s2">
								<tr>
									<th>${s2.index + 1}</th>
									<th>${p2.n1}</th>
									<th>${p2.n3}</th>
									<th>${p2.n2}</th>
									<th>${p2.time}</th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<h4 align="center">3</h4>
				</div>
				<div class="PageNext"></div>
			</form>
			<form action="" style="border: 1px solid #000; margin: 50px 140px;">
				<div style="float: left; margin-left: 75px;">
					<h3>健康体检中心</h3>
				</div>
				<div style="float: right; margin-right: 75px;">
					<h3>体检日期：${p.time}</h3>
				</div>
				<p>&nbsp;</p>
				<hr style="width: 1200px;" />
				<p>&nbsp;</p>
				<h4 style="margin-left: 80px;">体检总结及建议</h4>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 15px; line-height: 1.5;">【综述】</blockquote>
				<c:forEach items="${patientlist3}" var="p3" varStatus="s3">
					<blockquote
						style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 15px; line-height: 1.5;">${p3.n2}:${p3.resulttext}${p3.unit}</blockquote>
				</c:forEach>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 15px; line-height: 1.5;">【建议】</blockquote>
				<c:forEach items="${patientlist4}" var="p4" varStatus="s4">
					<c:if test="${s4.index == 0}">
					<blockquote
						style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 15 px; line-height: 1.5;">${p4.guide}</blockquote>
					</c:if>
				</c:forEach>
				<h4 align="center">4</h4>
				<p>&nbsp;</p>
				<div class="PageNext"></div>
			</form>
			<form action="" style="border: 1px solid #000; margin: 50px 140px;">
				<div style="float: left; margin-left: 75px;">
					<h3>健康体检中心</h3>
				</div>
				<div style="float: right; margin-right: 75px;">
					<h3>体检日期：${p.time}</h3>
				</div>
				<p>&nbsp;</p>
				<hr style="width: 1200px;" />
				<p>&nbsp;</p>
				<h4 style="margin-left: 80px;">生活健康保健</h4>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 15px; line-height: 1.5;">一、保持健康的生活方式</blockquote>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 15px; line-height: 1.5;">（1）健康的饮食习惯：食物多样，谷类为主；适合吃季节性蔬菜；吃适量乳类、豆类制品；吃适量新鲜有鱗鱼、蛋、瘦肉，少吃肥肉和荤油；食量与活动量要平衡，监测体重，吃清淡少盐食物。</blockquote>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 15px; line-height: 1.5;">（2）戒烟戒酒：不但要避免吸烟也要避免被动吸烟，不饮酒或饮少量红葡萄酒。</blockquote>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 15px; line-height: 1.5;">（3）适量规律运动：能够预防很多慢性疾病，包括冠心病、高血压、糖尿病、骨质疏松等。</blockquote>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 15px; line-height: 1.5;">（4）保持心理平衡：愉悦的心情更有益于健康。</blockquote>
				<blockquote
					style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 15px; line-height: 1.5;">二、指导</blockquote>
				<c:forEach items="${patientlist4}" var="p4" varStatus="s4">
					<c:if test="${s4.index == 0}">
					<blockquote
						style="margin-left: 90px; text-indent: 25px; margin-right: 90px; font-size: 15px; line-height: 1.5;">${p4.advise}</blockquote>
					</c:if>
				</c:forEach>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<h4 align="center">5</h4>
				<p>&nbsp;</p>
				<div class="PageNext"></div>
			</form>
			<form action="" style="border: 1px solid #000; margin: 50px 140px;">
				<div style="float: left; margin-left: 75px;">
					<h3>健康体检中心</h3>
				</div>
				<div style="float: right; margin-right: 75px;">
					<h3>体检日期：${p.time}</h3>
				</div>
				<hr style="width: 1200px;" />
				<div class="Manager_style">
					<span class="title_name">体检小结信息</span>
					<table class="table table-striped table-bordered table-hover"
						id="item">
						<thead>
							<tr>
								<th>序号</th>
								<th>体检人</th>
								<th>套餐</th>
								<th>项目</th>
								<th>细项</th>
								<th>结果</th>
								<th>单位</th>
								<th>参考值</th>
								<th>体检时间</th>
								<th>体检医生</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${patientlist3}" var="p3" varStatus="s3">
								<tr>
									<th>${s3.index + 1}</th>
									<th>${p3.n1}</th>
									<th>${p3.n4}</th>
									<th>${p3.n3}</th>
									<th>${p3.n2}</th>
									<th>${p3.resulttext}</th>
									<th>${p3.unit}</th>
									<c:if test="${p3.min == null}">
										<th>${p3.min}</th>
									</c:if>
									<c:if test="${p3.min != null}">
										<th>${p3.min}~${p3.max}</th>
									</c:if>
									<th>${p3.time}</th>
									<th>${p3.n5}</th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<c:forEach items="${patientlist3}" var="p3" varStatus="s3">
						<c:if test="${p3.resultpath != null}">
							<p align="center">${p3.n3}</p>
							<p align="center">
								<img
									src="${pageContext.servletContext.contextPath}/upload/${p3.resultpath}"
									style="width: 350px;" />
							</p>
						</c:if>
					</c:forEach>
					<h4 align="center">6</h4>
				</div>
			</form>
		</c:if>
	</c:forEach>
	<!-- aend -->
	<c:forEach items="${patientlist}" var="p" varStatus="s">
		<c:if test="${s.index == 0}">
			<h3 align="center">
				<a
					href="<%=path%>patient/findpatientall.handle?name=${p.n1}&time=${p.time}"><button
						class="btn btn-info">返回</button></a>
			</h3>
		</c:if>
	</c:forEach>
	<h3 align="center">&nbsp;</h3>
</body>
</html>