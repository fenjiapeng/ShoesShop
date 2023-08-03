package com.fjp.shoesshop.dao.impl;

import com.fjp.shoesshop.dao.GoodsDao;
import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/4 1:10
 */
public class GoodsDaoImpl implements GoodsDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    @Override
    public int deleteGoods() {
        return 0;
    }

    @Override
    public List<Goods> findAll() {
        String sql = "select * from goods";
        try {
           return queryRunner.query(sql,new BeanListHandler<Goods>(Goods.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
