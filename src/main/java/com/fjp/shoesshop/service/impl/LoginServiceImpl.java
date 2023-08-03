package com.fjp.shoesshop.service.impl;

import com.fjp.shoesshop.dao.LoginDao;
import com.fjp.shoesshop.dao.impl.LoginDaoImpl;
import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.service.LoginService;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/28 1:50
 */
public class LoginServiceImpl implements LoginService {
  private LoginDao loginDao = new LoginDaoImpl();
    @Override
    public User login(String username, String password) {
        User login = loginDao.login(username,password);
        if (login!=null){
            return login;
        }
        return null;
    }
}
