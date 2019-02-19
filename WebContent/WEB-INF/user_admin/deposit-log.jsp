<%@ page language="java" import="java.util.*"
	contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
 <![endif]-->
<link rel="stylesheet" href="<%=path%>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path%>css/style.css" />
<script src="<%=path%>js/jquery-1.8.3.min.js"></script>
<script src="<%=path %>js/jquery.dataTables.min.js"></script>
<script src="<%=path %>js/datatables.bootstrap.min.js"></script>
<script src="<%=path%>js/jquery-ui.1.12.1.js"></script>
<title>资金明细</title>
</head>

<body>
	<div class="Manager_style">
		<div class="title_name">充值</div>
		<button id="get" class="btn btn-info" onclick="javascript:$('#recharge').dialog('open');" >充值</button>
		<button type="button" class="btn btn-primary" onclick="tableToExcel('depositTable','data');">导出Excel</button>
		余额：${userCompany.deposit }
	</div>
	<div class="Manager_style">
		<span class="title_name">金额明细</span>
		<table id="depositTable" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>具体操作</th>
					<th>金额</th>
					<th>操作时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${logList}" var="l" varStatus="s">
					<tr>
						<td>${s.count}</td>
						<td>${l.operate}</td>
						<td>${l.money }</td>
						<td>${l.time}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div style="display:none" id="recharge" align="center">
		<br/>
		<form id="r" action="<%=path%>alipay.trade.page.pay.jsp" method="post" onsubmit="return check11();" target= "_blank">
			<input type="text" id="m" name="WIDtotal_amount"/>
			<div style="display:none">
				<input type="text" id="subject" name="WIDsubject"/>
				<input type="text" id="sNow" name="WIDout_trade_no"/>
				<input type="text" id="WIDbody" name="WIDbody"/>
			</div>
			<button id="cz" class="btn btn-info">充值</button>
<!-- 			<input class="btn btn-info" type="submit" value="充值" /> -->
		</form>
	</div>
	
</body>

<script type="text/javascript">

function check11(){
	var m =document.getElementById('m').value;
	var s = false;
	if(m==""){
		return s;
	}else if(isNaN(m)){
		alert('请输入正确金额！');
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

<script type="text/javascript">
	function base64(content) {
		return window.btoa(unescape(encodeURIComponent(content)));
	}
	/*
	 *@tableId: table的Id
	 *@fileName: 要生成excel文件的名字（不包括后缀，可随意填写）
	 */
	function tableToExcel(tableID, fileName) {
		var table = document.getElementById(tableID);
		var excelContent = table.innerHTML;
		var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
		excelFile += "<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head>";
		excelFile += "<body><table>";
		excelFile += excelContent;
		excelFile += "</table></body>";
		excelFile += "</html>";
		var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
		var a = document.createElement("a");
		a.download = fileName + ".xls";
		a.href = link;
		a.click();
	}
</script>

<script type="text/javascript">

$(function(){
	$('#recharge').dialog({
		 autoOpen: false,
	      show: {
	        effect: "blind",
	        duration: 1000
	      },
	      hide: {
	        effect: "explode",
	        duration: 1000
	      }
	});
});

$(function(){
	$('#cz').click(function(){
		var f = document.getElementById('r');
		f.submit;
		$.ajax({
			url:"<%=path%>company/waitPay.handle",
			data:{'WF':'go'},
			dataType:"text",
			type:"post",
			success:function(retData){
				if(retData=="1"){
					alert('支付成功');
				}else if(retData=="0"){
					alert('未支付');
				}else if(retData=="-1"){
					alert('支付失败');
				}
				$('#recharge').dialog("close");
				location.href="<%=path%>company/getDepositDetail.handle?cid=${userCompany.company_id }";
			},
			error:function(){
				alert("服务器未响应");
			}
		});
	});
});

function getUrl(){
	window.open("<%=path%>company/getUrl.handle");
}
function recharge(){
	var m = document.getElementById("m").value;
	if(confirm("确认充值？")){
			var vNow = new Date();
			var sNow = "";
			sNow += String(vNow.getFullYear());
			sNow += String(vNow.getMonth() + 1);
			sNow += String(vNow.getDate());
			sNow += String(vNow.getHours());
			sNow += String(vNow.getMinutes());
			sNow += String(vNow.getSeconds());
			sNow += String(vNow.getMilliseconds());

			location.href='<%=path%>alipay.trade.page.pay.jsp?money='+m+'&sNow='+sNow+'&subject=充值&WIDbody=充值';
			alert();
	}
}
$(function(){
	$('#depositTable').DataTable();
});
</script>
</html>