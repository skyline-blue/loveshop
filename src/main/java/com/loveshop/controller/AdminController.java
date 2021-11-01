/**
 * FileName: AdminController
 * Author: 何锦川
 * Date: 2021/9/15 16:34
 * Description: 管理员请求分发
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.controller;

import com.loveshop.service.AdminService;
import com.loveshop.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <功能概述>
 * <管理员请求分发>
 *
 * @author 何锦川
 * @create 2021/9/15 16:34
 * @since 1.0.0
 */

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/login")
    public String login(String studentId, String password, HttpServletRequest request) {
        return JsonUtils.getJson(adminService.login(studentId, password, request));
    }

    @RequestMapping("/showAllAdminInfo")
    public String showAllAdminInfo() {
        return JsonUtils.getJson(adminService.selectAllAdminInfo());
    }
}
