/**
 * FileName: BillServiceImpl
 * Author: 何锦川
 * Date: 2021/9/20 13:58
 * Description:
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.service;

import com.loveshop.mapper.BillMapper;
import com.loveshop.pojo.Bill;
import com.loveshop.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <功能概述>
 * <>
 *
 * @author 何锦川
 * @create 2021/9/20 13:58
 * @since 1.0.0
 */

@Service
public class BillServiceImpl implements BillService {
    private BillMapper billMapper;

    @Autowired
    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    /**
     * 添加账目
     *
     * @param bill 要添加的账目
     * @return 添加结果
     */
    @Override
    public ResponseResult add(Bill bill) {
        ResponseResult result = new ResponseResult();

        try {
            billMapper.add(bill);
            result.add("status", 500)
                    .add("message", "记录成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/bill/add");
        }

        return result;
    }

    /**
     * 查询所有账目
     *
     * @return 账目信息列表
     */
    @Override
    public ResponseResult selectAll() {
        ResponseResult result = new ResponseResult();

        try {
            List<Bill> billList = billMapper.selectAll();
            result.add("status", 500)
                    .add("message", "查询成功")
                    .add("billList", billList);
        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/bill/selectAll");
        }

        return result;
    }

    /**
     * 获取当天总销售额
     *
     * @return 当天总销售额
     */
    @Override
    public ResponseResult getTodayTotalBill() {
        ResponseResult result = new ResponseResult();

        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = sdf.format(date);
            Double todayTotalBill = billMapper.getTodayTotalBill(dateStr);
            result.add("status", 500)
                    .add("message", "查询成功")
                    .add("todayTotalBill", todayTotalBill);
        } catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/bill/getTotalBillToday");
        }
        return result;
    }
}
