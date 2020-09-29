<%--
  Created by IntelliJ IDEA.
  User: 10855
  Date: 2020/3/31
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll.do">查询所有</a>
<a href="${APP_PATH}/account/findAll.do">监听器</a>
<%--<a href="${APP_PATH}/dispatcher/index.htm">index</a>--%>
<a href="${APP_PATH}/index.htm">index</a>
<jsp:forward page="/index.htm"></jsp:forward>
</body>
</html>
