package com.fjp.shoesshop.dao.impl;

import com.fjp.shoesshop.dao.FindGoods;
import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.pojo.Page;
import com.fjp.shoesshop.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/27 0:18
 */
public class FindGoodsImpl implements FindGoods {
    private static QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    @Override
    public List<Goods> findGoods() {
        String sql = "select * from goods";
        try {
            return queryRunner.query(sql,new BeanListHandler<Goods>(Goods.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Goods findById(int id) {
        String sql = "select * from goods where id = ?";
        try {
           return queryRunner.query(sql,new BeanHandler<Goods>(Goods.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Goods> selectPages(Page page) {
        String sql = "select * from goods limit ?,?";
        try {
           return queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class), page.getStartRows(),page.getPageSize());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long selectCount() {
        String sql = "select count(*) from goods";
        try {
           return queryRunner.query(sql,new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
