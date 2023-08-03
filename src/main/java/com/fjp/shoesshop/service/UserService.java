package com.fjp.shoesshop.service;

import com.fjp.shoesshop.pojo.User;

import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/1 11:54
 */
public interface UserService {
    boolean updateAddress(User user);
    boolean updatePassword(User user);
    List<User> findAll();
    User findById(int id);
    boolean updateUser(User user);

}
