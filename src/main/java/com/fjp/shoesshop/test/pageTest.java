package com.fjp.shoesshop.test;

import com.fjp.shoesshop.dao.FindGoods;
import com.fjp.shoesshop.dao.impl.FindGoodsImpl;
import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.pojo.Page;
import com.fjp.shoesshop.service.FindGoodsService;
import com.fjp.shoesshop.service.impl.FindGoodsServiceImpl;

import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/27 20:10
 */
public class pageTest {
    public static void main(String[] args) {
//        FindGoodsService findGoodsService = new FindGoodsServiceImpl();
//        List<Goods> goods = findGoodsService.selectPages(page);
//        for (Goods good : goods) {
//            System.out.println(good);
//        }

        System.out.println("------------------------");
        FindGoods findGoods = new FindGoodsImpl();
        System.out.println(findGoods.selectCount());
        Page page = new Page<Goods>(1,6);
        List<Goods> goods1 = findGoods.selectPages(page);
        for (Goods goods2 : goods1) {
            System.out.println(goods2);
        }
    }
}
