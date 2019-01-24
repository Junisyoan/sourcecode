<%@ page language="java" contentType="text/html; charset=utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String path=request.getScheme()+"://"+request.getServerName()+":"
	+request.getServerPort()+request.getContextPath()+"/";	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
  <link rel="stylesheet" href="assets/css/font-awesome.min.css" />
  <!--[if IE 7]>
    <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
  <![endif]-->
  <link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
  <link rel="stylesheet" href="<%=path %>css/style.css"/>
<title>test</title>
<script type="text/javascript"></script>
<script src="<%=path %>js/jquery.min.js"></script>
<script src="<%=path %>js/jquery.validate.min.js"></script>
<script src="<%=path %>js/jquery.validate.cn.js"></script>
<!-- ------------ -->
  
 
<link href="<%=path %>css/DT_bootstrap.css" rel="stylesheet"
	media="screen">
<link rel="stylesheet" type="text/css" href="<%=path %>css/userlist.css">

<!-- ***************** -->
</head>

   

 

<body>
<div class="page-content">
<div class="gys_style">
 <div class="Manager_style">
    <div class="title_name">添加产品</div>
    <button type="button" class="btn btn-primary" id="Add_Product_btn">添加产品</button>
    <div class="Add_Manager_style">
    <div id="Add_Product_style" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
     <ul class="clearfix">
      <li><label class="label_name">产品名称</label> <input name="产品名称" type="text"  class="text_add" id="name_text"/><i style="color:#F60; ">*</i></li>
      </ul>    
        </div>       
      </div>
      </div>
    </div>
    </div>  
 </div>    
</div>
<!--  -------------------------*********** -->
 
	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="container">
		<!-- left, vertical navbar & content -->
		<div class="row">
	<div class="col-md-10">
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="text-muted bootstrap-admin-box-title">Bootstrap
								dataTables</div>
						</div>
						<div class="bootstrap-admin-panel-content">
							<table class="table table-striped table-bordered" id="example">
								<thead>
									<tr>
										<th>序号</th>
										<th>文件名</th>
										<th>文件路径</th>
										<th>上传者id</th>
										<th>状态</th>
									</tr>
								</thead>
								<tbody>
									<!-- OGNL写法 -->
									<s:iterator value="mlist" var="myfile" status="L">
										<tr>
											<td>1</td>
											<td>1</td>
											<td>1</td>
											<td>1</td>
											<td>1</td>
										</tr>
<tr>
											<td>1</td>
											<td>1</td>
											<td>1</td>
											<td>1</td>
											<td>1</td>
										</tr>
<tr>
											<td>1</td>
											<td>1</td>
											<td>1</td>
											<td>1</td>
											<td>1</td>
										</tr>
<tr>
											<td>1</td>
											<td>1</td>
											<td>1</td>
											<td>1</td>
											<td>1</td>
										</tr>
<tr>
											<td>1</td>
											<td>1</td>
											<td>1</td>
											<td>2</td>
											<td>1</td>
										</tr>
<tr>
											<td>1</td>
											<td>1</td>
											<td>6</td>
											<td>1</td>
											<td>1</td>
										</tr>
<tr>
											<td>1</td>
											<td>1</td>
											<td>1</td>
											<td>1</td>
											<td>1</td>
										</tr>

									</s:iterator>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<hr>
			<footer role="contentinfo"> </footer>
		</div>
	</div>

	<script type="text/javascript" src="<%=path %>js/jquery-2.0.3.min.js"></script>
<!-- 	<script type="text/javascript" -->
<!-- 		src="js/twitter-bootstrap-hover-dropdown.min.js"></script> -->
	<script type="text/javascript"
		src="<%=path %>js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="<%=path %>js/DT_bootstrap.js"></script>
 
<!--  -***********************---------------- -->
<!--添加属性样式-->
<div class="Attributes_style" id="add_Attributes_style" style="display:none">
 <input name="" type="text"  class="Attributestext" id="shuxin"/><!--<button type="button" class="btn btn-primary">添加</button>-->
</div>

 
		<script src="assets/js/jquery.min.js"></script>
		 
		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		 
<script src="assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">


$('#Add_Product_btn').on('click', function(){
    layer.open({
        type: 1,
        title: '添加/修噶产品',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Add_Product_style'),
		btn:['提交','取消'],
		yes: function(index, layero){		
		 if($("#name_text").val()==""){
			  layer.alert('产品名称不能为空!',{
              title: '提示框',								
			  icon:0,			    
			 });
			return false;
               } 
	        else{			  
			  layer.alert('添加成功！',{
               title: '提示框',				
			   icon:1,		
			  }); 
			  layer.close(index);      
		  } 
		}
    })
});
</script>
</body>
</html>
 
 