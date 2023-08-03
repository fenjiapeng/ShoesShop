package com.fjp.shoesshop.service;

import com.fjp.shoesshop.dao.MangerDao;
import com.fjp.shoesshop.pojo.Manger;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/31 20:45
 */
public interface MangerService {

    Manger login(String username, String password);
}
