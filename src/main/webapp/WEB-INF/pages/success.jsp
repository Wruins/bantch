<%--
  Created by IntelliJ IDEA.
  User: Rowan
  Date: 2021/3/20
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>springmvc环境测试成功</h2>



    ${account.name}

<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>money</th>
    </tr>
<c:forEach items="${accounts}" var="account">
    <tr>
        <th> ${account.id} </th>
        <th> ${account.name} </th>
        <th> ${account.money} </th>
    </tr>
</c:forEach>
</table>
</body>
</html>
