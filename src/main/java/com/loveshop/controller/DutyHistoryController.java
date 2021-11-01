/**
 * FileName: DutyHistoryController
 * Author: 何锦川
 * Date: 2021/10/5 18:55
 * Description:
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.controller;

import com.loveshop.service.DutyHistoryService;
import com.loveshop.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <功能概述>
 * <值班记录控制器>
 *
 * @author 何锦川
 * @create 2021/10/5 18:55
 * @since 1.0.0
 */

@RestController
@RequestMapping("/api/dutyHistory")
public class DutyHistoryController {

    private DutyHistoryService dutyHistoryService;

    @Autowired
    public void setDutyHistoryService(DutyHistoryService dutyHistoryService) {
        this.dutyHistoryService = dutyHistoryService;
    }

    @RequestMapping("/add")
    public String add(Integer aid, Long time) {
        return JsonUtils.getJson(dutyHistoryService.add(aid, time));
    }

    @RequestMapping("/searchLatestDate")
    public String add(Integer aid) {
        return JsonUtils.getJson(dutyHistoryService.searchLatestDate(aid));
    }

}
