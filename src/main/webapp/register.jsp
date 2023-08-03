<%--
  Created by IntelliJ IDEA.
  User: fjc23
  Date: 2023/7/31
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <style>
        .container {
            width: 300px;
            margin: 0 auto;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .submit-btn {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <h1>注册页面</h1>
    <c:if test="${!empty msg }">
        <div class="alert alert-danger">${msg}</div>
    </c:if>
    <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
        <div class="form-group">
            <label for="username">用户名:</label>
            <input type="text" id="username" name="username" required>
            <div id="error-message" style="color: red;"></div>
        </div>
        <div class="form-group">
            <label for="email">邮箱:</label>
            <input type="email" id="email" name="email" required>
            <div id="email-message" style="color: red;"></div>
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" required>
            <div id="pass-message" style="color: red;"></div>
        </div>
        <div class="form-group">
            <label for="name">收货人:</label>
            <input type="text" id="name" name="name" required>
            <div id="name-message" style="color: red;"></div>
        </div>
        <div class="form-group">
            <label for="phone">电话:</label>
            <input type="tel" id="phone" name="phone" required>
            <div id="phone-message" style="color: red;"></div>
        </div>
        <div class="form-group">
            <label for="address">收货地址:</label>
            <textarea id="address" name="address" rows="4" required></textarea>
            <div id="address-message" style="color: red;"></div>
        </div>
        <button type="submit" class="submit-btn">注册</button>
    </form>

</div>
<script>
    $(document).ready(function() {
        $("#username").blur(function() {
            if ($("#username").val().trim() === "") {
                $("#error-message").text("用户名不能为空");
            }else{
                $("#error-message").text("");
            }
        });

        $("#email").blur(function () {
            if ($("#email").val().trim() === ""){
                $("#email-message").text("邮箱不能为空");
            }else{
                $("#email-message").text("");
            }
        });
        
        $("#name").blur(function () {
            if ($("#name").val().trim()===""){
                $("#name-message").text("收件人不能为空");
            }else {
                $("#name-message").text("");
            }
        });

        $("#password").blur(function(){
            if ($("#password").val().trim()===""){
                $("#pass-message").text("密码不能为空");
            }else {
                $("#pass-message").text("");
            }
        })

        $("#phone").blur(function () {
            if ($("#phone").val().trim() === ""){
                $("#phone-message").text("手机号码不能为空");
            }else {
                $("#phone-message").text("");
            }
        });

        $("#address").blur(function () {
            if ($("#address").val().trim() === ""){
                $("#address-message").text("收货地址不能为空");
            }else {
                $("#address-message").text("");
            }
        });
    });
</script>
</body>
</html>