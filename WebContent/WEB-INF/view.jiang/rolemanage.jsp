<%@ page language="java" contentType="text/html; charset=utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String path=request.getScheme()+"://"+request.getServerName()+":"
	+request.getServerPort()+request.getContextPath()+"/";	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <link href="<%=path %>assets/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="<%=path %>assets/css/font-awesome.min.css" />
  
  <link rel="stylesheet" href="<%=path %>assets/css/ace.min.css" />
  <link rel="stylesheet" href="<%=path %>css/style.css"/>
<title>角色管理</title>
<script type="text/javascript"></script>
<script src="<%=path %>js/jquery.min.js"></script>
<script src="<%=path %>js/jquery.validate.min.js"></script>
<script src="<%=path %>js/jquery.validate.cn.js"></script>
</head>

<body>
<div class="page-content">
<div class="gys_style">
 <div class="Manager_style">
    <div class="title_name">添加角色</div>
    <button type="button" class="btn btn-primary" id="Add_Product_btn">添加角色</button>
    <div class="Add_Manager_style">
    <div id="Add_Product_style" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
     <form action="<%=path%>rolemanage/addrole.handle" method="post" id="ddd" >
     <ul class="clearfix">
      <li><label class="label_name">新角色</label> <input name="name" type="text"  class="text_add" id="name"/><i style="color:#F60; ">*</i></li>
      </ul>    
   		 </form>
     </div>       
      </div>
      </div>
    </div>
    </div>
<!--     ------------ -->
<!--      <div class="Manager_style"> -->
<!-- <!--     <div class="title_name">修改角色</div> --> -->
<!-- <!--     <button type="button" class="btn btn-primary" id="updect">修改角色</button> --> -->
<!--     <div class="Add_Manager_style"> -->
<!--     <div id="Add_Product_style" style="display:none"> -->
<!--      <div class="page-content"> -->
<!--     <div class="add_user_style clearfix"> -->
<%--      <form action="<%=path%>rolemanage/updect.handle" method="post" id="ccc" > --%>
<!--      <ul class="clearfix"> -->
<!-- <!--       <li><label class="label_name">新角色</label> <input name="name" type="text"  class="text_add" id="name"/><i style="color:#F60; ">*</i></li> --> -->
<!--       </ul>     -->
<!--    		 </form> -->
<!--      </div>        -->
<!--       </div> -->
<!--       </div> -->
<!--     </div> -->
<!--     </div> -->
    
    
<!--     ----------- -->

    <div class="Manager_style">
     <span class="title_name">角色信息</span>
     <table class="table table-striped table-bordered table-hover">
      <thead>
       <tr>
        <th>序号</th>
        <th>角色</th>
        <th>操作</th>
        
       </tr>
      </thead>
      <tbody>
       <c:forEach items="${roleall}" var="u" varStatus="s">
       <tr>
        <td>${u.role_id}</td><td>${u.name}</td> 
        <td><button type="button" class="btn btn-info Product_Details">详情</button>
    
<!-- ----------------------- -->
 <div class="Manager_style">
   
      <button type="button" class="btn btn-primary" onclick="updect()"  name="${u.role_id}">修改</button>
    <div class="Add_Manager_style">
    <div id="Add_Product_styleed" style="display:none">
     <div class="page-content">
    <div class="add_user_style clearfix">
     <form action="<%=path%>rolemanage/updectrole.handle" method="post" id="ccc" >
     <ul class="clearfix">
       <li><label class="label_name">序号</label> <input name="nameed" type="text"  class="text_add" id="nameed"   /><i style="color:#F60; ">*</i></li>  
       <li><label class="label_name">新角色名称</label> <input name="newname" type="text"  class="text_add" id="newname"/><i style="color:#F60; ">*</i></li>  
      </ul>    
   		 </form>
     </div>       
      </div>
      </div>
    </div>
    </div>


<!-- ----------------- -->
    
         <button type="button" class="btn btn-warning" onclick="delectrole()" name="${u.role_id}">删除</button></td>
       </tr>
       </c:forEach> 
      </tbody>
     </table>
  
  </div> 
 </div>    
</div>

<!--添加属性样式-->
<div class="Attributes_style" id="add_Attributes_style" style="display:none">
 <input name="" type="text"  class="Attributestext" id="shuxin"/><!--<button type="button" class="btn btn-primary">添加</button>-->
</div>

		<script src="<%=path %>assets/js/jquery.min.js"></script>
		

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

	
<script src="<%=path %>assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">

$('#Add_Product_btn').on('click', function(){
    layer.open({
        type: 1,
        title: '添加角色',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Add_Product_style'),
		btn:['提交','取消'],
		yes: function(index, layero){		
		 if($("#name").val()==""){
			  layer.alert('新角色名称不能为空!',{
              title: '提示框',								
			  icon:0,			    
			 });
			return false;
               } 
	        else{	
				var aaa = document.getElementById("ddd");
		        	aaa.submit();		  
			   	
			     
		  } 
		}
    })
});
//修改角色
function updect(){
 
    layer.open({ 
        type: 1,
        title: '修改角色',
		shadeClose: true, //点击遮罩关闭层
        area: ['600px' , ''],
        content: $('#Add_Product_styleed'),
		btn:['提交','取消'],
		yes: function(index, layero){		
		 if($("#newname").val()==""){ 
			  layer.alert('修改角色名称不能为空!',{
              title: '提示框',								
			  icon:0,			    
			 });
			return false;
               } 
	        else{
	        	 
				var aaa = document.getElementById("ccc");
		        	aaa.submit();		  
			   	
			     
		  } 
		}
    })
}
function delectrole(a){
	var a=a||event;
	var t =a.target || a.srcElement;
	var updetename=t.name;
	var re=confirm("确定刪除？");
	if(re){
			alert(updetename);
		var form = document.createElement("Form");
		form.action="<%=path%>rolemanage/delectrole.handle";
		form.method="post";
		form.style.display="none";
		
		var opupdetename= document.createElement("input");
		opupdetename.name="updetename";
		opupdetename.value=updetename;
	  
		form.appendChild(opupdetename); 
		document.body.appendChild(form);
		
		form.submit();
		
		 
		}else{
			alert("错误");
		}
	  
}

function updeterole(a){
	var a=a||event;
	var t =a.target || a.srcElement;
	var updetename=t.name;
	var re=confirm("确定修改？");
	if(re){
			alert(updetename);
		var form = document.createElement("Form");
		form.action="<%=path%>rolemanage/updectrole.handle";
		form.method="post";
		form.style.display="none";
		
		var opupdetename= document.createElement("input");
		opupdetename.name="updetename";
		opupdetename.value=updetename;
	  
		form.appendChild(opupdetename); 
		document.body.appendChild(form);
		
		form.submit();
		
		 
		}else{
			alert("错误");
		}
	  
}

</script>
</body>
</html>

  