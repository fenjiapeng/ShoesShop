<%--
  Created by IntelliJ IDEA.
  User: fjc23
  Date: 2023/8/3
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单更新</title>
    <script src="https://cdn.staticfile.org/layui/2.5.7/layui.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <style>
        form{
            margin-left: 10%;
            margin-top: 5%;
        }
    </style>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/OrderServlet?option=updateOrders">
    id：<input type="text" readonly name="id" value="${order.id}">
    收货地址：<input type="text" name="address" value="${order.address}">
    收件人：<input type="text" name="name" value="${order.name}">
    电话：<input type="text" name="phone" value="${order.phone}">
    <input type="submit" value="更新">
</form>
</body>
</html>
