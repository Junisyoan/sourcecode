<%@ page contentType="text/html; charset=utf-8" language="java"
import="java.sql.*" errorPage=""%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<head>
<title>体检中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path %>/css/index.css" rel="stylesheet" media="all" />
<link rel="stylesheet" href="<%=path %>/css/bjqs.css">
<script src="<%=path %>/js/jquery-1.7.2.min.js"></script>
<script src="<%=path %>/js/bjqs-1.3.js"></script>
<script src="<%=path %>/js/jquery.secret-source.min.js"></script>
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
			<div class="contact">
				<div class="contact-left">
					<h3>您的联系方式</h3>
					<div class="table-form">
					<div class="contact-form">
							<form action="<%=path%>contact/msg.so"  method="post" id = "aFrom">
						<table cellspacing="8">
							<tbody>
							
								<tr>
									<td colspan="6"><input type="text" class="textbox" name="name"
										value="昵称:" onfocus="this.value = '';"
										onblur="if (this.value == '') {this.value = '昵称';}"></td>
								</tr>
								<tr>
									<td colspan="6"><input type="text" class="textbox"  name="email"
										value="邮箱:" onfocus="this.value = '';"
										onblur="if (this.value == '') {this.value = '邮箱';}"></td>
								</tr>
								<tr>
									<td colspan="6"><input type="text" class="textbox"  name="phone"
										value="电话:" onfocus="this.value = '';"
										onblur="if (this.value == '') {this.value = '电话';}"></td>
								</tr>
								<tr>
									<td colspan="6"><textarea value="留言:"  name="msg"
											onfocus="this.value = '';"
											onblur="if (this.value == '') {this.value = '留言';}">留言</textarea>
									</td>
								</tr>
							</tbody>
						</table>
<!-- 						<div class="contact-form"> -->
<!-- 							<form> -->
								<input type="submit" value="发送">
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="contact-right">
				<h3>联系地址</h3>
				<!-- 
				<div class="map">
					<iframe width="498" height="200" frameborder="0" scrolling="no"
						marginheight="0" marginwidth="0"
						src="https://map.qq.com/api/js?v=2.exp&key=YOUR_KEY"></iframe>
					<br />
					<small><a
						href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=america&amp;aq=&amp;sll=14.440706,80.001154&amp;sspn=0.039274,0.075188&amp;ie=UTF8&amp;hq=&amp;hnear=United+States&amp;ll=37.09024,-95.712891&amp;spn=32.912722,76.992187&amp;t=m&amp;z=5"
						style="color: #999; text-align: left">View Larger Map</a></small>
				</div>
				 -->
<!-- 				<div class="grids"> -->
<!-- 					<h4>公司：HuaCtxZscLxyJuan</h4><br> -->
<!-- 					<span>福建省--厦门市</span><br> -->
<!-- 					<span>软件园二期--观日路--56号楼--一层</span><br> -->
<!-- 					<span>公司座机: +400 820 8820</span><br> -->
<!-- 					<span>手机: +18054803621</span><br> -->
<!-- 					<span>传真: +1 800 889 9898</span><br> -->
<!-- 					<span>email:<a href="">810076219@qq.com</a></span> -->
<!-- 				</div> -->
			 <div class="grids"> 
					<h4>公司：${tb_contact.name} </h4><br>
					<span>${tb_contact.province}</span><br>
					<span>${tb_contact.area}</span><br>
					<span>公司座机:${tb_contact.tel}</span><br>
					<span>手机: + ${tb_contact.phone}</span><br>
					<span>传真: +1 ${tb_contact.fax}</span><br>
					<span>email:<a href="mailto:${tb_contact.email}?123">${tb_contact.email}</a></span>
				</div>
			
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
