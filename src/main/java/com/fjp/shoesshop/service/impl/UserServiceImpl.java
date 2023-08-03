package com.fjp.shoesshop.service.impl;

import com.fjp.shoesshop.dao.UserDao;
import com.fjp.shoesshop.dao.impl.UserDaoImpl;
import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.service.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/1 11:55
 */
public class UserServiceImpl implements UserService {
  private UserDao userDao =  new UserDaoImpl();
    @Override
    public boolean updateAddress(User user) {
        int i = userDao.updateAddress(user);
        return i>0;
    }

    @Override
    public boolean updatePassword(User user) {
        int i = userDao.updatePassword(user);
        return i>0;
    }

    @Override
    public List<User> findAll() {
        List<User> all = userDao.findAll();
        if (all != null) {
            System.out.println(all);
            return all;
        }
        return null;
    }

    @Override
    public User findById(int id) {
        User user = userDao.findById(id);
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        int i = userDao.updateUser(user);
        if (i>0){
            return true;
        }
        return false;
    }

}
