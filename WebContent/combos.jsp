<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
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
<style type="text/css">
.box{
	float: left;
    width: 1000px;
    margin: 20px 50px;
}
</style>
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
				<div class="body-logo">
					<h3>套餐介绍：</h3>
				</div>
				<div class="box">
					<c:forEach items="${combos}" var="c" varStatus="s">
						<div class="grid-list">
							<img src="<%=path %>image/index1/${c.img}" alt="">
							<h4>${c.name}</h4>
							<p style="height: 50px;">${c.info}</p>
						</div>
					</c:forEach>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
