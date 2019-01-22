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
  <link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" />
  <!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
  <link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
  <link rel="stylesheet" href="<%=path %>css/style.css"/>
<title>已响应询价</title>
</head>

<body>
<div class="page-content">
<h3 class="header smaller lighter blue">${projectname }</h3>
      <div class="search_style">
   <div class="title_names">搜索查询</div>
      <ul class="search_content clearfix">
       <li><label class="lf">项目名称</label><input name="项目名称" type="text"  class="text_add"/></li>
       <li><label class="lf">订单编号</label><input name="订单编号" type="text"  class="text_add"/></li>
       <li><label class="lf">报价截止时间</label><input name="报价截止时间" class="inline laydate-icon" id="start" style=" margin-left:10px;"></li>
       <li style="width:90px;"><button id="btn_search" type="button" class="btn_search">查询</button></li>
      </ul>
    </div>
  <div class="">
  <table id="" class="table table-striped table-bordered table-hover">
   <thead>
    <tr><th>序号</th><th>项目名称</th><th>项目编号</th><th>预计加油时间</th><th>加油地点</th><th>报价截止时间</th><th>总报价</th><th>操作</th></tr>
   </thead>
   <tbody>
    <tr>
     <td>1</td>
     <td>项目名称叫什么</td>
     <td>H434534534</td><td>2016-04-21</td><td>南京码头</td><td>2016-04-12 10:00</td><td>34554</td><td><a href="供应商报价.html" class="btn btn-primary gys_bz">修改</a></td>
     </tr>
      
   </tbody>
  </table>
 <iframe style="border:0; width:100%; background-color:#FFF;"  frameborder="0" src="page.html"></iframe>
  </div>
 </div>
	<!--[if !IE]> -->
		<script src="<%=path %>assets/js/jquery.min.js"></script>
		<!-- <![endif]-->
		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=path %>assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=path %>assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
<script src="<%=path %>assets/js/bootstrap.min.js"></script>
<script src="<%=path %>assets/layer/layer.js" type="text/javascript" ></script>
<script src="<%=path %>assets/laydate/laydate.js" type="text/javascript"></script>
<script type="text/javascript">
 //弹出一个iframe层

//$('.gys_bz').on('click', function(){
//    layer.open({
//        type: 2,
//        title: '供应商项目报价',
//        maxmin: true,
//        shadeClose: true, //点击遮罩关闭层
//        area : ['980px' , '400px'],
//        content: '供应商报价.html'
//    });
//});

laydate({
    elem: '#start',
    event: 'focus' 
});
/***判断用户添加文本**/
 jQuery(document).ready(function(){  
 
  $("#btn_search").click(function(){
	// var num=0;
     var str="";
     $("input[type$='text'],select").each(function(n){
          if($(this).val()=="")
          {
              // num++;
			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
                title: '提示框',				
				icon:0,				
          }); 
             // layer.msg(str+=""+$(this).attr("name")+"不能为空！\r\n");
             layer.close(index);
          }
		  
     });
    
});
 });
</script>
</body>
</html>