<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String path=request.getScheme()+"://"+request.getServerName()+":"
	+request.getServerPort()+request.getContextPath()+"/";	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="author" content="order by dede58.com" />
<title>传一体检系统</title>
<script type="text/javascript"></script>
<script src="<%=path %>js/jquery-1.8.3.min.js"></script>
<script src="<%=path %>js/jquery.validate.min.js"></script>
<script src="<%=path %>js/jquery.validate.cn.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" />
<!--[if IE 7]>
		  <link rel="stylesheet" href="<%=path %>assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
<link rel="stylesheet"
	href="<%=path %>http://fonts.useso.com/css?family=Open+Sans:400,300" />
<link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path %>assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="<%=path %>assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="<%=path %>css/style.css" />
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="<%=path %>assets/css/ace-ie.min.css" />
		<![endif]-->
<script src="<%=path %>assets/js/ace-extra.min.js"></script>
<!--[if lt IE 9]>
		<script src="<%=path %>assets/js/html5shiv.js"></script>
		<script src="<%=path %>assets/js/respond.min.js"></script>
		<![endif]-->
<!--[if !IE]> -->
<script src="<%=path %>assets/js/jquery.min.js"></script>
<!-- <![endif]-->
</head>
<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <img
						src="images/logo.png">
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->
			<div class="navbar-header pull-right" role="navigation">
				<div class="get_time">
					<span id="time"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>欢迎光临,${nurse.account }</span>
				</div>
				<ul class="nav ace-nav">
					<li><a href="javascript:void(0)" class="change_Password">修改密码</a></li>
					<li><a href="javascript:void(0)" id="Exit_system">退出系统</a></li>

				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>
			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>
				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						后台管理系统</div>
					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>
						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->
				<ul class="nav nav-list" id="nav_list">
					<li class="home"><a href="javascript:void(0)" name="<%=path%>nurse/systemhome.handle"
						class="iframeurl" title=""><i class="icon-dashboard"></i><span
							class="menu-text"> 系统首页 </span></a></li>
							
					<li><a href="#" class="dropdown-toggle"><i
							class="icon-desktop"></i><span class="menu-text">团检人员管理 </span><b
							class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li class="home"><a href="javascript:void(0)"
								name="<%=path %>nurse/queryCheckFile.handle?pageNum=1"
								title="待审核文件" class="iframeurl"><i
									class="icon-double-angle-right"></i>待审核文件</a></li>
							<li class="home"><a href="javascript:void(0)"
								name="<%=path %>nurse/getFileList.handle" title="团检表列表"
								class="iframeurl"><i class="icon-double-angle-right"></i>团检文件列表</a></li>
								
							<li class="home"><a href="javascript:void(0)"
								name="<%=path %>nurse/toRefund.handle" title="团检退费" class="iframeurl"><i
									class="icon-double-angle-right"></i>团检退费</a></li>
								

								
							<li class="home"><a href="javascript:void(0)"
								name="<%=path %>nurse/getBillerNoPay.handle" title="未结算账单"
								class="iframeurl"><i class="icon-double-angle-right"></i>未结算账单</a></li>
							
							<li class="home"><a href="javascript:void(0)"
								name="<%=path %>nurse/getNoCreateList.handle" title="未开单列表"
								class="iframeurl"><i class="icon-double-angle-right"></i>未开单记账表</a></li>
								
							<li class="home"><a href="javascript:void(0)"
								name="<%=path %>nurse/getCreateList.handle" title="已开单列表"
								class="iframeurl"><i class="icon-double-angle-right"></i>已开单列表</a></li>
						
								
							<li class="home"><a href="javascript:void(0)"
								name="<%=path%>patient/showpatient.handle" title="体检报告打印" class="iframeurl"><i
									class="icon-double-angle-right"></i>体检报告打印</a></li>
									
							
						</ul></li>
					<li><a href="#" class="dropdown-toggle"><i
							class="icon-edit"></i><span class="menu-text"> 统计查询 </span><b
							class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li class="home"><a href="javascript:void(0)"
								name="<%=path%>patient/findpatientall.handle" title="体检综合查询"
								class="iframeurl"><i class="icon-double-angle-right"></i>体检综合查询</a></li>
							<li class="home"><a href="javascript:void(0)"
								name="<%=path%>patient/findpatient.handle" title="体检人员查询"
								class="iframeurl"><i class="icon-double-angle-right"></i>体检人员查询
							</a></li>
							
							
							
							<li class="home"><a href="javascript:void(0)"
								name="<%=path%>logcompany/findalllogcompany.handle" title="团检单位对账"
								class="iframeurl"><i class="icon-double-angle-right"></i>团检单位对账
							</a></li>
						</ul></li>
				</ul>
				<!-- /.nav-list -->
				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>
				<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
			</div>
			<div class="main-content">
				<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="<%=path%>nurse/home.handle">首页</a>
						</li>
						<li class="active"><span class="Current_page"></span></li>
						<li class="active" id="parentIframe"><span
							class="parentIframe"></span></li>
					</ul>
				</div>

				<iframe id="iframe"
					style="border: 0; width: 100%; background-color: #FFF;"
					frameborder="0" src="<%=path%>nurse/systemhome.handle"> </iframe>


				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->

			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
					id="ace-settings-btn">
					<i class="icon-cog bigger-150"></i>
				</div>

				<div class="ace-settings-box" id="ace-settings-box">
					<div>
						<div class="pull-left">
							<select id="skin-colorpicker" class="hide">
								<option data-skin="default" value="#438EB9">#438EB9</option>
								<option data-skin="skin-1" value="#222A2D">#222A2D</option>
								<option data-skin="skin-2" value="#C6487E">#C6487E</option>
								<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
							</select>
						</div>
						<span>&nbsp; 选择皮肤</span>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-sidebar" /> <label class="lbl"
							for="ace-settings-sidebar"> 固定滑动条</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-rtl" /> <label class="lbl"
							for="ace-settings-rtl">切换到左边</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-add-container" /> <label class="lbl"
							for="ace-settings-add-container"> 切换窄屏 <b></b>
						</label>
					</div>
				</div>
			</div>
			<!-- /#ace-settings-container -->
		</div>
		<!-- /.main-container-inner -->

	</div>
	<!--底部样式-->

	<div class="footer_style" id="footerstyle">
		<p class="lf">版权所有：厦门市传一信息科技有限公司 闽公网安备 35020602000054号</p>
		<p class="rf">地址：厦门市思明区软件园二期观日路56号101号 邮编：361000 技术支持：黄俊彦组</p>
	</div>
	<!--修改密码样式-->
	<div class="change_Pass_style" id="change_Pass">
		<ul class="xg_style">
			<li><label class="label_name">原&nbsp;&nbsp;密&nbsp;码</label><input
				name="原密码" type="password" class="" id="password"></li>
			<li><label class="label_name">新&nbsp;&nbsp;密&nbsp;码</label><input
				name="新密码" type="password" class="" id="Nes_pas"></li>
			<li><label class="label_name">确认密码</label><input name="再次确认密码"
				type="password" class="" id="c_mew_pas"></li>

		</ul>
		<!--       <div class="center"> <button class="btn btn-primary" type="button" id="submit">确认修改</button></div>-->
	</div>
	<!-- /.main-container -->
	<!-- basic scripts -->
	<script src="<%=path %>js/jquery-1.8.3.min.js" type="text/javascript"></script>
	<!--[if !IE]> -->
	<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>
	<!-- <![endif]-->
	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->
	<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=path %>assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
	<script src="<%=path %>assets/js/bootstrap.min.js"></script>
	<script src="<%=path %>assets/js/typeahead-bs2.min.js"></script>
	<!-- page specific plugin scripts -->
	<!--[if lte IE 8]>
		  <script src="<%=path %>assets/js/excanvas.min.js"></script>
		<![endif]-->
	<!-- ace scripts -->
	<script src="<%=path%>assets/js/ace-elements.min.js"></script>
	<script src="<%=path%>assets/js/ace.min.js"></script>
	<script src="<%=path%>assets/layer/layer.js" type="text/javascript"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(document).ready(
				function() {
					//初始化宽度、高度    
					$("#main-container").height($(window).height() - 76);
					$("#iframe").height($(window).height() - 155);
					$(".sidebar").height($(window).height() - 99);
					var thisHeight = $("#nav_list").height(
							$(window).height() - 185);
					$(".submenu").height($(thisHeight).height() - 160);
					$("#nav_list").children(".submenu").css("height",
							thisHeight);

					//当文档窗口发生改变时 触发  
					$(window).resize(
							function() {
								$("#main-container").height(
										$(window).height() - 76);
								$("#iframe").height($(window).height() - 155);
								$(".sidebar").height($(window).height() - 99);
								var thisHeight = $("#nav_list").height(
										$(window).height() - 185);
								$(".submenu").height(
										$(thisHeight).height() - 160);
								$("#nav_list").children(".submenu").css(
										"height", thisHeight);
							});
					$(".iframeurl").bind(
							"click",
							function() {
								var cid = $(this).attr("name");
								var cname = $(this).attr("title");
								$("#iframe").attr("src", cid).ready();
								$("#Bcrumbs").attr("href", cid).ready();
								$(".Current_page a").attr('href', cid).ready();
								$(".Current_page").html(cname).ready();
								$("#parentIframe").html("").css("display",
										"none").ready();
							});

				});
		//jQuery( document).ready(function(){
		//	  $("#submit").click(function(){
		//	// var num=0;
		//     var str="";
		//     $("input[type$='password']").each(function(n){
		//          if($(this).val()=="")
		//          {
		//              // num++;
		//			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
		//                title: '提示框',				
		//				icon:0,				
		//          }); 
		//             // layer.msg(str+=""+$(this).attr("name")+"不能为空！\r\n");
		//             layer.close(index);
		//          }		  
		//     });    
		//})		
		//	});
		/*********************点击事件*********************/
		$(document).ready(function() {
			$('#nav_list').find('li.home').click(function() {
				$('#nav_list').find('li.home').removeClass('active');
				$(this).addClass('active');
			});

		})
		//时间设置
		function currentTime() {
			var d = new Date(), str = '';
			str += d.getFullYear() + '年';
			str += d.getMonth() + 1 + '月';
			str += d.getDate() + '日';
			str += d.getHours() + '时';
			str += d.getMinutes() + '分';
			str += d.getSeconds() + '秒';
			return str;
		}
		setInterval(function() {
			$('#time').html(currentTime)
		}, 1000);
		//修改密码
		$('.change_Password').on(
				'click',
				function() {
					layer.open({
						type : 1,
						title : '修改密码',
						area : [ '300px', '300px' ],
						shadeClose : true,
						content : $('#change_Pass'),
						btn : [ '确认修改' ],
						yes : function(index, layero) {
							if ($("#password").val() == "") {
								layer.alert('原密码不能为空!', {
									title : '提示框',
									icon : 0,

								});
								return false;
							}
							if ($("#Nes_pas").val() == "") {
								layer.alert('新密码不能为空!', {
									title : '提示框',
									icon : 0,

								});
								return false;
							}

							if ($("#c_mew_pas").val() == "") {
								layer.alert('确认新密码不能为空!', {
									title : '提示框',
									icon : 0,

								});
								return false;
							}
							if (!$("#c_mew_pas").val
									|| $("#c_mew_pas").val() != $("#Nes_pas")
											.val()) {
								layer.alert('密码不一致!', {
									title : '提示框',
									icon : 0,

								});
								return false;
							} else {
								layer.alert('修改成功！', {
									title : '提示框',
									icon : 1,
								});
								layer.close(index);
							}
						}
					});
				});
		$('#Exit_system').on('click', function() {
			layer.confirm('是否确定退出系统？', {
				btn : [ '是', '否' ]
			//按钮
			}, function() {
				location.href = "<%=path%>nurse/exit.handle";

			});
		});
		
		//在刷新或关闭时调用的事件 
		$(window).bind('beforeunload',function(){ 
			$.ajax({ 
				url:"<%=path%>nurse/exit.handle", 
				type:"post", 
				dataType:"text",
				success:function(){ 
					alert("您已退出登录"); 
				} 
			}); 
		});
	</script>
</body>
</html>

