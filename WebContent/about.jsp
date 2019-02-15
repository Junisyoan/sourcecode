<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<jsp:include page="header.jsp"></jsp:include>
	<div class="body-content">
		<div class="wrap">
			<div class="slider">
				<div id="container">
					<jsp:include page="carousel.jsp" />
				</div>
			</div>
			<div class="about-left">
				<h3>关于我们</h3>
				<div class="slider1-img">
					<img src="./image/index1/pic7.jpg" alt="">
				</div>
				<div class="slider1-para">
					<h4>Duis posuere consectetur pellentesqe Praesent justo dolor,
						lobortis quis, lobortis dignissim,</h4>
					<img src="./image/index1/pic10.jpg" alt="">
				</div>
				<div class="clear"></div>
				<div class="para">
					<p>Sed nisi turpis, Proin rhoncus varius sodales. In non
						aliquam odio dapibus magna.dapibus dapibus magna.dapibus
						magna.dapibus magna.dapibus magna.t ut scelerisque et,
						suscipitpibus magna.dapibus magna.t ut scelerisque et,
						suscipitpibus magna.dapibus magna.t ut scelerisque et, suscipit</p>
				</div>
				<div class="rd-more">
					<a href="">更多...</a>
				</div>
				<h3>我们拥有这些</h3>
				<div class="grid-ab">
					<img src="./image/index1/pic8.jpg" alt="">
					<p>Natural Resourcse</p>
					<span>Electricity, Natural Gas, Managemen</span>
				</div>
				<div class="grid-ab">
					<img src="./image/index1/pic9.jpg" alt="">
					<p>Service and products</p>
					<span>High Technologys.....</span>
				</div>
			</div>
			<div class="about-right">
				<h3>开朗的同事们</h3>
				<div class="grids-ab">
					<img src="./image/index1/pic11.jpg" alt="">
					<p>Rathod</p>
					<span>Lorem ipsum dolor sit...</span>
				</div>
				<div class="grids-ab">
					<img src="./image/index1/pic12.jpg" alt="">
					<p>corlnie beek</p>
					<span>Lorem ipsum dolor sit...</span>
				</div>
				<div class="grids-ab">
					<img src="./image/index1/pic13.jpg" alt="">
					<p>ching</p>
					<span>Lorem ipsum dolor sit...</span>
				</div>
				<div class="grids-ab">
					<img src="./image/index1/pic14.jpg" alt="">
					<p>aln smith</p>
					<span>Lorem ipsum dolor sit...</span>
				</div>
				<div class="clear"></div>
				<div class="border1"></div>
				<h3>最近的博客</h3>
				<div class="grid1">
					<a href="">Epsum factorial non deposit quid pro quo hic.</a><br>
					<span>Jan 29, 2013 | 6 Comments</span>
				</div>
				<div class="grid1">
					<a href="">Marquee selectus nonproisio.</a><br> <span>Feb
						19, 2013 | 12 Comments</span>
				</div>
				<div class="grid1">
					<a href="">Epsum factorial non deposit quid pro quo hic.</a><br>
					<span>Jan 30, 2011 | 10 Comments</span>
				</div>
				<div class="grid1">
					<a href="">Marquee selectus non</a><br> <span>Feb 28,
						2011 | 13 Comments</span>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="clear"></div>
	<%@include file="foot.jsp"%>
</body>
</html>
