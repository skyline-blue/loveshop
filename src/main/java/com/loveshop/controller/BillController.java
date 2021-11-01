/**
 * FileName: BillController
 * Author: 何锦川
 * Date: 2021/9/20 14:01
 * Description:
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.controller;

import com.loveshop.service.BillService;
import com.loveshop.utils.JsonUtils;
import com.loveshop.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <功能概述>
 * <账目类请求分发>
 *
 * @author 何锦川
 * @create 2021/9/20 14:01
 * @since 1.0.0
 */

@RestController
@RequestMapping("/api/bill")
public class BillController {
    private BillService billService;

    @Autowired
    public void setBillService(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping("/selectAll")
    public String selectAll() {
        ResponseResult result = billService.selectAll();
        return JsonUtils.getJson(result);
    }

    @RequestMapping("/getTodayTotalBill")
    public String getTodayTotalBill() {
        ResponseResult result = billService.getTodayTotalBill();
        return JsonUtils.getJson(result);
    }

}
