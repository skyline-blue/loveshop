/**
 * FileName: Bill
 * Author: 何锦川
 * Date: 2021/9/14 23:13
 * Description: 账目表
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.pojo;

import java.util.Date;

/**
 * <功能概述>
 * <账目表>
 *
 * @author 何锦川
 * @create 2021/9/14 23:13
 * @since 1.0.0
 */
public class Bill {
    private Integer id;
    private String time;
    private String admin;
    private Double money;
    private String goods;
    private Integer amount;

    public Bill(Integer id, String time, String admin, Double money, String goods, Integer amount) {
        this.id = id;
        this.time = time;
        this.admin = admin;
        this.money = money;
        this.goods = goods;
        this.amount = amount;
    }

    public Bill(String time, String admin, Double money, String goods, Integer amount) {
        this.time = time;
        this.admin = admin;
        this.money = money;
        this.goods = goods;
        this.amount = amount;
    }

    public Bill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", time=" + time +
                ", admin='" + admin + '\'' +
                ", money=" + money +
                ", goods='" + goods + '\'' +
                ", amount=" + amount +
                '}';
    }
}
