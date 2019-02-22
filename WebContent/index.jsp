<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>体检中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>css/index.css" rel="stylesheet" media="all" />
<link rel="stylesheet" href="<%=path%>css/bjqs.css">
<script src="<%=path%>js/jquery-1.7.2.min.js"></script>
<script src="<%=path%>js/bjqs-1.3.js"></script>
<script src="<%=path%>js/jquery.secret-source.min.js"></script>
<script>
	jQuery(function($) {

		$('.secret-source').secretSource({
			includeTag : false
		});

	});
</script>
<script class="secret-source">
	jQuery(document).ready(function($) {

		$('#banner-fade').bjqs({
			height : 400,
			width : 1000,
			responsive : true
		});

	});
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="clear"></div>
	<div class="body-content">
		<div class="wrap">
			<div class="slider">
				<div id="container">
					<jsp:include page="carousel.jsp" />
				</div>
			</div>
			<div class="content-main">
				<div class="grid-a">
					<ul>
						<li><img src="<%=path%>image/index1/pic1.jpg" alt=""></li>
						<li><h5>医疗器械</h5></li>
						<li><p>我院医疗设备均来自最尖端产品线，除了拥有德国西门子1.5T核磁共振、热断层扫描系统(TTM)外，还包括东芝数字DR拍片仪、东芝数字肠胃机、GE lunar bravoX光双能骨密度、RC-NW300无散瞳眼底照相机和以色列飞顿激光治疗仪等仪器。</p></li>
					</ul>
<!-- 					<div class="rd-more"> -->
<!-- 						<a href="">更多</a> -->
<!-- 					</div> -->
				</div>
				<div class="grid-a">
					<ul>
						<li><img src="<%=path%>image/index1/pic2.jpg" alt=""></li>
						<li><h5>新技术</h5></li>
						<li><p>热断层扫描系统TTM（Therml texture maps热断层扫描技术）是以细胞代谢热医学为基础的功能影像技术。是目前世界上唯一一种能够对人体无损伤、无辐射、绿色、原位观察体内细胞群活性，细胞群与细胞群之间的关系为基础的全新医学学科</p></li>
					</ul>
<!-- 					<div class="rd-more"> -->
<!-- 						<a href="">更多</a> -->
<!-- 					</div> -->
				</div>
				<div class="grid-a">
					<ul>
						<li><img src="<%=path%>image/index1/pic3.jpg" alt=""></li>
						<li><h5>服务</h5></li>
						<li><p>本院在全面检查的基础上，对生理、心理状况进行综合分析。体检项目的设置合理、体检流程的清晰明确、体检环节全程导检、能与医生交流咨询、现场答疑和体检指导、体检结果的解释和分析，各个体检环节都能使受检者把体检过程看成为一种享受。</p></li>
					</ul>
<!-- 					<div class="rd-more"> -->
<!-- 						<a href="">更多</a> -->
<!-- 					</div> -->
				</div>
				<div class="grid-r">
					<ul>
						<li><img src="<%=path%>image/index1/pic4.jpg" alt=""></li>
						<li><h5>特色项目</h5></li>
						<li><p>肝功能全套，肝功能全套又称肝功能实验，指的是蛋白质代谢功能、血清总蛋白和清蛋白比值测定、血浆凝血因子测定、血氨测定、脂类代谢功能检查、胆红素代谢检查、胆汁酸代谢检查等。乙肝患者肝功能检查多项测定值与饮食有关系，检测前需空腹。</p></li>
					</ul>
<!-- 					<div class="rd-more"> -->
<!-- 						<a href="">更多</a> -->
<!-- 					</div> -->
				</div>
				<div class="clear"></div>
			</div>
			<div class="Cont-part2">
				<div class="wrap">
					<div class="cont-left">
						<h4>最新消息</h4>
						<div class="grid-left">
							<div class="date">
								<img src="<%=path%>images/news.png" alt="" style="width:75px;height:62px;">
							</div>
							<div class="nav-cont">
								<ul>
									<li><h6>${news1.title }</h6></li>
									<li><span>${news1.time }</span></li>
								</ul>
							</div>
							<div class="clear"></div>
							<p>${news1.info }</p>
						</div>
						<div class="grid-left">
							<div class="date">
								<img src="<%=path%>images/news.png" alt="" style="width:75px;height:62px;">
							</div>
							<div class="nav-cont">
								<ul>
									<li><h6>${news2.title }</h6></li>
									<li><span>${news2.time }</span></li>
								</ul>
							</div>
							<div class="clear"></div>
							<p>${news2.info }</p>
						</div>
					</div>
					<div class="cont-right">
						<h4>企业团检采购</h4>
						<div class="cont-pic">
							<img src="<%=path%>image/index1/pic5.jpg" alt="">
						</div>
						<div class="cont-para">
							<p class="p1">渠道销售经理-陈田祥 Jan 20.12.12</p>
							<p>
								电话：13715329416 <br>
								邮箱：maxiaoqian@topsky.com.cn
							</p>
						</div>
						<div class="clear"></div>
						<div class="cont-p">
							<div class="cont-pic1">
								<img src="<%=path%>image/index1/pic6.jpg" alt="">
							</div>
							<div class="cont-para">
								<p class="p1">渠道销售助理-曾少聪 Feb 27.12.12</p>
								<p>电话： 15816329421 <br>
								         邮箱：418337024@qq.com</p>
							</div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<jsp:include page="foot.jsp" />
</body>
</html>
