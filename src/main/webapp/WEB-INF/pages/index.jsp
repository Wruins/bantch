<%--
  Created by IntelliJ IDEA.
  User: jiran
  Date: 2021/3/21
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>登录成功</h1>
    <a href="logout">mvc退出登录</a>
    <a href=<%=request.getContextPath()%>/user/logout>退出登录</a>
</body>
</html>
