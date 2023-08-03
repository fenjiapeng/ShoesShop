package com.fjp.shoesshop.test;

import com.fjp.shoesshop.dao.impl.LoginDaoImpl;
import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.service.impl.LoginServiceImpl;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/28 11:28
 */
public class dataTest {
    public static void main(String[] args) {
        LoginDaoImpl loginDao = new LoginDaoImpl();
        User login = loginDao.login("admin", "admin");
        System.out.println(login);
        LoginServiceImpl loginService = new LoginServiceImpl();
        User login1 = loginService.login("admin", "admin");
        System.out.println(login1);
    }

}
