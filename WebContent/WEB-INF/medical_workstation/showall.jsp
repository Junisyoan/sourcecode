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
				<div style="float: left; margin-left: 75px;">
					<h3>健康体检中心</h3>
				</div>
				<div style="float: right; margin-right: 75px;">
					<h3>体检日期：${p.time}</h3>
				</div>
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
				<div style="float: left; margin-left: 75px;">
					<h3>健康体检中心</h3>
				</div>
				<div style="float: right; margin-right: 75px;">
					<h3>体检日期：${p.time}</h3>
				</div>
				<p>&nbsp;</p>
				<hr style="width: 1200px;">
				<p>&nbsp;</p>
				<p style="margin-left: 90px;">尊敬的：${p.n1}</p>
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
			<form action="" style="border: 1px solid #000; margin: 50px 140px;">
				<div style="float: left; margin-left: 75px;">
					<h3>健康体检中心</h3>
				</div>
				<div style="float: right; margin-right: 75px;">
					<h3>体检日期：${p.time}</h3>
				</div>
				<p>&nbsp;</p>
				<hr style="width: 1200px;">
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
				</div>
			</form>
			<form action="" style="border: 1px solid #000; margin: 50px 140px;">
				<div style="float: left; margin-left: 75px;">
					<h3>健康体检中心</h3>
				</div>
				<div style="float: right; margin-right: 75px;">
					<h3>体检日期：${p.time}</h3>
				</div>
				<p>&nbsp;</p>
				<hr style="width: 1200px;">
				<p>&nbsp;</p>
				<h3 style="margin-left: 80px;">体检总结及建议</h3>
				<p style="margin-left: 80px;">【综述】</p>
				<c:forEach items="${patientlist3}" var="p3" varStatus="s3">
					<p style="margin-left: 100px;">${p3.n3}:${p3.resulttext}${p3.unit}</p>
				</c:forEach>
				<p style="margin-left: 80px;">【建议】</p>
				<c:forEach items="${patientlist4}" var="p4" varStatus="s4">
					<p style="margin-left: 100px;">（${s4.index + 1}）${p4.guide}</p>
				</c:forEach>

				</div>
			</form>
			<form action="" style="border: 1px solid #000; margin: 50px 140px;">
				<div style="float: left; margin-left: 75px;">
					<h3>健康体检中心</h3>
				</div>
				<div style="float: right; margin-right: 75px;">
					<h3>体检日期：${p.time}</h3>
				</div>
				<p>&nbsp;</p>
				<hr style="width: 1200px;">
				<p>&nbsp;</p>
				<h3 style="margin-left: 80px;">生活健康保健</h3>
				<p style="margin-left: 80px;">一、保持健康的生活方式</p>
				<p style="margin-left: 100px;">（1）健康的饮食习惯：食物多样，谷类为主；适合吃季节性蔬菜；吃适量乳类、豆类制品；吃适量新鲜有鱗鱼、蛋、瘦肉，</p>
				<p style="margin-left: 120px;">少吃肥肉和荤油；食量与活动量要平衡，监测体重，吃清淡少盐食物。</p>
				<p style="margin-left: 100px;">（2）戒烟戒酒：不但要避免吸烟也要避免被动吸烟，不饮酒或饮少量红葡萄酒。</p>
				<p style="margin-left: 100px;">（3）适量规律运动：能够预防很多慢性疾病，包括冠心病、高血压、糖尿病、骨质疏松等。</p>
				<p style="margin-left: 100px;">（4）保持心理平衡：愉悦的心情更有益于健康。</p>
				<p style="margin-left: 80px;">&nbsp;</p>
				<p style="margin-left: 80px;">二、指导</p>
				<c:forEach items="${patientlist4}" var="p4" varStatus="s4">
					<p style="margin-left: 100px;">（${s4.index + 1}）${p4.advise}</p>
				</c:forEach>
			</form>
			<form action="" style="border: 1px solid #000; margin: 50px 140px;">
				<div style="float: left; margin-left: 75px;">
					<h3>健康体检中心</h3>
				</div>
				<div style="float: right; margin-right: 75px;">
					<h3>体检日期：${p.time}</h3>
				</div>
				<p>&nbsp;</p>
				<hr style="width: 1200px;">
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
				</div>
			</form>
		</c:if>
	</c:forEach>
	<p align="center">
		<a
			href="<%=path%>patient/findpatientall.handle?name=${p.n1}&time=${p.time}">返回</a>
	</p>
</body>
</html>