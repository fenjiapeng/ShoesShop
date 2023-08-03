package com.fjp.shoesshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/1 23:38
 */

public class CartItem {
    private Goods goods;
    //商品数量
    private int count;
    //商品小计
    private double subTotal;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubTotal() {
        return goods.getPrice() * count;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
