/**
 * FileName: Book
 * Author: 何锦川
 * Date: 2021/9/14 23:12
 * Description: 图书表
 * History:
 * <author>      <time>      <version>      <des>
 * 作者姓名      修改时间        版本号        描述
 */
package com.loveshop.pojo;

import org.springframework.context.annotation.Bean;

/**
 * <功能概述>
 * <图书表>
 *
 * @author 何锦川
 * @create 2021/9/14 23:12
 * @since 1.0.0
 */
public class Book {
    private Integer bid;
    private String isbn;
    private String bookName;
    private Integer bookCount;
    private Double bookPrice;
    private String author;
    private String location;

    public Book(Integer bid, String isbn, String bookName, Integer bookCount, Double bookPrice, String author, String location) {
        this.bid = bid;
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookCount = bookCount;
        this.bookPrice = bookPrice;
        this.author = author;
        this.location = location;
    }

    public Book(String isbn, String bookName, Integer bookCount, Double bookPrice, String author, String location) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookCount = bookCount;
        this.bookPrice = bookPrice;
        this.author = author;
        this.location = location;
    }

    public Book() {
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookCount=" + bookCount +
                ", bookPrice=" + bookPrice +
                ", author='" + author + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
