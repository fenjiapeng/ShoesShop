<%--
  Created by IntelliJ IDEA.
  User: fjc23
  Date: 2023/8/3
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>订单详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <style>
        body {
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }
    </style>

    <%--导入核心标签库--%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body>


<%--静态包含--%>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="row">

        <div style="margin:0 auto;width:950px;">
            <table class="table table-bordered" style="margin-top: 40px">
                <tbody>
                <tr>
                    <th colspan="5"><h3>订单详情</h3></th>
                </tr>
                <tr class="warning">
                    <th colspan="5">订单编号:${order.id}</th>
                </tr>
                <tr class="warning">
                    <th>图片</th>
                    <th>商品</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>小计</th>
                </tr>

                <c:forEach items="${order.list}" var="bean">
                    <form id="pay-form" action="${pageContext.request.contextPath}/OrderServlet?option=pay" method="post">
                       <input type="hidden" name="oid" value="${order.id}">
                        <tr class="active">
                            <td width="60" width="30%">
                                <input type="hidden" name="id" value="22">
                                <img src="./img/${bean.goods.image}" width="60" height="60">
                            </td>
                            <td width="40%">
                                <a target="_blank">${bean.goods.name}</a>
                            </td>
                            <td width="20%">
                                ￥${bean.goods.price}
                            </td>
                            <td width="10%">
                                    ${bean.count}
                            </td>
                            <td width="15%">
                                <span class="subtotal">￥${bean.subtotal}</span>
                            </td>
                        </tr>
                    </form>

                </c:forEach>

                </tbody>
            </table>
        </div>

        <div style="text-align:right;margin-right:120px;">
            商品金额: <strong style="color:#ff6600;">￥${order.total}</strong>
        </div>

    </div>

    <div>
        <hr/>
        <form class="form-horizontal" style="margin-top:5px;margin-left:150px;">
            <div class="form-group">
                <label for="username" class="col-sm-1 control-label">地址</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="username" placeholder="请输入收货地址">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-1 control-label">收货人</label>
                <div class="col-sm-5">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="请输收货人">
                </div>
            </div>
            <div class="form-group">
                <label for="confirmpwd" class="col-sm-1 control-label">电话</label>
                <div class="col-sm-5">
                    <input type="password" class="form-control" id="confirmpwd" placeholder="请输入联系方式">
                </div>
            </div>
        </form>

        <hr/>

        <div style="margin-top:5px;margin-left:150px;float: right">
            <input type="button" onclick="btn_pay()" value="支付宝支付"  class="btn btn-primary btn-lg"  />
        </div>

    </div>

</div>
</body>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
<script>
    function btn_pay() {
      var form = $("#pay-form");
      form.submit();
    }
</script>
</html>
