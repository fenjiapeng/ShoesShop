<%--
  Created by IntelliJ IDEA.
  User: fjc23
  Date: 2023/7/27
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <link type="text/css" href="css/header.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <style>
        a{
            font-size: 19px;
        }
        span{
            color: #565757;
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
    <jsp:include page="activeimage.html" flush="true"></jsp:include>

<c:if test="${goods == null}">没有数据</c:if>
<c:if test="${goods != null}">
    <table class="table">

        <c:set var="n" value="1"/>
            <td colspan="3" style="border-top: none"><h1>热销</h1></td>
        <tr>
            <c:forEach items="${goods}" var="good" >
                <td align="center">
                    <a style="color: #5f5f5f" href="FindGoodsServlet?option=findById&id=${good.id}">
                    <img src="img/${good.image}"><br/>
                        ${good.name}<br/>
                        ￥${good.price}
                    </a>
                </td>
                <c:if test="${n%3==0}">
                    <tr/>
                    <tr>
                </c:if>
                <c:set var="n" value="${n+1}"/>
                    </c:forEach>
        </tr>

        <tr>
            <td style="color: #5f5f5f ">
                <a href="<c:url value='/FindGoodsServlet'>
        <c:param name='option' value='pageServlet'/>
        <c:param name='pageIndex' value='1'/>
    </c:url>">首页</a>

                <c:if test="${page.pageIndex > 1}">
                    <a href="<c:url value='/FindGoodsServlet'>
            <c:param name='option' value='pageServlet'/>
            <c:param name='pageIndex' value='${page.pageIndex - 1}'/>
        </c:url>">上一页</a>
                </c:if>

                <c:if test="${page.pageIndex == 1}">
                    <a>上一页</a>
                </c:if>

                <c:if test="${page.pageIndex < page.totalPages}">
                    <a href="<c:url value='/FindGoodsServlet'>
            <c:param name='option' value='pageServlet'/>
            <c:param name='pageIndex' value='${page.pageIndex + 1}'/>
        </c:url>">下一页</a>
                </c:if>

                <c:if test="${page.pageIndex == page.totalPages}">
                    <a>下一页</a>
                </c:if>

                <a href="<c:url value='/FindGoodsServlet'>
        <c:param name='option' value='pageServlet'/>
        <c:param name='pageIndex' value='${page.totalPages}'/>
    </c:url>">尾页</a>
            </td>
        </tr>
    </table>
</c:if>
</div>
</form>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</body>
</html>
