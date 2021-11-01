/**
 * FileName: OtherGoodsMapper
 * Author: 何锦川
 * Date: 2021/9/21 21:20
 * Description: 其他商品DAO
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.mapper;

import com.loveshop.pojo.Book;
import com.loveshop.pojo.OtherGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <功能概述>
 * <其他商品DAO>
 *
 * @author 何锦川
 * @create 2021/9/21 21:20
 * @since 1.0.0
 */

@Mapper
@Repository
public interface OtherGoodsMapper {
    /**
     * 添加商品
     * @param otherGoods 要添加的商品
     * @return 添加结果
     */
    int addNew(OtherGoods otherGoods);

    /**
     * 添加商品
     * @param otherGoods 要添加的商品
     * @return 添加结果
     */
    int addExist(OtherGoods otherGoods);

    /**
     * 售出商品
     * @param name 商品名
     * @param amount 售出数量
     * @return 售出结果
     */
    int sell(@Param("name") String name, @Param("amount") Integer amount);

    /**
     * 修改商品
     * @param otherGoods 要修改的商品
     * @return 修改结果
     */
    int update(OtherGoods otherGoods);

    /**
     * 通过名字查找商品
     * @param name 商品名
     * @return 查找到的商品
     */
    OtherGoods selectOtherGoodsByFullName(@Param("name") String name);

    /**
     * 通过名字查找商品
     * @param name 商品名
     * @return 查找到的商品
     */
    List<OtherGoods> selectOtherGoodsByName(@Param("name") String name);

    /**
     * 查询所有其他商品
     * @return 所有商品
     */
    List<OtherGoods> selectAll();
}
