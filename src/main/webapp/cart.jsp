<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>购物车</title>
    <link rel="stylesheet" href="./css/cart.css">
    <style>
        .cartTable{
            margin-top: 100px;
        }
    </style>
<body>
<div class="wrap clearfix">
    <table width="100%" class="cartTable" cellspacing="0" cellpadding="10px">
        <h1 class="cartTable" style="font-size: 40px">我的购物车</h1>
        <a href="FindGoodsServlet" style="margin-right: 0">返回上一级</a>
        <!-- 首行 -->
        <tr class="title">
            <td width="50"><input type="checkbox" name="" class="choose_all"></td>
            <td width="100" class=""><span>全选</span></td>
            <td width="400">商品信息</td>
            <td width="150">单价（元）</td>
            <td width="150">数量</td>
            <td width="150">金额（元）</td>
            <td width="80">操作</td>
        </tr>

        <!-- 商品具体信息 -->
        <c:forEach items="${cart.cartItem}" var="c">
        <tr class="row">
            <td><input type="checkbox" name="" class="choose"></td>
            <td class="tal"><img style="width: 200px" src="./img/${c.goods.image}" alt=""></td>
             <td><a href="#">${c.goods.name} </a></td>
            <td>
                <span class="tdl">${c.goods.price}</span>
                <br>
                <b class="unit">${c.goods.price}</b>
            </td>
            <td>
                <div class="amount">
                    <input type="text"  value="${c.count}" maxlength="4" size="10">
                </div>
            </td>
            <td><b class="u-price">${c.subTotal}</b></td>
            <td><a href="javascript:void(0)" onclick="delCartItems(${c.goods.id})" class="btn-del">删除</a></td>
        </tr>
        </c:forEach>
        <tr class="count">
            <td colspan="7">
                <div class="jiesuan clearfix">
                    <div class="left fl">
                        <p><input type="checkbox" name="" class="choose_all"> 全选&nbsp;&nbsp;&nbsp;<a href="#" class="del_check">删除选中商品</a></p>
                    </div>
                    <div class="right fr clearfix">
                        <p>已选商品<span class="red t-number"> 0 </span>件 总价(不含运费、税费)：<span class="red t-price">￥${cart.totalMoney}</span></p>
                        <!-- <div><a href="#" class="btn pay">结算</a></div> -->
                        <a href="${pageContext.request.contextPath}/OrderServlet?option=generateOrder" class="btn pay fr">结算</a>
                    </div>
                </div>
            </td>
        </tr>
    </table>
</div>
<script>
</script>
<!-- 引入JS文件 -->
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</body>
<script>
    function delCartItems(id) {
        //提示
        var b = window.confirm("确定删除？");
        if (b){
            window.location.href = "${pageContext.request.contextPath}/CartServlet?option=delCartItems&id="+id+"";
        }
    }
</script>
</html>
