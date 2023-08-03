package com.fjp.shoesshop.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/26 19:32
 */
public class Evn extends Properties {

    private static Evn instance;

    private Evn(){
        try {
            load(getClass().getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Evn getInstance(){
        if (instance == null) {
            instance = new Evn();
        }
        return instance;
    }
}
