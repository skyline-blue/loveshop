/**
 * FileName: AdminDao
 * Author: 何锦川
 * Date: 2021/9/14 23:31
 * Description: 管理员DAO
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.mapper;

import com.loveshop.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <功能概述>
 * <管理员DAO>
 *
 * @author 何锦川
 * @create 2021/9/14 23:31
 * @since 1.0.0
 */

@Mapper
@Repository
public interface AdminMapper {
    /**
     * 管理员登录
     * @param studentId 学号
     * @param password 密码
     * @return 查询结果
     */
    Admin selectAdminByStudentIdAndPassword(@Param("studentId") String studentId, @Param("password") String password);

    /**
     * 查询所有管理员信息
     * @return 管理员信息列表
     */
    List<Admin> selectAllAdminInfo();

    /**
     * 添加积分
     * @param aid aid
     * @param point 积分
     * @return 添加结果
     */
    int addPoints(@Param("aid") Integer aid, @Param("point") Double point);
}
