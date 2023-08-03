package com.fjp.shoesshop.controller;

import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.service.UserService;
import com.fjp.shoesshop.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet", value = "/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String newPwd = request.getParameter("passwordNew");

        User u = (User) request.getSession().getAttribute("user");
        if (password.equals(u.getPassword())) {
            u.setPassword(newPwd);
            userService.updatePassword(u);
            request.setAttribute("msg", "修改成功！");
            request.getRequestDispatcher("/mycenter.jsp").forward(request, response);
        } else {
            request.setAttribute("failMsg", "修改失败，原密码不正确，你再想想！");
            request.getRequestDispatcher("/mycenter.jsp").forward(request, response);
        }
    }
}
