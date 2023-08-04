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
    <title>商品更新</title>
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
<form method="post" action="${pageContext.request.contextPath}/GoodsServlet?option=updateGoods">
    id：<input type="text" readonly name="id" value="${good.id}"><br>
    名称：<input type="text" name="name" value="${good.name}"><br>
    图片名称：<input type="text" name="image" value="${good.image}"><br>
    单价：<input type="text" name="price" value="${good.price}"><br>
    介绍：<input type="text" name="desc" value="${good.gdesc}"><br>
    库存：<input type="text" name="stock" value="${good.stock}"><br>
    品牌：<input type="text" name="type_id" value="${good.type_id}"><br>
    <input type="submit" value="更新">
</form>
<%--<form method="post" action="GoodsServlet?option=upFiles" enctype="multipart/form-data">--%>
<%--    图片：<input type="file" name="file"><br>--%>
<%--    <input type="submit" value="更新图片">--%>
<%--</form>--%>
</body>
</html>
