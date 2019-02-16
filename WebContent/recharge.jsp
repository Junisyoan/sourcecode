<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>充值</title>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
</head>
<body>
		<form action="<%=path%>alipay.trade.page.pay.jsp" method="post" onsubmit="return check11();">
			<input type="text" id="m" name="WIDtotal_amount"/>
			<div style="display:none">
				<input type="text" id="subject" name="WIDsubject"/>
				<input type="text" id="sNow" name="WIDout_trade_no"/>
				<input type="text" id="WIDbody" name="WIDbody"/>
			</div>
			<input type="submit" value="充值" />
		</form>
</body>
<script type="text/javascript">

function check11(){
	var m =document.getElementById('m').value;
	var s = false;
	if(m==""){
		return s;
	}else if(m<0||m==0){
		alert('不能充值小于0！');
		return s;
	}else if(m>0){
		var vNow = new Date();
		var sNow = "";
		sNow += String(vNow.getFullYear());
		sNow += String(vNow.getMonth() + 1);
		sNow += String(vNow.getDate());
		sNow += String(vNow.getHours());
		sNow += String(vNow.getMinutes());
		sNow += String(vNow.getSeconds());
		sNow += String(vNow.getMilliseconds());
		document.getElementById("sNow").value =  sNow;
		document.getElementById("subject").value =  '充值';
		document.getElementById("WIDbody").value =  '充值';
		return true;
	}
	
}
</script>
</html>