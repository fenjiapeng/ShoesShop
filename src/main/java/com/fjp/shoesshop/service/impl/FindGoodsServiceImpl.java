package com.fjp.shoesshop.service.impl;

import com.fjp.shoesshop.dao.FindGoods;
import com.fjp.shoesshop.dao.impl.FindGoodsImpl;
import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.pojo.Page;
import com.fjp.shoesshop.service.FindGoodsService;

import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/27 0:29
 */
public class FindGoodsServiceImpl implements FindGoodsService {
    private static FindGoods findGoods = new FindGoodsImpl();
    @Override
    public List<Goods> findGoods() {
        return findGoods.findGoods();

    }

    @Override
    public Goods findById(int id) {
       return findGoods.findById(id);
    }

    @Override
    public List<Goods> selectPages(Page page) {
        long count = findGoods.selectCount();
        page.setTotalCounts((int) count);
        return findGoods.selectPages(page);
    }


}
