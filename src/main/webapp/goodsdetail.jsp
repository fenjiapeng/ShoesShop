<%--
  Created by IntelliJ IDEA.
  User: fjc23
  Date: 2023/7/27
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>详情</title>
    <link type="text/css" href="css/header.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <style>
        img{
            width: 1000px;
        }
        table{
            width: 80%;
            margin-top: 15%;
            font-size: 25px;

        }
        #subm{
            width: 100%;
        }
        input[type="submit"]{
            font-size: 20px;
        }
    </style>
</head>
<body>
<div id="top_head" >
<div id="header">
    <div id="top_left">
        <img id="logo" src="./img/logo.jpg">
        <ul id="top_item">
            <li><a href="FindGoodsServlet?option=pageServlet">首页</a></li>
            <li><a>NIKE</a></li>
            <li><a>ADIDAS</a></li>
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
            <li><a href="CartServlet">购物车</a></li>
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
<table class="table">
    <form id="form" action="${pageContext.request.contextPath}/CartServlet?option=addCartItem2Cart" method="post">
<%--        隐藏--%>
        <input type="hidden" name="id" value="${goods.id}">
        <tr >
        <td rowspan="7"><img src="img/${goods.image}"></td>
    </tr>
    <tr>
        <td align="center"><h2>${goods.name}</h2></td>
    </tr>
    <tr>
        <td align="center"><h3>${goods.gdesc}</h3></td>
    </tr>
    <tr>
        <td align="center"><h3>￥${goods.price}</h3></td>
    </tr>

    <tr>
        <td align="center" >
            尺码：${goods.size}</td>
    </tr>
        <tr>
            <td align="center">
                数量： <input name="count" type="text">
            </td>
        </tr>
    <tr>
        <td align="center">
            <a href="javascript:void(0)">
            <input id="subm" type="submit" onclick="addCartItem()" style="height: 60px;line-height: 45px;font-size: 20px" class="btn btn-danger" value="加入购物车">
            </a>
        </td>
    </tr>
    </form>
</table>
</div>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>

</body>
<script>
    function addCartItem() {
        //触发表单提交时间
        //通过id获取form标签对象
       var $form = $("#form");
       $form.submit();
    }
</script>
</html>
