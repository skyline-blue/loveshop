/**
 * FileName: BookMapper
 * Author: 何锦川
 * Date: 2021/9/16 13:06
 * Description: 图书类DAO
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.mapper;

import com.loveshop.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <功能概述>
 * <图书类DAO>
 *
 * @author 何锦川
 * @create 2021/9/16 13:06
 * @since 1.0.0
 */

@Mapper
@Repository
public interface BookMapper {
    /**
     * 添加图书
     * @param book 要添加的图书
     * @return 添加结果
     */
    int addNew(Book book);

    /**
     * 添加图书
     * @param book 要添加的图书
     * @return 添加结果
     */
    int addExist(Book book);

    /**
     * 售出图书
     * @param isbn 图书ISBN
     * @param amount 售出数量
     * @return 售出结果
     */
    int sell(@Param("isbn") String isbn, @Param("amount") Integer amount);


    /**
     * 通过ISBN查找图书
     * @param isbn 图书ISBN
     * @return 查找到的图书
     */
    Book selectBookByIsbn(@Param("isbn") String isbn);

    /**
     * 通过bookName查找图书
     * @param bookName 书名
     * @return 查找到的图书
     */
    List<Book> selectBookByName(@Param("bookName") String bookName);

    /**
     * 修改图书
     * @param book 要修改的图书
     * @return 修改结果
     */
    int update(Book book);

    /**
     * 查询所有图书
     * @return 所有图书
     */
    List<Book> selectAll();
}
