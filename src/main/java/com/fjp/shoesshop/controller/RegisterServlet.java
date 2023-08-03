package com.fjp.shoesshop.controller;


import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.service.RegisterService;
import com.fjp.shoesshop.service.impl.RegisterServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class
RegisterServlet extends HttpServlet {
    private RegisterService registerService = new RegisterServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        User user = new User(username,email,password,name,phone,address);
        boolean b = registerService.addUser(user);
        if (b) {
            request.setAttribute("msg","注册成功！请登录。");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            System.out.println(user);
        }else {
            request.setAttribute("msg","注册失败！重新注册。");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

    }
}
