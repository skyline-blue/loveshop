/**
 * FileName: DutyHistoryService
 * Author: 何锦川
 * Date: 2021/10/5 18:40
 * Description:
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.service;

import com.loveshop.pojo.DutyHistory;
import com.loveshop.utils.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * <功能概述>
 * <值班日志服务>
 *
 * @author 何锦川
 * @create 2021/10/5 18:40
 * @since 1.0.0
 */

public interface DutyHistoryService {

    /**
     * 添加值班记录
     * @param aid 值班人员aid
     * @param time 打卡时间
     * @return 添加结果
     */
    ResponseResult add(Integer aid, Long time);

    /**
     * 查找该用户最近一次打卡时间
     * @param aid 用户aid
     * @return 用户最近一次打卡时间
     */
    ResponseResult searchLatestDate(Integer aid);
}
