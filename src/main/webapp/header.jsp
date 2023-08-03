<%--
  Created by IntelliJ IDEA.
  User: fjc23
  Date: 2023/7/31
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link type="text/css" href="css/header.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <style>
        a{
            font-size: 19px;
        }
        span{
            color: #337ab7;
            font-size: 20px;
        }
    </style>
</head>
<body>
<form>
    <div id="top_head" >
        <div id="header">
            <div id="top_left">
                <img id="logo" src="./img/logo.jpg">
                <ul id="top_item">
                    <li><a href="FindGoodsServlet">首页</a></li>
                    <li><a>NIKE</a></li>
                    <li><a href="#">ADIDAS</a></li>
                    <li><a>AIR JORDAN</a></li>
                    <li><a>NEW BALANCE</a></li>
                    <li><a>服饰</a></li>
                    <li><a href="order_info.jsp">订单</a></li>
                </ul>
            </div>
            <div id="top_right">
                <div id="searchBox">
                    <input type="text" id="search" name="search">
                    <input  id="submit" class="btn btn-default navbar-btn" type="submit" value="搜索">
                </div>
                <ul id="right-list">
                    <li><a href="cart.jsp">购物车</a></li>
                    <c:choose><c:when test="${empty user}">
                        <li><a href="login.jsp">登录</a></li>
                        <li><a href="register.jsp">注册</a></li>
                    </c:when><c:otherwise>
                        <li><a href="mycenter.jsp">${user.username}</a></li>
                        <li><a href="ExitServlet">退出</a></li>
                    </c:otherwise></c:choose>

                </ul>
            </div>
        </div>
    </div>
</form>
</body>
</html>
