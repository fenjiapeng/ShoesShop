package com.fjp.shoesshop.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/26 19:32
 */
public class DruidUtil {

    private static Properties properties = new Properties();
    private static DruidDataSource dataSource = null;

    static {
        Evn instance = Evn.getInstance();
        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(instance);
            dataSource.setDriverClassName(Evn.getInstance().getProperty("driver"));
            dataSource.setUrl(Evn.getInstance().getProperty("url"));
            dataSource.setUsername(Evn.getInstance().getProperty("username"));
            dataSource.setPassword(Evn.getInstance().getProperty("password"));
            dataSource.setMaxActive(Integer.parseInt(Evn.getInstance().getProperty("maxActive")));
            dataSource.setMaxWait(Long.parseLong(Evn.getInstance().getProperty("maxWait")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConn(){
        try {
          return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}

