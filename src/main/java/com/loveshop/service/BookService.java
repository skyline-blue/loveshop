/**
 * FileName: BookService
 * Author: 何锦川
 * Date: 2021/9/16 17:01
 * Description: 图书服务
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.service;

import com.loveshop.pojo.Book;
import com.loveshop.utils.ResponseResult;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <功能概述>
 * <图书服务>
 *
 * @author 何锦川
 * @create 2021/9/16 17:01
 * @since 1.0.0
 */
public interface BookService {
    /**
     * 添加图书
     * @param book 要添加的图书
     * @return 添加结果
     */
    ResponseResult add(Book book);

    /**
     * 修改图书
     * @param book 要修改的图书
     * @return 修改结果
     */
    ResponseResult update(Book book);

    /**
     * 售出图书
     * @param isbn 图书ISBN
     * @param amount 售出数量
     * @param time 售出时间
     * @param admin 收银
     * @return 售出结果
     */
    ResponseResult sell(String isbn, Integer amount, Long time, String admin);


    /**
     * 通过ISBN查找图书
     * @param isbn 图书ISBN
     * @return 查找到的图书
     */
    ResponseResult selectBookByIsbn(String isbn);

    /**
     * 通过bookName查找图书
     * @param bookName 书名
     * @return 查找到的图书
     */
    ResponseResult selectBookByName(String bookName);

    /**
     * 查询所有图书
     * @return 所有图书
     */
    ResponseResult selectAll();
}
