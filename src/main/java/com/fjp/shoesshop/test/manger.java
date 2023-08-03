package com.fjp.shoesshop.test;

import com.fjp.shoesshop.dao.MangerDao;
import com.fjp.shoesshop.dao.impl.MangerDaoImpl;
import com.fjp.shoesshop.pojo.Manger;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/31 22:45
 */
public class manger {
    public static void main(String[] args) {
        MangerDaoImpl mangerDao = new MangerDaoImpl();
        Manger login = mangerDao.login("admin", "admin");
        System.out.println(login);
    }
}
