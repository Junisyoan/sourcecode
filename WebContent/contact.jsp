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
			<div class="contact">
				<div class="contact-left">
					<h3>您的联系方式</h3>
					<div class="table-form">
						<table cellspacing="8">
							<tbody>
								<tr>
									<td colspan="6"><input type="text" class="textbox"
										value="Name:" onfocus="this.value = '';"
										onblur="if (this.value == '') {this.value = 'Name';}"></td>
								</tr>
								<tr>
									<td colspan="6"><input type="text" class="textbox"
										value="Email:" onfocus="this.value = '';"
										onblur="if (this.value == '') {this.value = 'Name';}"></td>
								</tr>
								<tr>
									<td colspan="6"><input type="text" class="textbox"
										value="Phone:" onfocus="this.value = '';"
										onblur="if (this.value == '') {this.value = 'Name';}"></td>
								</tr>
								<tr>
									<td colspan="6"><textarea value="Message:"
											onfocus="this.value = '';"
											onblur="if (this.value == '') {this.value = 'Message';}">Message</textarea>
									</td>
								</tr>
								<td>
							</tbody>
						</table>
						<div class="contact-form">
							<form>
								<input type="button" value="Send">
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="contact-right">
				<h3>联系地址</h3>
				<div class="map">
					<iframe width="498" height="200" frameborder="0" scrolling="no"
						marginheight="0" marginwidth="0"
						src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=america&amp;aq=&amp;sll=14.440706,80.001154&amp;sspn=0.039274,0.075188&amp;ie=UTF8&amp;hq=&amp;hnear=United+States&amp;ll=37.09024,-95.712891&amp;spn=32.912722,76.992187&amp;t=m&amp;z=5&amp;output=embed"></iframe>
					<br />
					<small><a
						href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=america&amp;aq=&amp;sll=14.440706,80.001154&amp;sspn=0.039274,0.075188&amp;ie=UTF8&amp;hq=&amp;hnear=United+States&amp;ll=37.09024,-95.712891&amp;spn=32.912722,76.992187&amp;t=m&amp;z=5"
						style="color: #999; text-align: left">View Larger Map</a></small>
				</div>
				<div class="grids">
					<h4>The Company Name</h4>
					<span>marmora road</span><br> <span>glasgow,do4 89gr</span><br>
					<span>Freephone: +1 800 559 6580</span>?<br> <span>Telephone:
						+1 959 603 6035</span> <br> <span>FAX: +1 800 889 9898</span><br>
					<span>email:<a href="">sup.healthcare(at)com</a></span>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
