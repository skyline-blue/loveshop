/**
 * FileName: DutyHistoryMapper
 * Author: 何锦川
 * Date: 2021/10/5 18:30
 * Description: 值班记录DAO
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.mapper;

import com.loveshop.pojo.DutyHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <功能概述>
 * <值班记录DAO>
 *
 * @author 何锦川
 * @create 2021/10/5 18:30
 * @since 1.0.0
 */

@Mapper
@Repository
public interface DutyHistoryMapper {

    /**
     * 添加值班记录
     * @param dutyHistory 值班记录
     * @return 添加结果
     */
    int add(DutyHistory dutyHistory);

    /**
     * 查找该用户最近一次打卡时间
     * @param aid 用户aid
     * @return 用户最近一次打卡时间
     */
    String searchLatestDate(@Param("aid") Integer aid);
}
