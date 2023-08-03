package com.fjp.shoesshop.util;

import java.util.UUID;

/**
 * @author 高圆圆
 * @date 2023/4/20 11:42
 * 通过UUID产生随机字符串
 */
public class UUIDUtils {
    /**
     * 随机生成id
     * @return
     */
    public static String getId(){
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 生成随机码
     * @return
     */
    public static String getCode(){
        return getId();
    }
}
