package com.fjp.shoesshop.service;

import com.fjp.shoesshop.pojo.User;

public interface LoginService {

    User login(String username , String password);
}
