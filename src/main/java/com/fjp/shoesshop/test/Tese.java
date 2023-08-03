package com.fjp.shoesshop.test;

import com.fjp.shoesshop.dao.UserDao;
import com.fjp.shoesshop.dao.impl.UserDaoImpl;
import com.fjp.shoesshop.pojo.Orders;
import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.service.impl.OrderServiceImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/1 13:43
 */
public class Tese {
    public static void main(String[] args) throws SQLException {
        OrderServiceImpl orderService = new OrderServiceImpl();
        List<Orders> all = orderService.findAll();
        for (Orders orders : all) {
            System.out.println(orders);
        }
    }
}
