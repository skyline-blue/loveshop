/**
 * FileName: DutyHistoryServiceImpl
 * Author: 何锦川
 * Date: 2021/10/5 18:44
 * Description:
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.service;

import com.loveshop.mapper.AdminMapper;
import com.loveshop.mapper.DutyHistoryMapper;
import com.loveshop.pojo.DutyHistory;
import com.loveshop.utils.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;

/**
 * <功能概述>
 * <>
 *
 * @author 何锦川
 * @create 2021/10/5 18:44
 * @since 1.0.0
 */

@Service
public class DutyHistoryServiceImpl implements DutyHistoryService {

    private DutyHistoryMapper dutyHistoryMapper;
    private AdminMapper adminMapper;

    @Autowired
    public void setDutyHistoryMapper(DutyHistoryMapper dutyHistoryMapper) {
        this.dutyHistoryMapper = dutyHistoryMapper;
    }

    @Autowired
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     * 添加值班记录
     *
     * @param aid 值班人员aid
     * @param time 打卡时间
     * @return 添加结果
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public ResponseResult add(Integer aid, Long time) {
        ResponseResult result = new ResponseResult();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timeStr = sdf.format(time);
        DutyHistory newDutyHistory = new DutyHistory(aid, timeStr);

        try {
            dutyHistoryMapper.add(newDutyHistory);
            adminMapper.addPoints(aid, 1.5);
            result.add("status", 500)
                    .add("message", "添加值班记录成功");
        }catch (Exception e) {
            e.printStackTrace();
            // 手动事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.add("status", 400)
                    .add("message", "添加值班记录失败")
                    .add("errorAPI", "api/dutyHistory/add");
        }

        return result;
    }

    /**
     * 查找该用户最近一次打卡时间
     *
     * @param aid 用户aid
     * @return 用户最近一次打卡时间
     */
    @Override
    public ResponseResult searchLatestDate(Integer aid) {
        ResponseResult result = new ResponseResult();

        try {
            String dateStr = dutyHistoryMapper.searchLatestDate(aid);
            result.add("status", 500)
                    .add("message", "查找值班记录成功")
                    .add("dateStr", dateStr);

        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "查找值班记录失败")
                    .add("errorAPI", "api/dutyHistory/searchLatest");
        }

        return result;
    }
}
