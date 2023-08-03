package com.fjp.shoesshop.dao;

import com.fjp.shoesshop.pojo.User;

/**
 * @author fjc23
 */
public interface LoginDao {

    /**
     * 通过username查找
     * @param username
     * @return
     */
    User login(String username, String password);
}
