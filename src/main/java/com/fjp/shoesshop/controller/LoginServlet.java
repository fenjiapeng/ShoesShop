package com.fjp.shoesshop.controller;

import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.service.LoginService;
import com.fjp.shoesshop.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ecode = request.getParameter("ecode");
        System.out.println(ecode);
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);
        HttpSession session = request.getSession();
        String checkecode = (String) session.getAttribute("rand");
        //session.removeAttribute("ecode");

        // checkecode.equalsIgnoreCase(ecode)这是或者的关系所
        // 以这句话放在这里会使他进入循环然后请求转发到login.jsp所以去掉||checkecode.equalsIgnoreCase(ecode)
        if (ecode == null || "".equals(ecode)  ) {
            request.setAttribute("failmsg", "验证码错误");
            System.out.println("hello");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        User user = loginService.login(username, password);
        if (user == null) {
            request.setAttribute("failmsg", "用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            session.setAttribute("user", user);
            System.out.println(user);
            //request.setAttribute("user",user);
            //response.sendRedirect(request.getContextPath()+"/FindGoodsServlet");
            request.getRequestDispatcher("mycenter.jsp").forward(request, response);
        }
    }
    }


