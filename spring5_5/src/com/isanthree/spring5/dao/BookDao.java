package com.isanthree.spring5.dao;

import com.isanthree.spring5.entity.Book;

import java.util.List;

public interface BookDao {
    // 添加方法定义
    void add(Book book);

    // 批量添加方法定义
    void batchAdd(List<Object[]> batchArgs);

    // 修改方法定义
    void update(Book book);

    // 批量修改方法定义
    void batchUpdate(List<Object[]> batchArgs);

    // 删除方法定义
    void delete(String id);

    // 批量删除方法定义
    void batchDelete(List<Object[]> batchArgs);

    // 查询方法定义：查询表的记录数量
    int selectCount();

    // 查询方法定义：查询返回对象（即表中的某一条记录）
    Book findBookInfo(String id);

    // 查询方法定义：查询返回集合
    List<Book> findAllBook();
}
