package com.fjp.shoesshop.dao;

import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.pojo.Page;

import java.util.List;

/**
 * @author fjc23
 */
public interface FindGoods {

    /**
     * 查找商品信息，展示在页面
     * @return
     */
    List<Goods> findGoods();

    Goods findById(int id);


    /**
     * 分页查询所有
     * @param page
     * @return
     */
    List<Goods> selectPages(Page page);

    /**
     * 查询总数
     */
    long selectCount();
}
