package com.fjp.shoesshop.pojo;

import com.fjp.shoesshop.dao.MangerDao;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/7/31 20:34
 */
public class Manger {
    private int id;
    private String username;
    private String password;


    @Override
    public String toString() {
        return "Manger{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
