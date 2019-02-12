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
<title>项目小结</title>

        <script type="text/javascript">            
            //判断浏览器是否支持FileReader接口
            if (typeof FileReader == 'undefined') {
                document.getElementById("xmTanDiv").InnerHTML = "<h1>当前浏览器不支持FileReader接口</h1>";
                //使选择控件不可操作
                document.getElementById("file").setAttribute("disabled", "disabled");
            }

            //选择图片，马上预览
            function xmTanUploadImg(obj) {
                var file = obj.files[0];
                
                console.log(obj);console.log(file);
                console.log("file.size = " + file.size);  //file.size 单位为byte

                var reader = new FileReader();

                //读取文件过程方法
                reader.onloadstart = function (e) {
                    console.log("开始读取....");
                }
                reader.onprogress = function (e) {
                    console.log("正在读取中....");
                }
                reader.onabort = function (e) {
                    console.log("中断读取....");
                }
                reader.onerror = function (e) {
                    console.log("读取异常....");
                }
                reader.onload = function (e) {
                    console.log("成功读取....");

                    var img = document.getElementById("xmTanImg");
                    img.src = e.target.result;
                    //或者 img.src = this.result;  //e.target == this
                }

                reader.readAsDataURL(file)
            }
        </script>


</head>
<body>



<div class="page-content">
<h3 class="header smaller lighter blue">
	<div style="float:left">${projectname }</div>
	<div style="float:right">${keshi }</div>
</h3>
  <div class="">
  
  <table id="" class="table table-striped table-bordered table-hover">
     <c:if test="${keshi=='常规检查室' }">
  
   <thead>
    <tr><th>序号</th><th>项目名称</th><th>单位</th><th>结果</th><th>操作</th></tr>
   </thead>
   <tbody>
   <c:forEach items="${dlist }" var="d" varStatus="s">
		<tr>
			<c:if test="${d.type=='普通' && d.project_id==projectid}">
				<td>${s.index + 1}</td>
				<td>${d.name}</td>
				<td>${d.unit}</td>
				
				<c:if test="${d.sstate=='未提交' }">
				<td><input type="text" name="data" id="${d.name}" /></td>
				<td class="center">
				
				<a href="javascript:;" onclick="location ='<%=path %>brief/normal.handle?result='+document.getElementById('${d.name}').value+'&id='+${d.brief_id};">
					<button type="button" class="btn btn-primary" onclick="return confirm('确定提交么？');">提交</button>
				</a>
				</td>
				</c:if> 
				<c:if test="${d.sstate=='已提交' }">
				<td>${d.resulttext}</td>
				<td class="center">
					已提交
				</td>
				</c:if> 
			</c:if> 
		</tr>
	</c:forEach>
  </tbody>

 

  </c:if>
  
  <c:if test="${keshi=='彩超室' }">
  
   <thead>
    <tr><th>序号</th><th>项目名称</th><th>影像</th><th>结果描述</th><th>操作</th></tr>
   </thead>
   <tbody>
   
   <c:forEach items="${dlist }" var="d" varStatus="s">
		<tr>
			<c:if test="${d.type=='彩超' && d.project_id==projectid}">
				<td>${s.index + 1}</td>
				<td>${d.name}</td>
				
  				<form method="post" action="<%=path %>brief/photoUpload.handle" enctype="multipart/form-data">
				<c:if test="${d.sstate=='未提交' }">
					<td >
<%-- 					<input type="file" id="${d.name}" name="file" id="file" onclick="show()"/> --%>
					 <p>
                <input type="file" id="file" name="file" onchange="xmTanUploadImg(this)" accept="image/*"/>
<!--                 <input type="button" value="隐藏图片" onclick="document.getElementById('xmTanImg').style.display = 'none';"/> -->
<!--                 <input type="button" value="显示图片" onclick="document.getElementById('xmTanImg').style.display = 'block';"/> -->
            </p>
            <img id="xmTanImg" style="width:350px;height:200px"/>
            <div id="xmTanDiv"></div>
        <hr />

					
					</td>
					
					<td><textarea rows="8" id="${d.name}${d.name}" name="result"></textarea></td>
					<td class="center">
 						<a href="javascript:;" onclick="location ='<%=path %>brief/photo.handle?path='+document.getElementById('${d.name}').value+'&result='+document.getElementById('${d.name}${d.name}').value+'&id='+${d.brief_id};"> 
						<button type="submit" class="btn btn-primary" onclick="return confirm('确定提交么？');">提交</button>
						<input type="hidden" name="id" value="${d.brief_id}"/>
						</a> 
					</td>
				</c:if> 
  				</form>
				
				<c:if test="${d.sstate=='已提交' }">
					<td style="width:350px;">
					<img src="${pageContext.servletContext.contextPath}/upload/${d.resultpath}" style="width:350px;"/>
					</td>
					<td>${d.resulttext}</td>
					<td class="center">
						<lable class="btn btn-primary" >已提交</lable>
					</td>
				</c:if> 
			</c:if> 
		</tr>
	</c:forEach>
  </tbody>
 

  </c:if>
    <c:if test="${keshi=='检验室' }">
  
   <thead>
    <tr><th>序号</th><th>项目名称</th><th>单位</th><th>参考值</th><th>结果</th><th>提示</th><th>操作</th></tr>
   </thead>
   <tbody>
   
   <c:forEach items="${dlist }" var="d" varStatus="s">
		<tr>
			<c:if test="${d.type=='检验'  && d.project_id==projectid}">
				<td>${s.index + 1}</td>
				<td>${d.name}</td>
				<td>${d.unit}</td>
				<td>${d.min}-${d.max}</td>
				
				<c:if test="${d.sstate=='未提交' }">
				
				<td><input type="text" name="result" id="${d.name}" /></td>
				<td><input type="text" name="tips" id="${d.name}${d.name}"/></td>
				<td class="center">
				<a href="javascript:;" onclick="location ='<%=path %>brief/check.handle?result='+document.getElementById('${d.name}').value+'&tips='+document.getElementById('${d.name}${d.name}').value+'&id='+${d.brief_id};">
					<button type="button" class="btn btn-primary" onclick="return confirm('提交成功了哟！');">提交</button>
				</a>
				</td>
				</c:if>
				<c:if test="${d.sstate=='已提交' }">
				
				<td>${d.resulttext}</td>
				<td>${d.tips}</td>
				<td class="center">
					已提交
				</td>
				</c:if>
			</c:if> 
		</tr>
	</c:forEach>
  </tbody>
 
  </c:if>
  
  </table>
	<div style="width:100px;margin:0 auto">
		<a href="<%=path %>brief/turnback.handle"><input type="button" class="btn btn-warning" value="返回"/></a>
	</div>
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
