/**
 * FileName: BillMapper
 * Author: 何锦川
 * Date: 2021/9/20 13:48
 * Description: 账目DAO
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.mapper;

import com.loveshop.pojo.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <功能概述>
 * <账目DAO>
 *
 * @author 何锦川
 * @create 2021/9/20 13:48
 * @since 1.0.0
 */

@Mapper
@Repository
public interface BillMapper {

    /**
     * 添加账目
     * @param bill 要添加的账目
     * @return 添加结果
     */
    Integer add(Bill bill);

    /**
     * 查询所有账目
     * @return 账目信息列表
     */
    List<Bill> selectAll();

    /**
     * 获取当天总销售额
     * @param dateToday 当前日期
     * @return 当天总销售额
     */
    Double getTodayTotalBill(@Param("dateToday") String dateToday);

}
