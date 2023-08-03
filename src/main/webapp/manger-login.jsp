<%--
  Created by IntelliJ IDEA.
  User: fjc23
  Date: 2023/7/31
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/manger-login.css">
    <title>Future后台登录</title>
</head>
<body>
<div class="login-container">
    <h2>Future后台登录</h2>
    <c:if test="${!empty msg}">
        <div style="color: red">${mesg}</div>
    </c:if>
    <form method="post" action="${pageContext.request.contextPath}/MangerServlet">
        <div class="form-group">
            <input type="text" id="username" name="username" placeholder="用户名" required>
        </div>
        <div class="form-group">
            <input type="password" id="password" name="password" placeholder="密码" required>
        </div>
        <button type="submit" class="login-btn">登录</button>
    </form>
</div>
</body>
</html>
