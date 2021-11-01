/**
 * FileName: DutyAssignmentMapper
 * Author: 何锦川
 * Date: 2021/10/2 17:37
 * Description: 排班表DAO
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.mapper;

import com.loveshop.pojo.Admin;
import com.loveshop.pojo.DutyAssignment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <功能概述>
 * <排班表DAO>
 *
 * @author 何锦川
 * @create 2021/10/2 17:37
 * @since 1.0.0
 */

@Mapper
@Repository
public interface DutyAssignmentMapper {

    /**
     * 查找值班人员
     * @param time 当前时间
     * @return 当前值班人员列表
     */
    List<Admin> selectAdminOnDuty(@Param("time") String time);

    /**
     * 查找值班人员详情
     * @param time 当前时间
     * @return 当前值班人员详情列表
     */
    List<DutyAssignment> selectOnDutyDetail(@Param("time") String time);
}
