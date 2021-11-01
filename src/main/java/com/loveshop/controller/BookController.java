/**
 * FileName: BookController
 * Author: 何锦川
 * Date: 2021/9/14 22:25
 * Description: 图书请求分发
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.controller;

import com.loveshop.pojo.Book;
import com.loveshop.service.BookService;
import com.loveshop.utils.JsonUtils;
import com.loveshop.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <功能概述>
 * <图书请求分发>
 *
 * @author 何锦川
 * @create 2021/9/14 22:25
 * @since 1.0.0
 */

@RestController
@RequestMapping("/api/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/add")
    public String add(Book book) {
        ResponseResult result = bookService.add(book);
        return JsonUtils.getJson(result);
    }

    @RequestMapping("/update")
    public String update(Book book) {
        ResponseResult result = bookService.update(book);
        return JsonUtils.getJson(result);
    }

    @RequestMapping("/sell")
    public String sell(String isbn, Integer amount, Long time, String admin) {
        return JsonUtils.getJson(bookService.sell(isbn, amount, time, admin));
    }

    @RequestMapping("/searchByIsbn")
    public String searchByIsbn(String isbn) {
        return JsonUtils.getJson(bookService.selectBookByIsbn(isbn));
    }

    @RequestMapping("/searchByName")
    public String searchByName(String bookName) {
        return JsonUtils.getJson(bookService.selectBookByName(bookName));
    }

    @RequestMapping("/selectAll")
    public String selectAll() {
        ResponseResult result = bookService.selectAll();
        return JsonUtils.getJson(result);
    }
}