package com.fjp.shoesshop.dao;

import com.fjp.shoesshop.pojo.Manger;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/31 20:39
 */
public interface MangerDao {

    Manger login(String username, String password);
}
