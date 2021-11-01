/**
 * FileName: BillService
 * Author: 何锦川
 * Date: 2021/9/20 13:57
 * Description: 账目类服务
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.service;

import com.loveshop.pojo.Bill;
import com.loveshop.utils.ResponseResult;
import org.apache.ibatis.annotations.Param;

/**
 * <功能概述>
 * <账目类服务>
 *
 * @author 何锦川
 * @create 2021/9/20 13:57
 * @since 1.0.0
 */
public interface BillService {

    /**
     * 添加账目
     * @param bill 要添加的账目
     * @return 添加结果
     */
    ResponseResult add(Bill bill);

    /**
     * 查询所有账目
     * @return 账目信息列表
     */
    ResponseResult selectAll();

    /**
     * 获取当天总销售额
     * @return 当天总销售额
     */
    ResponseResult getTodayTotalBill();

}
