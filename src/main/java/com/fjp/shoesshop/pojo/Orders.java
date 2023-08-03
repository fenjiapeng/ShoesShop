package com.fjp.shoesshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.sql.Timestamp;

/**
 * @author fjp
 * @version 1.0
 * @description: TODO
 * @date 2023/8/3 10:47
 * `itemid` varchar(255) NOT NULL,
 *   `count` int DEFAULT NULL,
 *   `subtotal` varchar(255) DEFAULT NULL,
 *   `gid` int DEFAULT NULL,
 *   `oid` varchar(255) DEFAULT NULL,
 */
public class Orders {
   private String id;
   private Date ordertime;
   private double total;
   private int state;
   private String address;
   private String name;
   private String phone;
   private User user;
  private List<OrderItem> list = new LinkedList<>();

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public Date getOrdertime() {
      return ordertime;
   }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
      return total;
   }

   public void setTotal(double total) {
      this.total = total;
   }

   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public List<OrderItem> getList() {
      return list;
   }

   public void setList(List<OrderItem> list) {
      this.list = list;
   }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", state=" + state +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
