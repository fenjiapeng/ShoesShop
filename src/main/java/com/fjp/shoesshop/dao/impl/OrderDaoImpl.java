package com.fjp.shoesshop.dao.impl;

import com.fjp.shoesshop.dao.OrderDao;
import com.fjp.shoesshop.pojo.OrderItem;
import com.fjp.shoesshop.pojo.Orders;
import com.fjp.shoesshop.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/3 13:14
 */
public class OrderDaoImpl implements OrderDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    @Override
    public void insertOrder(Orders order) {
        String sql ="insert into orders values(?,?,?,?,?,?,?,?)";
        try {
            int count = queryRunner.update(sql,
                    order.getId(),
                    order.getOrdertime(),
                    order.getTotal(),
                    order.getState(),
                    order.getUser().getAddress(),
                    order.getUser().getName(),
                    order.getUser().getPhone(),
                    order.getUser().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertOrderItem(OrderItem orderItem) throws SQLException {
        String sql ="insert into orderitem values(?,?,?,?,?)";
        queryRunner.update(sql,
                orderItem.getItemid(),
                orderItem.getCount(),
                orderItem.getSubtotal(),
                orderItem.getGoods().getId(),
                orderItem.getOrders().getId());

    }

    @Override
    public Orders getOrderByOid(String oid) throws SQLException {
        String sql = "select * from orders where id = ?" ;
        Orders order = queryRunner.query(sql, new BeanHandler<Orders>(Orders.class), oid);
        return order;
    }

    @Override
    public void updateOrder(Orders order) throws SQLException {
        String sql = "update orders set state = ? where id = ?";
        queryRunner.update(sql,order.getState(),order.getId());
    }

    @Override
    public List<Orders> findAll() {
        String sql = "select * from orders";
        try {
           return queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteOrder(String id) {
        String sql = "delete from orders where id =?";
        try {
           return queryRunner.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
