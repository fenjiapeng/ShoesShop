package com.fjp.shoesshop.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.fjp.shoesshop.config.AlipayConfig;
import com.fjp.shoesshop.pojo.Orders;
import com.fjp.shoesshop.service.OrderService;
import com.fjp.shoesshop.service.impl.OrderServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@WebServlet("/aliPayReturnUrlServlet") 
public class AliPayReturnUrlServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //支付宝回调 : 外网必须访问:
        //支付宝响应get请求

        PrintWriter out = response.getWriter();

        //输入支付密码--->确认支付--->通过内网穿透工具产生的外链(公网域名)去访问本地web服务
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            System.out.println("转码前："+valueStr);
            //tomcat7.0 get提交中文的乱码
//			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//			System.out.println("转码后："+valueStr);
            params.put(name, valueStr);
			
			//订单账号/订单总金额/订单中的信息主题("数码产品....")
        }


        try {
            //调用SDK验证签名
            boolean signVerified = AlipaySignature.rsaCheckV1(
                    params,
                    //支付宝应用公钥
                    AlipayConfig.alipay_public_key,  //否则验签失败
                    //编码格式 utf-8
                    AlipayConfig.charset,
                    //验签方式
                    AlipayConfig.sign_type);

            //——请在这里编写您的程序（以下代码仅作参考）——
            if(signVerified) {
                //商户订单号
                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //支付宝交易号
                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //付款金额
                String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");



              
                //调用OrderService业务接口,将支付的状态变成1(完成业务)
                OrderService orderService = new OrderServiceImpl() ;
                //通过订单编号获取订单 out_trade_no
                Orders order = orderService.getOrderByOid(out_trade_no);
                order.setState(1) ;
                orderService.updateOrderState(order) ;
                //设置成功的页面
                request.setAttribute("order",order) ;
                //请求转发到/success.jsp
                request.getRequestDispatcher("success.jsp").forward(request,response);


            }else {
                //启用的支付宝的公钥模式---没有使用支付宝公钥
                out.println("验签失败");
            }
            //——请在这里编写您的程序（以上代码仅作参考）——
        } catch (AlipayApiException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
