<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<p align="center">
					<img src="<%=path%>image/index1/pic7.jpg" alt="">
				</p>
				<div class="clear"></div>
				<div class="para">
				<p>&nbsp;</p>
				<blockquote
					style="text-indent: 25px; font-size: 15px; line-height: 1.0;">传一团检体检中心引入国际先进的健康管理理念，优势在于强大的医疗资源，覆盖全国的连锁布局以及特色健康、医疗产品。集团以全国连锁的体检及医疗中心、先进的IT技术平台及完善的客户体系，为企业开展一流的健康管理服务。健康体检是传一团检体检中心的核心业务，专业化的医师团队，规范化的操作标准，国际化的体检设备，信息化的体检管理，个性化的体检套餐，都为体检业务的成功开展奠定了坚实基础。传一团检体检中心专注于企业综合健康服务、利用自身技术优势，结合信息支撑系统为保险公司、金融行业和医疗机构提供第三方健康管理服务及客户关系管理解决方案。</blockquote>
				</div>
				<h3>我们拥有这些</h3>
				<div class="grid-ab">
					<img src="<%=path%>image/index1/12.png" alt="">
					<p align="center">企业健康顾问&nbsp;&nbsp;一对一服务</p>
				</div>
				<div class="grid-ab">
					<img src="<%=path%>image/index1/13.png" alt="">
					<p align="center">总部直营全国统一市场价</p>
				</div>
			</div>
			<div class="about-right">
				<h3>开朗的同事们</h3>
				<div class="grids-ab">
					<img src="<%=path%>image/index1/pic11.jpg" alt="">
					<p align="center">杨医生</p>
				</div>
				<div class="grids-ab">
					<img src="<%=path%>image/index1/pic12.jpg" alt="">
					<p align="center">陈医生</p>
				</div>
				<div class="grids-ab">
					<img src="<%=path%>image/index1/pic13.jpg" alt="">
					<p align="center">曾医生</p>
				</div>
				<div class="grids-ab">
					<img src="<%=path%>image/index1/pic14.jpg" alt="">
					<p align="center">李医生</p>
				</div>
				<div class="grids-ab">
					<img src="<%=path%>image/index1/pic5.jpg" alt="">
					<p align="center">蒋医生</p>
				</div>
				<div class="grids-ab">
					<img src="<%=path%>image/index1/14.jpg" alt="">
					<p align="center">黄医生</p>
				</div>
				<div class="clear"></div>
				<div class="border1"></div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="clear"></div>
	<%@include file="foot.jsp"%>
</body>
</html>
