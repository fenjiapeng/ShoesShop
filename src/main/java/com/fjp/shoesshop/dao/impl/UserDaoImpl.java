package com.fjp.shoesshop.dao.impl;

import com.fjp.shoesshop.dao.UserDao;
import com.fjp.shoesshop.pojo.User;
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
 * @date 2023/8/1 11:52
 */
public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        try {
            List<User> userList = queryRunner.query(sql, new BeanListHandler<User>(User.class));
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        try {
            return queryRunner.query(sql, new BeanHandler<User>(User.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int updateAddress(User user) {
        String sql = "update user set name =?,phone=?,address=? where id = ?";
        try {
           return queryRunner.update(sql,user.getName(),user.getPhone(),user.getAddress(),user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updatePassword(User user) {
        String sql = "update user set password = ? where id =?";
        try {
           return queryRunner.update(sql,user.getPassword(),user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set username=?,email=?,password=?,name=?,phone=?,address=? where id=?";
        try {
           return queryRunner.update(sql,user.getUsername(),
                   user.getEmail(),
                   user.getPassword(),
                   user.getName(),
                   user.getPhone(),
                   user.getAddress(),
                   user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        String sql = "delete from user where id = ?";
        try {
           return queryRunner.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?)";
        try {
           return queryRunner.update(sql, user.getId(),user.getUsername(),user.getEmail(),user.getPassword(),user.getName(),user.getPhone(),user.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
