<%--
  Created by IntelliJ IDEA.
  User: fjc23
  Date: 2023/7/28
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <style>
        body{
            background: #353f42;
        }

        *{
            padding: 0;
            margin: 0;
        }

        .main {
            margin: 0 auto;
            padding-left: 25px;
            padding-right: 25px;
            padding-top: 15px;
            width: 350px;
            height: 450px;
            background: #FFFFFF;
            /*以下css用于让登录表单垂直居中在界面,可删除*/
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -175px;
            margin-left: -175px;
        }

        .title {
            width: 100%;
            height: 40px;
            line-height: 40px;
        }

        .title span {
            font-size: 18px;
            color: #353f42;
        }

        .title-msg {
            width: 100%;
            height: 64px;
            line-height: 64px;
        }

        .title:hover{
            cursor: default	;
        }

        .title-msg:hover{
            cursor: default	;
        }

        .title-msg span {
            font-size: 12px;
            color: #707472;
        }

        .input-content {
            width: 100%;
            height: 120px;
        }

        .input-content input {
            width: 330px;
            height: 40px;
            border: 1px solid #dad9d6;
            background: #ffffff;
            padding-left: 10px;
            padding-right: 10px;
        }

        .enter-btn {
            width: 350px;
            height: 40px;
            color: #fff;
            background: #0bc5de;
            line-height: 40px;
            text-align: center;
            border: 0px;
        }

        .foor{
            width: 100%;
            height: auto;
            color: #9b9c98;
            font-size: 12px;
            margin-top: 20px;
        }

        .enter-btn:hover {
            cursor:pointer;
            background: #1db5c9;
        }

        .foor div:hover {
            cursor:pointer;
            color: #484847;
            font-weight: 600;
        }

        .left{
            float: left;
        }
        .right{
            float: right;
        }
#bvtn{
    position: absolute;
    top: 350px;
}
#code{
    width: 200px;
}

    </style>
</head>
<body>
<div class="main">
    <div class="title">
        <span>密码登录</span>
    </div>

    <div class="title-msg">
        <span>请输入登录账户和密码</span>
    </div>
    <c:if test="${!empty msg }">
        <div class="alert alert-danger" style="color: #4CAF50">${msg}</div>
    </c:if>
    <c:if test="${!empty failmsg }">
        <div class="alert alert-danger" style="color: #f30724">${failmsg}</div>
    </c:if>
    <form id="login_lister" class="login-form"  novalidate action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <!--输入框-->
        <div class="input-content">
            <!--autoFocus-->
            <div>
                <input id="username" type="text" autocomplete="off"
                       placeholder="用户名" name="username" required />
            </div>

            <div style="margin-top: 16px">
                <input id="password" type="password"
                       autocomplete="off" placeholder="登录密码" name="password" required maxlength="32"/>
            </div>
            <div style="margin-top: 16px">
                <input id="code" type="text"
                       autocomplete="off" placeholder="验证码" name="ecode" required maxlength="10"/>
                <img id="ecode"  src="./image.jsp" width="125" />
            </div>
        </div>

        <!--登入按钮-->
        <div id="bvtn">
        <div style="text-align: center">
            <button id="login_btn" type="submit" class="enter-btn" >登录</button>
        </div>
            <div id="error-message" style="color: red;"></div>
        <div class="foor">
            <div class="left"><span>忘记密码 ?</span>&nbsp;&nbsp;
            </div>
            <div class="left"><a href="manger-login.jsp">管理员登录</a></div>

            <div class="right"><span>注册账户</span></div>
        </div>
        </div>
    </form>
</div>
<script>
    $(document).ready(function () {
        $("#username").blur(function () {
            if ( $("#username").val().trim() ==="") {
                $("#error-message").text("用户名不能为空");
            }else {
                $("#error-message").text("");
            }
            })
        $("#password").blur(function () {
            if ( $("#password").val().trim() ==="") {
                $("#error-message").text("密码不能为空");
            }else {
                $("#error-message").text("");
            }
        })
        $("#code").blur(function () {
            if ( $("#code").val().trim() ==="") {
                $("#error-message").text("验证码不能为空");
            }else {
                $("#error-message").text("");
            }
        })
    })
</script>
</body>
</html>

