<%--
  Created by IntelliJ IDEA.
  User: fjc23
  Date: 2023/8/4
  Time: 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品管理</title>
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
        <td>名称</td>
        <td>图片</td>
        <td>单价</td>
        <td>介绍</td>
        <td>库存</td>
        <td>品牌</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${good}" var="u">
        <tr align="center" id="textx">
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td><img width="50" src="img/${u.image}"></td>
            <td>${u.price}</td>
            <td>${u.gdesc}</td>
            <td>${u.stock}</td>
            <td>${u.type_id}</td>
            <td><a class="btn btn-warning" href="GoodsServlet?option=findById&id=${u.id}" >修改</a>&nbsp;
                <a class="btn btn-danger" href="GoodsServlet?option=deleteGoods&id=${u.id}">删除</a>
                <a class="btn btn-link" href="GoodsServlet?option=findImageById&id=${u.id}">图片修改</a></td>
        </tr>
    </c:forEach>
</table>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
</body>
</html>
