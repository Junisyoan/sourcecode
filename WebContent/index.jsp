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
						<li><h5>自然资源</h5></li>
						<li><p>Nullam imperdiet tempus lacus, quis tempor enim
								interdum eget. In accumsan mi quis lacus pretium eleifend. Duis
								tincidunt fringilla ipsum. Cras suscipit commodo ipsum,
								facilisis tempor ligula hendrerit et. Quisque vitae orci sed
								sapien convallis pharetra.</p></li>
					</ul>
					<div class="rd-more">
						<a href="">更多</a>
					</div>
				</div>
				<div class="grid-a">
					<ul>
						<li><img src="<%=path%>image/index1/pic2.jpg" alt=""></li>
						<li><h5>新技术</h5></li>
						<li><p>Pellentesque pharetra lacus nec quam fermentum
								quis auctor ante molestie. Maecenas feugiat ante et sapien
								adipiscing ac auctor nisi ornare. Pellentesque feugiat augue ac
								magna gravida vel aliquam orci hendrerit. Nam non turpis quis
								odio pretium sodales vitae.</p></li>
					</ul>
					<div class="rd-more">
						<a href="">更多</a>
					</div>
				</div>
				<div class="grid-a">
					<ul>
						<li><img src="<%=path%>image/index1/pic3.jpg" alt=""></li>
						<li><h5>服务</h5></li>
						<li><p>Lorem ipsum dolor sit amet, consectetur adipiscing
								elit. In at metus elit, non pretium nibh. Vestibulum elementum
								rutrum arcu, eget porta sem gravida ac. Aliquam erat volutpat.
								Integer mi odio, tristique vel congue fringilla, congue quis
								eros. Fusce eu mauris vitae</p></li>
					</ul>
					<div class="rd-more">
						<a href="">更多</a>
					</div>
				</div>
				<div class="grid-r">
					<ul>
						<li><img src="<%=path%>image/index1/pic4.jpg" alt=""></li>
						<li><h5>特色项目</h5></li>
						<li><p>Cras at pellentesque leo. Vestibulum aliquet
								tempor massa sed faucibus. Donec et dui neque, vitae ullamcorper
								lacus. Praesent ornare sodales velit mattis tincidunt. Morbi
								semper turpis id elit pellentesque consequat. Suspendisse nulla
								orci, accumsan varius placerat</p></li>
					</ul>
					<div class="rd-more">
						<a href="">更多</a>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="Cont-part2">
				<div class="wrap">
					<div class="cont-left">
						<h4>最新消息</h4>
						<div class="grid-left">
							<div class="date">
								<img src="<%=path%>image/index1/date.png" alt="">
							</div>
							<div class="nav-cont">
								<ul>
									<li><h6>新闻新闻新闻新闻新闻新闻新闻新闻</h6></li>
									<li><span>2018.12.02</span></li>
								</ul>
							</div>
							<div class="clear"></div>
							<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>
						</div>
						<div class="grid-left">
							<div class="date">
								<img src="<%=path%>image/index1/date1.png" alt="">
							</div>
							<div class="nav-cont">
								<ul>
									<li><h6>新闻新闻新闻新闻新闻新闻新闻新闻新闻新</h6></li>
									<li><span>2018.12.04</span></li>
								</ul>
							</div>
							<div class="clear"></div>
							<p>新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻</p>
						</div>
					</div>
					<div class="cont-right">
						<h4>推荐</h4>
						<div class="cont-pic">
							<img src="<%=path%>image/index1/pic5.jpg" alt="">
						</div>
						<div class="cont-para">
							<p class="p1">陈田祥 Jan 20.12.12</p>
							<p>Sed nisi turpis, pellentesque at ultrices in, dapibus in
								magna. Nunc easi diam risus, placerat ut scelerisque et,
								suscipit eu ante.</p>
						</div>
						<div class="clear"></div>
						<div class="cont-p">
							<div class="cont-pic1">
								<img src="<%=path%>image/index1/pic6.jpg" alt="">
							</div>
							<div class="cont-para">
								<p class="p1">曾少聪 Feb 27.12.12</p>
								<p>Sed nisi turpis, pellentesque at ultrices in, dapibus in
									magna. Nunc easi diam risus, placerat ut scelerisque et,
									suscipit eu ante.</p>
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
