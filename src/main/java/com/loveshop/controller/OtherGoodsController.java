/**
 * FileName: OtherGoodsController
 * Author: 何锦川
 * Date: 2021/9/14 22:32
 * Description: 其他商品请求分发
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.controller;

import com.loveshop.pojo.OtherGoods;
import com.loveshop.service.OtherGoodsService;
import com.loveshop.utils.JsonUtils;
import com.loveshop.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <功能概述>
 * <其他商品请求分发>
 *
 * @author 何锦川
 * @create 2021/9/14 22:32
 * @since 1.0.0
 */

@RestController
@RequestMapping("/api/otherGoods")
public class OtherGoodsController {
    private OtherGoodsService otherGoodsService;

    @Autowired
    public void setOtherGoodsService(OtherGoodsService otherGoodsService) {
        this.otherGoodsService = otherGoodsService;
    }

    @RequestMapping("/add")
    public String add(OtherGoods otherGoods) {
        ResponseResult result = otherGoodsService.add(otherGoods);
        return JsonUtils.getJson(result);
    }

    @RequestMapping("/update")
    public String update(OtherGoods otherGoods) {
        ResponseResult result = otherGoodsService.update(otherGoods);
        return JsonUtils.getJson(result);
    }

    @RequestMapping("/sell")
    public String sell(String name, Integer amount, Long time, String admin) {
        return JsonUtils.getJson(otherGoodsService.sell(name, amount, time, admin));
    }

    @RequestMapping("/searchByName")
    public String searchByName(String name) {
        return JsonUtils.getJson(otherGoodsService.selectOtherGoodsByName(name));
    }

    @RequestMapping("/selectAll")
    public String selectAll() {
        ResponseResult result = otherGoodsService.selectAll();
        return JsonUtils.getJson(result);
    }

}
