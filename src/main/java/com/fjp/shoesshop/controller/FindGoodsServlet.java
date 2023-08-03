package com.fjp.shoesshop.controller;

import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.pojo.Page;
import com.fjp.shoesshop.service.FindGoodsService;
import com.fjp.shoesshop.service.impl.FindGoodsServiceImpl;
import org.junit.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * @author fjc23
 */
@WebServlet(name = "FindGoodsServlet", value = "/FindGoodsServlet")
public class FindGoodsServlet extends BaseServlet{
    private  FindGoodsService findGoodsService = new FindGoodsServiceImpl();

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //findGoods(req, resp);
////        findById(req, resp);
////        pageServlet(req, resp);
//    }

    protected void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int gid = id == null ? 0: Integer.parseInt(id);
        Goods goods = findGoodsService.findById(gid);
        request.setAttribute("goods",goods);
        request.getRequestDispatcher("goodsdetail.jsp").forward(request,response);
    }

//        protected void findGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            List<Goods> goods = findGoodsService.findGoods();
//            request.setAttribute("goods",goods);
//            request.getRequestDispatcher("goods.jsp").forward(request, response);
//    }
    protected void pageServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndex = request.getParameter("pageIndex");
        if (pageIndex == null){
            pageIndex = "1";
        }
        Page<Goods> page = new Page<Goods>(Integer.valueOf(pageIndex));
        List<Goods> goods = findGoodsService.selectPages(page);
        request.setAttribute("goods",goods);
        request.setAttribute("page",page);
        request.getRequestDispatcher("goods.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
