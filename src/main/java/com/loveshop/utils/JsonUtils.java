/**
 * FileName: JsonUtils
 * Author: 何锦川
 * Date: 2021/9/14 0:23
 * Description: JSON数据转换
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * <功能概述>
 * <JSON数据转换>
 *
 * @author 何锦川
 * @create 2021/9/14 0:23
 * @since 1.0.0
 */
public class JsonUtils {

    /**
     * 转换java对象为JSON
     * @param obj 被转换的java对象
     * @param dateFormat 期望转换的日期格式
     * @return 转换后的JSON字符串
     */
    public static String getJson(Object obj, String dateFormat) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 重载方法
     * @param obj 被转换的java对象
     * @return 转换后的JSON字符串
     */
    public static String getJson(Object obj) {
        return getJson(obj, "yyyy-MM-dd HH:mm-ss");
    }
}
