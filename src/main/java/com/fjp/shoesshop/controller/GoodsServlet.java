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
public class GoodsServlet extends GoodsBaseServlet {
    private GoodsService goodsService = new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        findAll(req, resp);
    }

       protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           HttpSession session = request.getSession();
           List<Goods> good = goodsService.findAll();
           System.out.println(good);
           session.setAttribute("good",good);
           request.getRequestDispatcher("goodmanger.jsp").forward(request, response);
    }
    protected void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Goods goods = goodsService.findById(id);
        request.setAttribute("good",goods);
    }
    protected void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean b = goodsService.deleteGoods(id);
        response.sendRedirect("GoodsServlet");
    }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
}}
