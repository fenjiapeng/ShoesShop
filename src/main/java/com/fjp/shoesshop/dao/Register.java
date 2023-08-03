package com.fjp.shoesshop.dao;

import com.fjp.shoesshop.pojo.User;

import java.sql.SQLException;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/31 16:01
 */
public interface Register {

    int addUser(User user);

    boolean isUsernameExist(String username) throws SQLException;

    boolean isEmailExist(String email) throws SQLException;
}
