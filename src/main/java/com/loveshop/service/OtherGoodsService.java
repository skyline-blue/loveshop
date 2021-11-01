/**
 * FileName: OtherGoodsService
 * Author: 何锦川
 * Date: 2021/9/21 21:35
 * Description: 其他商品服务
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.service;

import com.loveshop.pojo.OtherGoods;
import com.loveshop.utils.ResponseResult;

/**
 * <功能概述>
 * <其他商品服务>
 *
 * @author 何锦川
 * @create 2021/9/21 21:35
 * @since 1.0.0
 */
public interface OtherGoodsService {
    /**
     * 添加其他商品
     * @param otherGoods 要添加的其他商品
     * @return 添加结果
     */
    ResponseResult add(OtherGoods otherGoods);

    /**
     * 修改其他商品
     * @param otherGoods 要修改的其他商品
     * @return 修改结果
     */
    ResponseResult update(OtherGoods otherGoods);

    /**
     * 售出其他商品
     * @param name 商品名
     * @param amount 售出数量
     * @param time 售出时间
     * @param admin 收银
     * @return 售出结果
     */
    ResponseResult sell(String name, Integer amount, Long time, String admin);

    /**
     * 通过名字查找商品
     * @param name 商品名
     * @return 查找到的商品
     */
    ResponseResult selectOtherGoodsByFullName(String name);


    /**
     * 通过名字查找商品
     * @param name 商品名
     * @return 查找到的商品
     */
    ResponseResult selectOtherGoodsByName(String name);

    /**
     * 查询所有其他商品
     * @return 所有其他商品
     */
    ResponseResult selectAll();
}
