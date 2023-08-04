package com.fjp.shoesshop.service.impl;

import com.fjp.shoesshop.dao.GoodsDao;
import com.fjp.shoesshop.dao.impl.GoodsDaoImpl;
import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.service.GoodsService;

import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/4 1:12
 */
public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public List<Goods> findAll() {
        List<Goods> all = goodsDao.findAll();
        System.out.println("goods"+all);
        return all;
    }

    @Override
    public boolean deleteGoods(int id) {
        int i = goodsDao.deleteGoods(id);
        return i>0;
    }

    @Override
    public Goods findById(int id) {
        Goods byId = goodsDao.findById(id);
        return byId;
    }
}
