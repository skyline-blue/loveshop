/**
 * FileName: OtherGoods
 * Author: 何锦川
 * Date: 2021/9/14 23:12
 * Description: 其他商品表
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.pojo;

/**
 * <功能概述>
 * <其他商品表>
 *
 * @author 何锦川
 * @create 2021/9/14 23:12
 * @since 1.0.0
 */
public class OtherGoods {
    private Integer id;
    private String name;
    private Integer amount;
    private Double price;

    public OtherGoods(Integer id, String name, Integer amount, Double price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public OtherGoods(String name, Integer amount, Double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public OtherGoods() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OtherGoods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
