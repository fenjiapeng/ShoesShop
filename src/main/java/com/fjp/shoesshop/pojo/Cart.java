package com.fjp.shoesshop.pojo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/2 23:13
 */
public class Cart {
    /**
     * key代表商品id
     */
    private Map<Integer,CartItem> map = new LinkedHashMap<>();
    private double totalMoney = 0.0;
    //获取所有值
    public Collection<CartItem> getCartItem(){
       return map.values();
    }
    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartItem> map) {
        this.map = map;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
    /**
     * 定义一个方法:将购物车项添加购物车中
     * @param cartItem 购物车项实体
     */
    public void addCartItem2Cart(CartItem cartItem){
        //获取添加到购物车项的商品id
        int id = cartItem.getGoods().getId();
        //在map中判断是否重复
        if(map.containsKey(id)){
            //获取以前的数量
            CartItem oldCartItem1 = map.get(id);
            oldCartItem1.setCount(oldCartItem1.getCount()+1);
        }else {
            //直接添加数据
            map.put(id,cartItem);
        }
        //总金额的变化
        totalMoney += cartItem.getSubTotal();
    }
    //删除购物车
    public void removeCartItemFromCart(int id){
        CartItem cartItem = map.remove(id);
        //设置总金额
        totalMoney -=cartItem.getSubTotal();
    }

    //清空购物车
    public void clearCart(){
        map.clear();
        totalMoney = 0.0;
    }
}
