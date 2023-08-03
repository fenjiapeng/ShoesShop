package com.fjp.shoesshop.controller;

import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.service.GoodsService;
import com.fjp.shoesshop.service.impl.GoodsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsServlet", value = "/GoodsServlet")
public class GoodsServlet extends HttpServlet {
    private GoodsService goodsService = new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    //    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            List<Goods> good = goodsService.findAll();
            System.out.println(good);
            session.setAttribute("good",good);
            request.getRequestDispatcher("goodmanger.jsp").forward(request, response);
}}
