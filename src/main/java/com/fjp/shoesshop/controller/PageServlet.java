package com.fjp.shoesshop.controller;

import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.pojo.Page;
import com.fjp.shoesshop.service.FindGoodsService;
import com.fjp.shoesshop.service.impl.FindGoodsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PageServlet", value = "/PageServlet")
public class PageServlet extends HttpServlet {
    private FindGoodsService findGoodsService = new FindGoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndex = request.getParameter("pageIndex");
        if (pageIndex == null){
            pageIndex ="1";
        }
        Page<Goods> page = new Page<Goods>(1,6);
        List<Goods> goods = findGoodsService.selectPages(page);
        request.setAttribute("goods",goods);
        request.setAttribute("page",page);
        request.getRequestDispatcher("goods.jsp").forward(request, response);
    }
}
