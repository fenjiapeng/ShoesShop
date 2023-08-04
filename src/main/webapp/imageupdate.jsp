<%--
  Created by IntelliJ IDEA.
  User: fjc23
  Date: 2023/8/4
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片修改</title>
</head>
<body>
<form method="post" action="GoodsServlet?option=upFiles" enctype="multipart/form-data">
    id:<input type="text" name="id" value="${good.id}">
    name: <input type="text" name="pname"  value="${good.image}"/><p />
    file: <input type="file" name="file" /><p />
    <input type="submit" value="更新" /><p />
</form>
</body>
</html>
