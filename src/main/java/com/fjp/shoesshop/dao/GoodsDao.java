package com.fjp.shoesshop.dao;

import com.fjp.shoesshop.pojo.Goods;

import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/2 10:12
 */
public interface GoodsDao {

    int deleteGoods();
    List<Goods> findAll();
}
