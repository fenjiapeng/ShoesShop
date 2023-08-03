package com.fjp.shoesshop.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fjp.shoesshop.config.AlipayConfig;
import com.fjp.shoesshop.pojo.*;
import com.fjp.shoesshop.service.OrderService;
import com.fjp.shoesshop.service.impl.OrderServiceImpl;
import com.fjp.shoesshop.util.UUIDUtils;
import lombok.SneakyThrows;
import java.sql.Timestamp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends OrderBaseServlet {

    //产生订单信息，he订单项
    @SneakyThrows
    public void generateOrder(HttpServletRequest request, HttpServletResponse response){
        //获取session的用户信息
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            response.sendRedirect("login.jsp");
        }
        Orders orders = new Orders();
        //随机生成订单编号
        orders.setId(UUIDUtils.getId());
        //下单时间
        orders.setOrdertime(new Date());

        //获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        orders.setTotal(cart.getTotalMoney());
        //收货人，地址，收件地址
        //封装订单项--商品，数量，小计
        OrderItem orderItem = null;
        Collection<CartItem> cartItem = cart.getCartItem();
        for (CartItem item : cartItem) {
            orderItem = new OrderItem();
            //itemid
            orderItem.setItemid(UUIDUtils.getId());
            orderItem.setCount(item.getCount());
            orderItem.setSubtotal(item.getSubTotal());
            orderItem.setGoods(item.getGoods());
            orderItem.setOrders(orders);

            //添加订单项
            orders.getList().add(orderItem);
        }
        //订单属于哪个用户
            orders.setUser(user);
        System.out.println(orders);
        System.out.println(orderItem);
        //调用订单业务接口
        OrderService orderService = new OrderServiceImpl();
        orderService.addOrder(orders);
        request.getSession().removeAttribute("cart");
        request.setAttribute("order",orders);
        request.getRequestDispatcher("order_info.jsp").forward(request, response);
    }

    //支付方法
    public void pay(HttpServletRequest request,HttpServletResponse response){
        String oid = request.getParameter("oid");
       // System.out.println(oid);
        //获取订单业务接口---通过订单id获取具体的订单信息
        OrderServiceImpl orderService = new OrderServiceImpl();
        Orders order = orderService.getOrderByOid(oid);

        try {
            //获得初始化的AlipayClient (创建支付宝客户端对象)
            AlipayClient alipayClient = new DefaultAlipayClient(
                    AlipayConfig.gatewayUrl,
                    AlipayConfig.app_id,
                    AlipayConfig.merchant_private_key,
                    "json",
                    AlipayConfig.charset,
                    AlipayConfig.alipay_public_key,
                    AlipayConfig.sign_type);

            //设置请求参数---设置支付宝回调的参数
            AlipayTradePagePayRequest alipayRequest =
                    new AlipayTradePagePayRequest();
            alipayRequest.setReturnUrl(AlipayConfig.return_url);
            alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

            //设置发送请求的时候,里面的具体的参数:
            //1)out_trade_no:订单编号
            //2)subject：主题信息
            //3)product_code:产品码名称,支付宝默认值:FAST_INSTANT_TRADE_PAY
            //4)total_amount:总金额
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ order.getId() +"\","
                    + "\"total_amount\":\""+ order.getTotal() +"\","
                    + "\"subject\":\""+ "球鞋" +"\","
                    + "\"body\":\""+ "球鞋相关"+"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

//			//商户订单号，商户网站订单系统中唯一订单号，必填
//			String out_trade_no = "asdfgre13243245335345";
//			//付款金额，必填
//			String total_amount = "1";
//			//订单名称，必填
//			String subject = "充值话费";
//			//商品描述，可空
//			String body = "话费充值1元";
//
//			alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
//					+ "\"total_amount\":\""+ total_amount +"\","
//					+ "\"subject\":\""+ subject +"\","
//					+ "\"body\":\""+ body +"\","
//					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

            //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
            //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
            //		+ "\"total_amount\":\""+ total_amount +"\","
            //		+ "\"subject\":\""+ subject +"\","
            //		+ "\"body\":\""+ body +"\","
            //		+ "\"timeout_express\":\"10m\","
            //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

            //请求
            //将设置表单信息全部以form表单方式发送支付宝
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            //输出
            System.out.println(result);
            //响应给浏览器---->用户看到支付宝的登录页面
            response.getWriter().write(result) ;
            response.getWriter().flush();
            response.getWriter().close();
        } catch ( IOException | AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderService orderService = new OrderServiceImpl();
        List<Orders> order = orderService.findAll();
        System.out.println(order);
        session.setAttribute("order",order);
        response.sendRedirect("ordermanger.jsp");
    }
}
