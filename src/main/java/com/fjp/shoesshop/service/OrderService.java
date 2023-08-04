package com.fjp.shoesshop.service;

import com.fjp.shoesshop.pojo.Orders;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/3 13:10
 */
public interface OrderService {

    void addOrder(Orders order);
    Orders getOrderByOid(String oid) ;

    void updateOrderState(Orders order) throws SQLException;

    List<Orders> findAll();

    int deleteOrder(String id);
    boolean updateOrders(Orders order);
}
