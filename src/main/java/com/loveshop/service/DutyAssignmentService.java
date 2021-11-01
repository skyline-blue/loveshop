/**
 * FileName: DutyAssignmentService
 * Author: 何锦川
 * Date: 2021/10/2 17:51
 * Description: 排班表服务
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.service;

import com.loveshop.utils.ResponseResult;


/**
 * <功能概述>
 * <排班表服务>
 *
 * @author 何锦川
 * @create 2021/10/2 17:51
 * @since 1.0.0
 */
public interface DutyAssignmentService {
    /**
     * 查找值班人员
     * @param time 当前时间
     * @return 当前值班人员列表
     */
    ResponseResult selectAdminOnDuty(String time);
}
