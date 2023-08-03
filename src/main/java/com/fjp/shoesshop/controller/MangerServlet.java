package com.fjp.shoesshop.controller;

import com.fjp.shoesshop.dao.MangerDao;
import com.fjp.shoesshop.pojo.Manger;
import com.fjp.shoesshop.service.MangerService;
import com.fjp.shoesshop.service.impl.MangerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MangerServlet", value = "/MangerServlet")
public class MangerServlet extends HttpServlet {
    private MangerService mangerService = new MangerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Manger login = mangerService.login(username, password);
        System.out.println(login);
        if (login == null){
            request.setAttribute("meg","管理员用户名密码错误");
            request.getRequestDispatcher("manger-login.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("manger.jsp").forward(request, response);
        }
    }
}
