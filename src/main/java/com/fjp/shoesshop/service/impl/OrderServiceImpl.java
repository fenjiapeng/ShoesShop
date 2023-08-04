package com.fjp.shoesshop.service.impl;

import com.fjp.shoesshop.dao.OrderDao;
import com.fjp.shoesshop.dao.impl.OrderDaoImpl;
import com.fjp.shoesshop.pojo.OrderItem;
import com.fjp.shoesshop.pojo.Orders;
import com.fjp.shoesshop.service.OrderService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/3 13:11
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    @Override
    public void addOrder(Orders order) {
        //调用dao
        try {
            //控制事务，同时添加事务
            orderDao.insertOrder(order);
            for (OrderItem orderItem : order.getList()) {
                orderDao.insertOrderItem(orderItem);
            }
            }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Orders getOrderByOid(String oid) {
        try {
            Orders order = orderDao.getOrderByOid(oid);
            if(order!=null){
                return order ;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateOrderState(Orders order)  {
        //调用dao层
        try {
            orderDao.updateOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Orders> findAll() {
        List<Orders> all = orderDao.findAll();
        return all;
    }

    @Override
    public int deleteOrder(String id) {
        int i = orderDao.deleteOrder(id);
        return i;
    }
}
