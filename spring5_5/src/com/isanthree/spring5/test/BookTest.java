package com.isanthree.spring5.test;

import com.isanthree.spring5.entity.Book;
import com.isanthree.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/*
 * 创建 「book_db 数据库」和 「books 表」的 sql 语句：
 * create database book_db;
 * create table books(bookID int(20) not null primary key, bookName varchar(255) not null, bookNumber varchar(255) not null);
 */

/**
 * 测试类
 */
public class BookTest {
    /**
     * 增
     */
    @Test
    public void testJdbcTemplateAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        Book book = new Book();
        book.setBookID("1");
        book.setBookName("C");
        book.setBookNumber("2");
        bookService.addBook(book);
    }

    /**
     * 增：批量添加
     */
    @Test
    public void testJdbcTemplateBatchAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"2", "Java", "6"};
        Object[] o2 = {"3", "C", "3"};
        Object[] o3 = {"4", "MySQL", "1"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);

        bookService.batchAddBook(batchArgs);  // 调用方法进行批量添加
    }

    /**
     * 删
     */
    @Test
    public void testJdbcTemplateDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        Book book = new Book();
        book.setBookID("1");
        bookService.deleteBook(book.getBookID());
    }

    /**
     * 改：批量删除
     */
    @Test
    public void testJdbcTemplateBatchDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"3"};
        Object[] o2 = {"4"};
        batchArgs.add(o1);
        batchArgs.add(o2);

        bookService.batchDeleteBook(batchArgs);  // 调用方法进行批量删除
    }

    /**
     * 改
     */
    @Test
    public void testJdbcTemplateUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        Book book = new Book();
        book.setBookID("1");
        book.setBookName("Cpp");
        book.setBookNumber("None");
        bookService.updateBook(book);
    }

    /**
     * 改：批量修改
     */
    @Test
    public void testJdbcTemplateBatchUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"Java", "3", "3"};
        Object[] o2 = {"Cpp", "4", "4"};
        Object[] o3 = {"MySQL", "5", "5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);

        bookService.batchUpdateBook(batchArgs);  // 调用方法进行批量修改
    }

    /**
     * 查
     */
    @Test
    public void testJdbcTemplateSelect() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        // 查询表的目录数
        int count = bookService.findCount();
        System.out.println("表中有 " + count + " 条记录");

        // 查询返回对象
        Book book = bookService.findOne("1");
        System.out.println(book);

        // 查询返回集合
        List<Book> bookList = bookService.findAll();
        System.out.println(bookList);
    }
}
