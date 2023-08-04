<%--
  Created by IntelliJ IDEA.
  User: fjc23
  Date: 2023/8/2
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
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
<form id="add_user" >
    昵称：<input type="text">
    邮箱：<input type="text">
    密码：<input type="text">
    收件人：<input type="text">
    电话：<input type="text">
    地址：<input type="text">
    <input type="submit" value="新增" class="btn btn-primary">
</form>
<table id="user_table"class="table table-striped table-hover">
    <tr align="center">
        <td>编号</td>
        <td>昵称</td>
        <td>邮箱</td>
        <td>密码</td>
        <td>收件人</td>
        <td>电话</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${user}" var="u">
    <tr align="center" id="textx">
        <td>${u.id}</td>
        <td>${u.username}</td>
        <td>${u.email}</td>
        <td>${u.password}</td>
        <td>${u.name}</td>
        <td>${u.phone}</td>
        <td>${u.address}</td>
        <td><a class="btn btn-warning" href="UserMangerServlet?option=findById&id=${u.id}" >修改</a>&nbsp;<a class="btn btn-danger" href="UserMangerServlet?option=deleteUser&id=${u.id}">删除</a></td>
    </tr>
    </c:forEach>
</table>
<script src=" http//cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
</body>
</html>
