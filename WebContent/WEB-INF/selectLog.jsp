<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>日志查看</title>
    <link href="<%=path%>css/manage.css" rel="stylesheet">
</head>
<body>
<form>
    <p class="head">查询条件：</p>
    <div>
        <span>日志时间：</span><input type="text"><label>至</label><input type="text">
        <input type="submit" value="查询">
    </div>
    <table>
        <tr>
            <th>序号</th>
            <th>操作人</th>
            <th>操作时间</th>
            <th>操作事项</th>
        </tr>
        <c:forEach items="${loglist}" var="l" varStatus="s">
        <tr>
            <td>${l.log_id}</td>
            <td>${l.user_id}</td>
            <td>${l.opera}</td>
            <td>${l.time}</td>
        </tr>
        </c:forEach>
    </table>
    <div class="btn">
        <input type="button" value="上一页">
        <input type="button" value="下一页">
    </div>
</form>
</body>
</html>