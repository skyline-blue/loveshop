/**
 * FileName: OtherGoodsServiceImpl
 * Author: 何锦川
 * Date: 2021/9/21 21:39
 * Description:
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.service;

import com.loveshop.mapper.BillMapper;
import com.loveshop.mapper.OtherGoodsMapper;
import com.loveshop.pojo.Bill;
import com.loveshop.pojo.Book;
import com.loveshop.pojo.OtherGoods;
import com.loveshop.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <功能概述>
 * <>
 *
 * @author 何锦川
 * @create 2021/9/21 21:39
 * @since 1.0.0
 */

@Service
public class OtherGoodsServiceImpl implements OtherGoodsService {
    private OtherGoodsMapper otherGoodsMapper;
    private BillMapper billMapper;

    @Autowired
    public void setOtherGoodsMapper(OtherGoodsMapper otherGoodsMapper) {
        this.otherGoodsMapper = otherGoodsMapper;
    }

    @Autowired
    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    /**
     * 添加其他商品
     *
     * @param otherGoods 要添加的其他商品
     * @return 添加结果
     */
    @Override
    public ResponseResult add(OtherGoods otherGoods) {
        ResponseResult result = new ResponseResult();

        try {
            if (otherGoodsMapper.selectOtherGoodsByFullName(otherGoods.getName()) != null) {
                otherGoodsMapper.addExist(otherGoods);
            }else {
                otherGoodsMapper.addNew(otherGoods);
            }
            result.add("status", 500)
                    .add("message", "添加成功");

        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/others/add");
        }

        return result;
    }

    /**
     * 修改其他商品
     *
     * @param otherGoods 要修改的其他商品
     * @return 修改结果
     */
    @Override
    public ResponseResult update(OtherGoods otherGoods) {
        return null;
    }

    /**
     * 售出其他商品
     *
     * @param name   商品名
     * @param amount 售出数量
     * @param time 售出时间
     * @param admin 收银
     * @return 售出结果
     */
    @Override
    public ResponseResult sell(String name, Integer amount, Long time, String admin) {
        ResponseResult result = new ResponseResult();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timeStr = sdf.format(time);
        try {
            OtherGoods otherGoods = otherGoodsMapper.selectOtherGoodsByFullName(name);
            if (otherGoods != null && otherGoods.getAmount() >= amount) {
                otherGoodsMapper.sell(name, amount);
                Bill bill = new Bill(timeStr, admin, otherGoods.getPrice()*amount, otherGoods.getName(), amount);
                billMapper.add(bill);
                result.add("status", 500)
                        .add("message", "售出成功");
            }else {
                result.add("status", 501)
                        .add("message", "商品数量不足或没有此商品");
            }
        }catch (Exception e) {
            e.printStackTrace();
            // 手动事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "api/otherGoods/sell");
        }

        return result;
    }

    /**
     * 通过名字查找商品
     *
     * @param name 商品名
     * @return 查找到的商品
     */
    @Override
    public ResponseResult selectOtherGoodsByFullName(String name) {
        ResponseResult result = new ResponseResult();

        try {
            OtherGoods otherGoods = otherGoodsMapper.selectOtherGoodsByFullName(name);
            result.add("status", 500)
                    .add("message", "查询成功")
                    .add("otherGoods", otherGoods);
        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/otherGoods/searchByFullName");
        }

        return result;
    }

    /**
     * 通过名字查找商品
     *
     * @param name 商品名
     * @return 查找到的商品
     */
    @Override
    public ResponseResult selectOtherGoodsByName(String name) {
        ResponseResult result = new ResponseResult();

        try {
            List<OtherGoods> otherGoodsList = otherGoodsMapper.selectOtherGoodsByName(name);
            result.add("status", 500)
                    .add("message", "查询成功")
                    .add("otherGoodsList", otherGoodsList);
        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/otherGoods/searchByName");
        }

        return result;
    }

    /**
     * 查询所有其他商品
     *
     * @return 所有其他商品
     */
    @Override
    public ResponseResult selectAll() {
        ResponseResult result = new ResponseResult();

        try {
            List<OtherGoods> otherGoodsList = otherGoodsMapper.selectAll();
            result.add("status", 500)
                    .add("message", "查询成功")
                    .add("otherGoodsList", otherGoodsList);
        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/otherGoods/selectAll");
        }

        return result;
    }
}
