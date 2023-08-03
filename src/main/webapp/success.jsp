<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/4/27
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付成功的页面通知</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="margin-left: 20%;">
<h1 style="color: #4CAF50">支付成功</h1>
  支付完成之后订单编号是:${order.id}<br/>
  订单状态:${order.state}--(已支付)
</div>
</body>
</html>
