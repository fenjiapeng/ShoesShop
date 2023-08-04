package com.fjp.shoesshop.dao;

import com.fjp.shoesshop.pojo.OrderItem;
import com.fjp.shoesshop.pojo.Orders;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/3 13:13
 */
public interface OrderDao {

    void insertOrder(Orders order);
    void insertOrderItem(OrderItem orderItem) throws SQLException;
    Orders getOrderByOid(String oid) throws SQLException;
    void updateOrder(Orders order) throws SQLException;

    List<Orders> findAll();
    int deleteOrder(String id);
}
