package com.fjp.shoesshop.dao.impl;

import com.fjp.shoesshop.dao.Register;
import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/31 16:02
 */
public class RegisterDaoImpl implements Register {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    @Override
    public int addUser(User user) {
        String sql = "insert into user(username,email,password,name,phone,address) values (?,?,?,?,?,?)";
        try {
           return queryRunner.update(sql,user.getUsername(),user.getEmail(),user.getPassword(),user.getName(),user.getPhone(),user.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean isUsernameExist(String username) throws SQLException {
        String sql = "select * from user where username =?";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class), username);
        if (user == null) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean isEmailExist(String email) throws SQLException {
        String sql = "select * from user where email =?";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class), email);
        if (user == null) {
            return false;
        }else {
            return true;
        }
    }
}
