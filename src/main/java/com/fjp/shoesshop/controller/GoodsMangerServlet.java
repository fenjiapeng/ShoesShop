package com.fjp.shoesshop.controller;

import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.service.FindGoodsService;
import com.fjp.shoesshop.service.impl.FindGoodsServiceImpl;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GoodsMangerServlet", value = "/GoodsMangerServlet")
public class GoodsMangerServlet extends HttpServlet {
    private FindGoodsService findGoodsService = new FindGoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> goods = findGoodsService.findGoods();
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", "");
        map.put("count", goods.size());
        map.put("data", goods);

        String s = gson.toJson(map);
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
