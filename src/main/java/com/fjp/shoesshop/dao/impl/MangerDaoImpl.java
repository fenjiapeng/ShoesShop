package com.fjp.shoesshop.dao.impl;

import com.fjp.shoesshop.dao.MangerDao;
import com.fjp.shoesshop.pojo.Manger;
import com.fjp.shoesshop.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/31 20:39
 */
public class MangerDaoImpl implements MangerDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());

    @Override
    public Manger login(String username, String password) {
        String sql = "select * from manger where username =? and password = ?";
        try {
          return queryRunner.query(sql,new BeanHandler<Manger>(Manger.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
