package com.fjp.shoesshop.service;

import com.fjp.shoesshop.pojo.Goods;

import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/4 1:12
 */
public interface GoodsService {
    List<Goods> findAll();
    boolean deleteGoods(int id);
    Goods findById(int id);
    boolean updateGood(Goods goods);
}
