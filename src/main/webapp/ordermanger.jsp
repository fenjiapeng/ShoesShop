<%--
  Created by IntelliJ IDEA.
  User: fjc23
  Date: 2023/8/4
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单管理</title>

    <script src="https://cdn.staticfile.org/layui/2.5.7/layui.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
</head>
<style>
    #user_table{
        position: absolute;
        left: 5%;
        width: 90%;
        top: 10%;
        align: center;
    }
    #textx{
        text-align: center;
        vertical-align: middle;
    }
    #add_user{
        position: absolute;
        left: 10%;
        width: 90%;
        top: 5%;
    }
</style>

<body>
<a href="manger.jsp">< 返回上一页</a>
<table id="user_table"class="table table-striped table-hover">
    <tr align="center">
        <td>编号</td>
        <td>创建时间</td>
        <td>单价</td>
        <td>支付状态</td>
        <td>地址</td>
        <td>收件人</td>
        <td>电话</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${order}" var="u">
        <tr align="center" id="textx">
            <td>${u.id}</td>
            <td>${u.ordertime}</td>
            <td>${u.total}</td>
            <td>${u.state}</td>
            <td>${u.address}</td>
            <td>${u.name}</td>
            <td>${u.phone}</td>
            <td><a class="btn btn-warning" href="OrderServlet" >修改</a>&nbsp;<a class="btn btn-danger">删除</a></td>
        </tr>
    </c:forEach>
</table>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
</body>
</html>
