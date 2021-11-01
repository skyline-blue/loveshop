/**
 * FileName: DutyAssignmentServiceImpl
 * Author: 何锦川
 * Date: 2021/10/2 17:53
 * Description:
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.service;

import com.loveshop.mapper.DutyAssignmentMapper;
import com.loveshop.pojo.Admin;
import com.loveshop.pojo.DutyAssignment;
import com.loveshop.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <功能概述>
 * <>
 *
 * @author 何锦川
 * @create 2021/10/2 17:53
 * @since 1.0.0
 */

@Service
public class DutyAssignmentServiceImpl implements DutyAssignmentService {

    private DutyAssignmentMapper dutyAssignmentMapper;

    @Autowired
    public void setDutyAssignmentMapper(DutyAssignmentMapper dutyAssignmentMapper) {
        this.dutyAssignmentMapper = dutyAssignmentMapper;
    }

    /**
     * 查找值班人员
     *
     * @param time 当前时间
     * @return 当前值班人员列表
     */
    @Override
    public ResponseResult selectAdminOnDuty(String time) {
        ResponseResult result = new ResponseResult();

        try {
            List<Admin> onDutyAdminList = dutyAssignmentMapper.selectAdminOnDuty(time);
            List<DutyAssignment> onDutyAdminDetail = dutyAssignmentMapper.selectOnDutyDetail(time);

            List<OnDutyAdminResult> onDutyAdminResultList = new ArrayList<>();

            for (Admin onDutyAdmin: onDutyAdminList) {
                for (DutyAssignment dutyDetail: onDutyAdminDetail) {
                    if (onDutyAdmin.getAid().equals(dutyDetail.getAid())) {
                        onDutyAdminResultList.add(new OnDutyAdminResult(onDutyAdmin.getAid(), onDutyAdmin.getAname(), dutyDetail.getDetail()));
                    }
                }
            }

            result.add("status", 500)
                    .add("message", "查询成功")
                    .add("onDutyAdminResultList", onDutyAdminResultList);
        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/duty/getOnDutyAdmin");
        }

        return result;
    }

    static class OnDutyAdminResult {
        Integer aid;
        String aname;
        String detail;

        public OnDutyAdminResult(Integer aid, String aname, String detail) {
            this.aid = aid;
            this.aname = aname;
            this.detail = detail;
        }

        public Integer getAid() {
            return aid;
        }

        public void setAid(Integer aid) {
            this.aid = aid;
        }

        public String getAname() {
            return aname;
        }

        public void setAname(String aname) {
            this.aname = aname;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

}
