<%@ page contentType="text/html; charset=utf-8" language="java"
import="java.sql.*" errorPage=""%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>体检中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="./css/index.css" rel="stylesheet" media="all" />
<link rel="stylesheet" href="./css/bjqs.css">
<script src="./js/jquery-1.7.2.min.js"></script>
<script src="./js/bjqs-1.3.js"></script>
<script src="./js/jquery.secret-source.min.js"></script>
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
					<img src="./image/index1/proj-pic1.jpg" alt="">
					<h4>Vestibulum iaculis</h4>
					<p>The standard chunk of Lorem Ipsum used since the 1500s is
						reproduced below for those interested. Sections 1.10.32</p>
				</div>
				<div class="grid-list">
					<img src="./image/index1/proj-pic2.jpg" alt="">
					<h4>Vestibulum iaculis</h4>
					<p>Qsi turpis, pellentesque at ultrices in, dapibus in magna.
						Nunc easi diam risus, placerat ut scelerisque et, sus cipit eu</p>
				</div>
				<div class="grid-list">
					<img src="./image/index1/proj-pic3.jpg" alt="">
					<h4>Vestibulum iaculis</h4>
					<p>Nunc easi diam risus, placerat ut scelerisque et, sus cipit
						eu ante. Nullam vitae dolor ullcper felises cursus gravida.</p>
				</div>
				<div class="grid-list">
					<img src="./image/index1/proj-pic4.jpg" alt="">
					<h4>Vestibulum iaculis</h4>
					<p>Nunc easi diam risus, placerat ut scelerisque et, sus cipit
						eu ante. Nullam vitae dolor ullcper felises cursus gravida.</p>
				</div>
				<div class="grid-list">
					<img src="./image/index1/proj-pic5.jpg" alt="">
					<h4>Vestibulum iaculis</h4>
					<p>The standard chunk of Lorem Ipsum used since the 1500s is
						reproduced below for those interested. Sections 1.10.32</p>
				</div>
				<div class="grid-list">
					<img src="./image/index1/proj-pic6.jpg" alt="">
					<h4>Vestibulum iaculis</h4>
					<p>Qsi turpis, pellentesque at ultrices in, dapibus in magna.
						Nunc easi diam risus, placerat ut scelerisque et, sus cipit</p>
				</div>
			</div>
		</div>
		<div class="sidebar-2">
			<h3>推荐项目</h3>
			<div class="grids">
				<h4>ProjectName 01</h4>
				<p>Qsi turpis, pellentesque at ultrices pellentesque at ultrices
					in, dapibus in magna. Nunc easi diam risus, placerat ut scelerisque
					et, sus cipit eu ante. Nullam vitae dolor ullcper felises cursus
					gravida. Cras felis elit, pellentesqi amet.</p>
			</div>
			<div class="grids">
				<h4>ProjectName 02</h4>
				<p>Qsi turpis, pellentesque at ultrices in, pellentesque at
					ultrices in, pellentesque at ultrices in, dapibus in magna. Nunc
					easi diam risus, placerat ut scelerisque et, sus cipit eu ante.
					Nullam vitae dolor ullcper felises cursus gravida. Cras felis elit,
					pellentesqi amet.</p>
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
