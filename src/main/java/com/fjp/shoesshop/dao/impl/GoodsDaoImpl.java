package com.fjp.shoesshop.dao.impl;

import com.fjp.shoesshop.dao.GoodsDao;
import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
    public int deleteGoods(int id) {
        String sql = "delete from goods where id =?";
        try {
           return queryRunner.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public Goods findById(int id) {
        String sql = "select * from goods where id =?";
        try {
           return queryRunner.query(sql,new BeanHandler<Goods>(Goods.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateGood(Goods goods) {
        String sql = "update goods set name=?,image=?,price=?,gdesc=?,stock=?,type_id=? where id=?";
        try {
           return queryRunner.update(sql,goods.getName()
                    ,goods.getImage()
                    ,goods.getPrice(),goods.getGdesc(),goods.getStock(),goods.getType_id(),goods.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
