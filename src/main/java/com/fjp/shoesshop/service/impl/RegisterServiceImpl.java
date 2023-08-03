package com.fjp.shoesshop.service.impl;

import com.fjp.shoesshop.dao.Register;
import com.fjp.shoesshop.dao.impl.RegisterDaoImpl;
import com.fjp.shoesshop.pojo.User;
import com.fjp.shoesshop.service.RegisterService;

import java.sql.SQLException;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/31 17:25
 */
public class RegisterServiceImpl implements RegisterService {
    private Register register = new RegisterDaoImpl();
    @Override
    public boolean addUser(User user) {
        try {
            if(register.isUsernameExist(user.getUsername())){
                return false;
            }
            if (register.isEmailExist(user.getEmail())) {
                return false;
            }
            register.addUser(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
