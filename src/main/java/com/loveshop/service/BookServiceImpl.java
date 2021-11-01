/**
 * FileName: BookServiceImpl
 * Author: 何锦川
 * Date: 2021/9/16 17:02
 * Description:
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.service;

import com.loveshop.mapper.BillMapper;
import com.loveshop.mapper.BookMapper;
import com.loveshop.pojo.Bill;
import com.loveshop.pojo.Book;
import com.loveshop.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.print.DocFlavor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <功能概述>
 * <>
 *
 * @author 何锦川
 * @create 2021/9/16 17:02
 * @since 1.0.0
 */

@Service
public class BookServiceImpl implements BookService {
    private BookMapper bookMapper;
    private BillMapper billMapper;

    @Autowired
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Autowired
    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    /**
     * 添加图书
     *
     * @param book 要添加的图书
     * @return 添加结果
     */
    @Override
    public ResponseResult add(Book book) {
        ResponseResult result = new ResponseResult();

        try {
            if (bookMapper.selectBookByIsbn(book.getIsbn()) != null) {
                bookMapper.addExist(book);
            }else {
                bookMapper.addNew(book);
            }
            result.add("status", 500)
                    .add("message", "添加成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/book/add");
        }

        return result;
    }

    /**
     * 修改图书
     *
     * @param book 要修改的图书
     * @return 修改结果
     */
    @Override
    public ResponseResult update(Book book) {
        ResponseResult result = new ResponseResult();

        try {
            bookMapper.update(book);
            result.add("status", 500)
                    .add("message", "修改成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/book/update");
        }

        return result;
    }

    /**
     * 售出图书
     *
     * @param isbn   图书ISBN
     * @param amount 售出数量
     * @param time 售出时间
     * @return 售出结果
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public ResponseResult sell(String isbn, Integer amount, Long time, String admin) {
        ResponseResult result = new ResponseResult();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timeStr = sdf.format(time);
        try {
            Book book = bookMapper.selectBookByIsbn(isbn);
            if (book != null && book.getBookCount() >= amount) {
                bookMapper.sell(isbn, amount);
                Bill bill = new Bill(timeStr, admin, book.getBookPrice()*0.3*amount, book.getBookName(), amount);
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
                    .add("errorAPI", "api/book/sell");
        }

        return result;
    }

    /**
     * 通过ISBN查找图书
     *
     * @param isbn 图书ISBN
     * @return 查找到的图书
     */
    @Override
    public ResponseResult selectBookByIsbn(String isbn) {
        ResponseResult result = new ResponseResult();

        try {
            Book book = bookMapper.selectBookByIsbn(isbn);
            List<Book> bookList = new ArrayList<>();
            bookList.add(book);
            result.add("status", 500)
                    .add("message", "查找成功")
                    .add("bookList", bookList);
        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/book/searchByIsbn");
        }

        return result;
    }

    /**
     * 通过bookName查找图书
     *
     * @param bookName 书名
     * @return 查找到的图书
     */
    @Override
    public ResponseResult selectBookByName(String bookName) {
        ResponseResult result = new ResponseResult();

        try {
            List<Book> bookList = bookMapper.selectBookByName(bookName);
            result.add("status", 500)
                    .add("message", "查找成功")
                    .add("bookList", bookList);
        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/book/searchByName");
        }

        return result;
    }

    /**
     * 查询所有图书
     *
     * @return 所有图书
     */
    @Override
    public ResponseResult selectAll() {
        ResponseResult result = new ResponseResult();

        try {
            List<Book> bookList = bookMapper.selectAll();
            result.add("status", 500)
                    .add("message", "查询成功")
                    .add("bookList", bookList);
        }catch (Exception e) {
            e.printStackTrace();
            result.add("status", 400)
                    .add("message", "服务器错误！")
                    .add("errorAPI", "/api/book/selectAll");
        }

        return result;
    }
}
