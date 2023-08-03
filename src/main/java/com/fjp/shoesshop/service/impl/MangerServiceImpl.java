package com.fjp.shoesshop.service.impl;

import com.fjp.shoesshop.dao.MangerDao;
import com.fjp.shoesshop.dao.impl.MangerDaoImpl;
import com.fjp.shoesshop.pojo.Manger;
import com.fjp.shoesshop.service.MangerService;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/31 20:45
 */
public class MangerServiceImpl implements MangerService {
    private MangerDao manger = new MangerDaoImpl();
    @Override
    public Manger login(String username, String password) {
        Manger mangerlogin = manger.login(username, password);
        if (mangerlogin != null){
            return mangerlogin;
        }
        return null;
    }
}
