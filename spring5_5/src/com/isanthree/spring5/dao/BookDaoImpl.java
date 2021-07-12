package com.isanthree.spring5.dao;

import com.isanthree.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    // 注入 JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加方法实现
    @Override
    public void add(Book book) {

        // 1.创建 mysql 语句
        String sql = "insert into books values(?, ?, ?)";
        // 2.调用方法实现
        Object[] args = {book.getBookID(), book.getBookName(), book.getBookNumber()};
        int update = jdbcTemplate.update(sql, args);

        System.out.println("BookDaoImpl :: add() 成功执行 " + update + " 个 sql 语句");
    }

    // 批量添加方法实现
    @Override
    public void batchAdd(List<Object[]> batchArgs) {
        String sql = "insert into books values(?, ?, ?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);  // JdbcTemplate 提供的批量添加方法
        System.out.println("BookDaoImpl :: batchAdd() 成功执行");
        System.out.println(Arrays.toString(ints));
    }

    // 修改方法实现
    @Override
    public void update(Book book) {
        String sql = "update books set bookName=?, bookNumber=? where bookID=?";
        Object[] args = {book.getBookName(), book.getBookNumber(), book.getBookID()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println("BookDaoImpl :: update() 成功执行 " + update + " 个 sql 语句");
    }

    // 批量修改方法实现
    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        String sql = "update books set bookName=?, bookNumber=? where bookID=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);  // JdbcTemplate 提供的批量修改方法
        System.out.println("BookDaoImpl :: batchUpdate() 成功执行");
        System.out.println(Arrays.toString(ints));
    }

    // 删除方法实现
    @Override
    public void delete(String id) {
        String sql = "delete from books where bookID=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println("BookDaoImpl :: delete() 成功执行 " + update + " 个 sql 语句");
    }

    // 批量删除方法实现
    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        String sql = "delete from books where bookID=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);  // JdbcTemplate 提供的批量删除方法
        System.out.println("BookDaoImpl :: batchDelete() 成功执行");
        System.out.println(Arrays.toString(ints));
    }

    // 查询方法实现：查询表的记录数量
    @Override
    public int selectCount() {
        String sql = "select count(*) from books";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("BookDaoImpl :: selectCount() 成功执行：查询 books 表的记录数");
        return count;
    }

    // 查询方法实现：查询返回对象（即表中的某一条记录）
    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from books where bookID=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        System.out.println("BookDaoImpl :: findBookInfo() 成功执行：查询表中的某一记录");
        return book;
    }

    // 查询方法实现：查询返回集合
    @Override
    public List<Book> findAllBook() {
        String sql = "select * from books";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        System.out.println("BookDaoImpl :: findAllBook() 成功执行：查询表中的所有记录");
        return bookList;
    }
}
