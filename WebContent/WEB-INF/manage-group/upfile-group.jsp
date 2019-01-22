<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传团检表</title>
</head>
<body>
<form action="${path}company/" id="companyFile" method="post" enctype="multipart/form-data">
<input type="file" name="companyFile" />
<input type="submit" value="上传" />
</form>
</body>
</html>