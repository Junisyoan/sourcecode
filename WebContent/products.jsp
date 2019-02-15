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
			<div class="prod-main">
				<div class="body-logo">
					<h3>product names</h3>
				</div>
				<div class="prod-grids">
					<div class="grid">
						<img src="./image/index1/prod-pic1.jpg" alt="">
						<h4>product name</h4>
						<p>Sed nisi turpis, pellentesque at ultrices in, dapibus in
							magna. Nunc easi diam risus, placerat ut scelerisque et, sus
							cipit eu ante. Nullam vitae dolor ullcper felises</p>
					</div>
				</div>
				<div class="prod-grids">
					<div class="grid">
						<img src="./image/index1/prod-pic2.jpg" alt="">
						<h4>product name</h4>
						<p>Sed nisi turpis, pellentesque at ultrices in, dapibus in
							magna. Nunc easi diam risus, placerat ut scelerisque et, sus
							cipit eu ante. Nullam vitae dolor ullcper felises</p>
					</div>
				</div>
				<div class="prod-grids">
					<div class="grid">
						<img src="./image/index1/prod-pic3.jpg" alt="">
						<h4>product name</h4>
						<p>The standard chunk of Lorem Ipsum used since the 1500s is
							reproduced below for those interested. Sections 1.10.32 and
							1.10.33 from "de Finibu</p>
					</div>
				</div>
				<div class="prod-grids">
					<div class="grid">
						<img src="./image/index1/prod-pic4.jpg" alt="">
						<h4>product name</h4>
						<p>Sed nisi turpis, pellentesque at ultrices in, dapibus in
							magna. Nunc easi diam risus, placerat ut scelerisque et, sus
							cipit eu ante. Nullam vitae dolor ullcper felises</p>
					</div>
				</div>
				<div class="prod-grids">
					<div class="grid">
						<img src="./image/index1/prod-pic5.jpg" alt="">
						<h4>product name</h4>
						<p>The standard chunk of Lorem Ipsum used since the 1500s is
							reproduced below for those interested. Sections 1.10.32 and
							1.10.33 from "de Finibus Bonorum</p>
					</div>
				</div>
				<div class="prod-grids">
					<div class="grid">
						<img src="./image/index1/prod-pic6.jpg" alt="">
						<h4>product name</h4>
						<p>Sed nisi turpis, pellentesque at ultrices in, dapibus in
							magna. Nunc easi diam risus, placerat ut scelerisque et, sus
							cipit eu ante. Nullam vitae dolor ullcper felises</p>
					</div>
				</div>
				<div class="prod-grids">
					<div class="grid">
						<img src="./image/index1/prod-pic7.jpg" alt="">
						<h4>product name</h4>
						<p>The standard chunk of Lorem Ipsum used since the 1500s is
							reproduced below for those interested. Sections 1.10.32 and
							1.10.33 from "de Finibus Bonorum</p>
					</div>
				</div>
				<div class="prod-grids">
					<div class="grid">
						<img src="./image/index1/prod-pic8.jpg" alt="">
						<h4>product name</h4>
						<p>Sed nisi turpis, pellentesque at ultrices in, dapibus in
							magna. Nunc easi diam risus, placerat ut scelerisque et, sus
							cipit eu ante. Nullam vitae dolor ullcper felises</p>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
