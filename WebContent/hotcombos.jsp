<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>体检中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/index.css" rel="stylesheet" media="all" />
<link rel="stylesheet" href="<%=path%>/css/bjqs.css">
<script src="<%=path%>/js/jquery-1.7.2.min.js"></script>
<script src="<%=path%>/js/bjqs-1.3.js"></script>
<script src="<%=path%>/js/jquery.secret-source.min.js"></script>
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
				<c:forEach items="${combolist}" var="c" varStatus="s">
					<c:if test="${c.combo_id == 1}">
						<c:if test="${s.index == 0}">
							<div class="prod-grids">
								<div class="grid">
									<img src="<%=path%>image/index1/5.png"/>
									<c:forEach items="${combolist}" var="c2" varStatus="s2">
										<c:if test="${c2.combo_id == 1}">
											<c:if test="${s2.index == 0}">
												<h4>${c2.n1}&nbsp;&nbsp;&nbsp;${c2.price}</h4>
											</c:if>
											<p>（${s2.index + 1}）${c2.n2}</p>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</c:if>
					</c:if>
				</c:forEach>
				<c:forEach items="${combolist}" var="c" varStatus="s">
					<c:if test="${c.combo_id == 2}">
						<c:if test="${s.index == 3}">
							<div class="prod-grids">
								<div class="grid">
									<img src="<%=path%>image/index1/6.png"/>
									<c:forEach items="${combolist}" var="c2" varStatus="s2">
										<c:if test="${c2.combo_id == 2}">
											<c:if test="${s2.index == 3}">
												<h4>${c2.n1}&nbsp;&nbsp;&nbsp;${c2.price}</h4>
											</c:if>
											<p>（${s2.index - 2}）${c2.n2}</p>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</c:if>
					</c:if>
				</c:forEach>
				<c:forEach items="${combolist}" var="c" varStatus="s">
					<c:if test="${c.combo_id == 3}">
						<c:if test="${s.index == 6}">
							<div class="prod-grids">
								<div class="grid">
									<img src="<%=path%>image/index1/7.png"/>
									<c:forEach items="${combolist}" var="c2" varStatus="s2">
										<c:if test="${c2.combo_id == 3}">
											<c:if test="${s2.index == 6}">
												<h4>${c2.n1}&nbsp;&nbsp;&nbsp;${c2.price}</h4>
											</c:if>
											<p>（${s2.index - 5}）${c2.n2}</p>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</c:if>
					</c:if>
				</c:forEach>
				<c:forEach items="${combolist}" var="c" varStatus="s">
					<c:if test="${c.combo_id == 4}">
						<c:if test="${s.index == 9}">
							<div class="prod-grids">
								<div class="grid">
									<img src="<%=path%>image/index1/7.png"/>
									<c:forEach items="${combolist}" var="c2" varStatus="s2">
										<c:if test="${c2.combo_id == 4}">
											<c:if test="${s2.index == 9}">
												<h4>${c2.n1}&nbsp;&nbsp;&nbsp;${c2.price}</h4>
											</c:if>
											<p>（${s2.index - 8}）${c2.n2}</p>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</c:if>
					</c:if>
				</c:forEach>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
