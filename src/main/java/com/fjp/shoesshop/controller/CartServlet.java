package com.fjp.shoesshop.controller;

import com.fjp.shoesshop.pojo.Cart;
import com.fjp.shoesshop.pojo.CartItem;
import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.service.FindGoodsService;
import com.fjp.shoesshop.service.impl.FindGoodsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends BaseServlet {
    //将购物车存储在HttpSession中
    //添加购物车项到购物车中/删除购物车/清空购物车
public Cart getCartFromHttpSession(HttpServletRequest request) {
    //请求对象中的session
    HttpSession session = request.getSession();
    //从session中获取属性
   Cart cart = (Cart) session.getAttribute("cart");
   //判断从session中获取的数据是否为null
    if (cart == null) {
        //session没有数据，给session存数据
        cart = new Cart();
        session.setAttribute("cart",cart);
    }
    return cart;
}

//将购车项目添加在购物车中
public void addCartItem2Cart(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    //
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");
    if (user == null){
        request.getRequestDispatcher("login.jsp").forward(request,response);
        return;
    }
    //分装购物车项
    String id = request.getParameter("id");
    String count = request.getParameter("count");
    FindGoodsService service = new FindGoodsServiceImpl();
    Goods goods = service.findById(Integer.parseInt(id));

    CartItem cartItem = new CartItem();
    cartItem.setGoods(goods);
    int cou= count == null ? 1:Integer.parseInt(count);
    cartItem.setCount(cou);

    //从getCartFromHttpSession获取购物车
    Cart cart = getCartFromHttpSession(request);
    cart.addCartItem2Cart(cartItem);

    //重定向购物车yemain
        request.getRequestDispatcher("cart.jsp").forward(request,response);
}

public void delCartItems(HttpServletRequest request,HttpServletResponse response) throws IOException {
    String id = request.getParameter("id");
    //获取购物车
    Cart cart = getCartFromHttpSession(request);
    cart.removeCartItemFromCart(Integer.parseInt(id));

    response.sendRedirect("cart.jsp");
}
}
