package com.fjp.shoesshop.dao.impl;

import com.fjp.shoesshop.dao.LoginDao;
import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/28 1:36
 */
public class LoginDaoImpl implements LoginDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    @Override
    public User login(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        try {
           return queryRunner.query(sql,new BeanHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
