package com.fjp.shoesshop.controller;

import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.service.UserService;
import com.fjp.shoesshop.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "ChangeAddressServlet", value = "/ChangeAddressServlet")
public class ChangeAddressServlet extends HttpServlet {
        private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loginUser = (User) request.getSession().getAttribute("user");
            try {
                BeanUtils.copyProperties(loginUser, request.getParameterMap());
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            userService.updateAddress(loginUser);
            request.setAttribute("msg", "收件信息更新成功！");
            request.getRequestDispatcher("/mycenter.jsp").forward(request, response);
        }
    }