/**
 * FileName: AdminServiceImpl
 * Author: 何锦川
 * Date: 2021/9/15 16:32
 * Description:
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.service;

import com.loveshop.mapper.AdminMapper;
import com.loveshop.pojo.Admin;
import com.loveshop.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <功能概述>
 * <>
 *
 * @author 何锦川
 * @create 2021/9/15 16:32
 * @since 1.0.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;

    @Autowired
    public void setAdminDao(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     * 管理员登录
     *
     * @param studentId 学号
     * @param password  密码
     * @return 查询结果
     */
    @Override
    public ResponseResult login(String studentId, String password, HttpServletRequest request) {
        ResponseResult result = new ResponseResult();
        try {
            Admin admin = adminMapper.selectAdminByStudentIdAndPassword(studentId, password);
            if (admin != null) {
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                result.add("status", 500)
                        .add("message", "登录成功")
                        .add("aid", admin.getAid())
                        .add("aname", admin.getAname())
                        .add("studentId", admin.getStudentId())
                        .add("phone", admin.getPhone())
                        .add("QQ", admin.getQq())
                        .add("school", admin.getSchool())
                        .add("level", admin.getLevel())
                        .add("dept", admin.getDept())
                        .add("points", admin.getPoints());
            }else {
                result.add("status", 501)
                        .add("message", "用户名或密码错误");
            }

        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/admin/login");
        }

        return result;
    }

    /**
     * 查询所有管理员信息
     *
     * @return 管理员信息列表
     */
    @Override
    public ResponseResult selectAllAdminInfo() {
        ResponseResult result = new ResponseResult();
        try {
            List<Admin> adminList = adminMapper.selectAllAdminInfo();
            result.add("status", 500)
                    .add("message", "查找成功")
                    .add("adminList", adminList);
        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/admin/showAllAdminInfo");
        }

        return result;
    }
}
