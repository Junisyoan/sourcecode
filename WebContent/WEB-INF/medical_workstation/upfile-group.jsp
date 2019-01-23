<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传团检表</title>
</head>
<body>
<form action="${path}company/fileUpload.handle" id="companyFile" method="post" enctype="multipart/form-data">
<input type="file" name="companyFile" />
<input type="submit" value="上传" />
</form>


<a href="${path}XX公司团检表.xls">下载文档模板</a>
</body>
</html>