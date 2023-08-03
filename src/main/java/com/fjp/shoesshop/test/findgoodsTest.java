package com.fjp.shoesshop.test;

import com.fjp.shoesshop.dao.FindGoods;
import com.fjp.shoesshop.dao.impl.FindGoodsImpl;
import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.service.FindGoodsService;
import com.fjp.shoesshop.service.impl.FindGoodsServiceImpl;

import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/27 0:23
 */
public class findgoodsTest {
    public static void main(String[] args) {
        //FindGoods findGoods = new FindGoodsImpl();
        FindGoodsService goodsService = new FindGoodsServiceImpl();
        Goods goods = goodsService.findById(1);
        System.out.println(goods);

    }
}
