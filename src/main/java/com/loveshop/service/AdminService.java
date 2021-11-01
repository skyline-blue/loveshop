/**
 * FileName: AdminService
 * Author: 何锦川
 * Date: 2021/9/15 16:31
 * Description: 管理员服务
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.service;

import com.loveshop.pojo.Admin;
import com.loveshop.utils.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <功能概述>
 * <管理员服务>
 *
 * @author 何锦川
 * @create 2021/9/15 16:31
 * @since 1.0.0
 */
public interface AdminService {
    /**
     * 管理员登录
     * @param studentId 学号
     * @param password 密码
     * @return 查询结果
     */
    ResponseResult login(String studentId, String password, HttpServletRequest request);

    /**
     * 查询所有管理员信息
     * @return 管理员信息列表
     */
    ResponseResult selectAllAdminInfo();
}
