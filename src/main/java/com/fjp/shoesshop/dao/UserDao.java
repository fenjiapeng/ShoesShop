package com.fjp.shoesshop.dao;

import com.fjp.shoesshop.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/1 11:51
 */
public interface UserDao {
    List<User> findAll();
    User findById(int id);
    int updateAddress(User user);
    int updatePassword(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
