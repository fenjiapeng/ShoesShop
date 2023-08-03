package com.fjp.shoesshop.controller;

import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.service.UserService;
import com.fjp.shoesshop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserMangerServlet", value = "/UserMangerServlet")
public class UserMangerServlet extends UserBaseServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        findAll(req, resp);
        updateUser(req, resp);
        findById(req, resp);
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<User> users = userService.findAll();
        System.out.println(users);
        session.setAttribute("user",users);
        request.getRequestDispatcher("usermanger.jsp").forward(request,response);
    }
    protected void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int uid = Integer.parseInt(id);
        User user = userService.findById(uid);
        request.setAttribute("user",user);
        request.getRequestDispatcher("userupdate.jsp").forward(request, response);

    }
    protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        User user = new User(username,email,password,name,phone,address);
        boolean b = userService.updateUser(user);
        if (b) {
            response.sendRedirect("UserMangerServlet");
        }else {
            System.out.println("修改失败");
        }

    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
