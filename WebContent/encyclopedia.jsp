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
			<div class="clear"></div>
			<div class="sidebar-1">
				<h3>为体检人员提供最准确的检查和定制项目</h3>
				<div class="grid-list">
					<img src="<%=path%>image/index1/proj-pic1.jpg" alt="">
					<h4>Vestibulum iaculis</h4>
					<p>The standard chunk of Lorem Ipsum used since the 1500s is
						reproduced below for those interested. Sections 1.10.32</p>
				</div>
				<div class="grid-list">
					<img src="<%=path%>image/index1/proj-pic2.jpg" alt="">
					<h4>Vestibulum iaculis</h4>
					<p>Qsi turpis, pellentesque at ultrices in, dapibus in magna.
						Nunc easi diam risus, placerat ut scelerisque et, sus cipit eu</p>
				</div>
				<div class="grid-list">
					<img src="<%=path%>image/index1/proj-pic3.jpg" alt="">
					<h4>Vestibulum iaculis</h4>
					<p>Nunc easi diam risus, placerat ut scelerisque et, sus cipit
						eu ante. Nullam vitae dolor ullcper felises cursus gravida.</p>
				</div>
				<div class="grid-list">
					<img src="<%=path%>image/index1/proj-pic4.jpg" alt="">
					<h4>Vestibulum iaculis</h4>
					<p>Nunc easi diam risus, placerat ut scelerisque et, sus cipit
						eu ante. Nullam vitae dolor ullcper felises cursus gravida.</p>
				</div>
				<div class="grid-list">
					<img src="<%=path%>image/index1/proj-pic5.jpg" alt="">
					<h4>Vestibulum iaculis</h4>
					<p>The standard chunk of Lorem Ipsum used since the 1500s is
						reproduced below for those interested. Sections 1.10.32</p>
				</div>
				<div class="grid-list">
					<img src="<%=path%>image/index1/proj-pic6.jpg" alt="">
					<h4>Vestibulum iaculis</h4>
					<p>Qsi turpis, pellentesque at ultrices in, dapibus in magna.
						Nunc easi diam risus, placerat ut scelerisque et, sus cipit</p>
				</div>
			</div>
		</div>
		<div class="sidebar-2">
			<h3>健康等级</h3>
			<blockquote>1957年世界卫生组织进一步表述关于健康状态为个体在一定环境、遗传条件下能够恰当地表达其行为的功能，并在1984年进一步补充健康的分级：
			</blockquote>
			<div class="grids">
				<h4>第一级健康(躯体健康):</h4>
				<p>包括无饥寒、无病弱，能够精力充沛地生活和劳动，满足基本卫生要求</p>
			</div>
			<div class="grids">
				<h4>第二级健康(身心健康):</h4>
				<p>包括满足基本的经济要求，日常生活自由</p>
			</div>
			<div class="grids">
				<h4>第三级健康(主动健康):</h4>
				<p>包括能够主动追求健康的生活方式，调节心理状态适应社会和工作的压力，过着为社会做贡献的生活方式</p>
			</div>
			<div class="clear"></div>
			<h3>recent blogs</h3>
			<div class="grid1">
				<a href="">Epsum factorial non deposit quid pro quo hic.</a><br>
				<span>Jan 29, 2011 | 3 Comments</span>
			</div>
			<div class="grid1">
				<a href="">Marquee selectus nonproisio.</a><br> <span>Feb
					13, 2013 | 3 Comments</span>
			</div>
			<div class="grid1">
				<a href="">Epsum factorial non deposit quid pro quo hic.</a><br>
				<span>July 29, 2012 | 3 Comments</span>
			</div>
			<div class="grid1">
				<a href="">Marquee selectus non</a><br> <span>Feb 28,
					2013 | 16 Comments</span>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
