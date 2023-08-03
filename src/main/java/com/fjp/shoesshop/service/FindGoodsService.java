package com.fjp.shoesshop.service;

import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.pojo.Page;

import java.util.List;

/**
 * @author fjc23
 */
public interface FindGoodsService {
    /**
     * 查找商品信息，展示在页面
     * @return
     */
    List<Goods> findGoods();

    Goods findById(int id);

    List<Goods> selectPages(Page page);
}
