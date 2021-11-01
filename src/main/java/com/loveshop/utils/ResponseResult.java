/**
 * FileName: ResponseResult
 * Author: 何锦川
 * Date: 2021/9/14 0:25
 * Description: 后端传递的结果
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.utils;

import java.util.HashMap;

/**
 * <功能概述>
 * <后端传递的结果>
 *
 * @author 何锦川
 * @create 2021/9/14 0:25
 * @since 1.0.0
 */
public class ResponseResult {

    private HashMap<String, Object> responseResultMap = new HashMap<>();

    public HashMap<String, Object> getResponseResultMap() {
        return responseResultMap;
    }

    public void setResponseResultMap(HashMap<String, Object> responseResultMap) {
        this.responseResultMap = responseResultMap;
    }

    public ResponseResult add(String key, Object value) {
        this.responseResultMap.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "result=" + responseResultMap +
                '}';
    }

    public Integer getStatus() {
        return (Integer) responseResultMap.get("status");
    }
}
