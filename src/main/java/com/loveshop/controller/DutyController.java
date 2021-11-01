/**
 * FileName: DutyController
 * Author: 何锦川
 * Date: 2021/10/2 17:57
 * Description: 值班控制器
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.controller;

import com.loveshop.mapper.DutyAssignmentMapper;
import com.loveshop.service.DutyAssignmentService;
import com.loveshop.utils.JsonUtils;
import com.loveshop.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <功能概述>
 * <值班控制器>
 *
 * @author 何锦川
 * @create 2021/10/2 17:57
 * @since 1.0.0
 */

@RestController
@RequestMapping("/api/duty")
public class DutyController {

    private DutyAssignmentService dutyAssignmentService;

    @Autowired
    public void setDutyAssignmentService(DutyAssignmentService dutyAssignmentService) {
        this.dutyAssignmentService = dutyAssignmentService;
    }

    @RequestMapping("/getOnDutyAdmin")
    public String getOnDutyAdmin(String time) {
        return JsonUtils.getJson(dutyAssignmentService.selectAdminOnDuty(time));
    }
}
