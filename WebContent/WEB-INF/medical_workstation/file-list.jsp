<%@ page language="java" import="java.util.*" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
 <![endif]-->
<link rel="stylesheet" href="<%=path%>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path%>css/style.css" />
<title>项目接收</title>
</head>

<body>
	<div class="page-content">
		<div class="gys_style">
			<div class="Manager_style">
				<div class="title_name">文件查询</div>
				<!-- 查询条码号 -->
				<form method="post" action="">
					<ul class="search_content clearfix">
						<li>
						<label class="lf">
							姓名<input name="name" type="text" class="text_add" />
						</label>
						<label class="lf">
							手机号<input name="phone" type="text" class="text_add" />
						</label>
						<label class="lf">
							体检时间<input name="time" type="date" class="text_add" />
						</label>
						<label class="lf">
							条码号<input name="code" type="text" class="text_add" />
						</label>
							<button type="submit" class="btn btn-primary" class="btn_search">查询</button>
						</li>
					</ul>
				</form>
			</div>
		</div>

		<div class="Manager_style">
			<span class="title_name">文件列表</span>
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>文件名</th>
						<th>文件大小</th>
						<th>上传日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listFile}" var="l" varStatus="s">
						<tr>
							<td>${s.count}</td>
							<td>${l.fname}</td>
							<td>${l.fsize}</td>
							<td>${l.ftime}</td>
							<td><a href="javascript:;" onclick="analysisExcel('${l.file_id}');">导入</a>|<a href="javascript:;" onclick="">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
function analysisExcel(file_id){
	var sure=confirm("确定导入？");
	if(sure){
		location.href="<%=path%>company/analysisExcel.handle?file_id="+file_id;
	}
	
}
</script>
</html>