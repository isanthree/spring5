package com.isanthree.spring5.service;

import com.isanthree.spring5.dao.BookDao;
import com.isanthree.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    // 注入 dao
    @Autowired
    private BookDao bookDao;

    // 添加方法
    public void addBook(Book book) {
        bookDao.add(book);
    }

    // 批量添加方法
    public void batchAddBook(List<Object[]> batchArgs) {
        bookDao.batchAdd(batchArgs);
    }

    // 修改方法
    public void updateBook(Book book) {
        bookDao.update(book);
    }

    // 批量修改方法
    public void batchUpdateBook(List<Object[]> batchArgs) {
        bookDao.batchUpdate(batchArgs);
    }

    // 删除方法
    public void deleteBook(String id) {
        bookDao.delete(id);
    }

    // 批量删除方法
    public void batchDeleteBook(List<Object[]> batchArgs) {
        bookDao.batchDelete(batchArgs);
    }

    // 查询方法：查询表的记录数量
    public int findCount() {
        return bookDao.selectCount();
    }

    // 查询方法：查询返回对象（即表中的某一条记录）
    public Book findOne(String id) {
        return bookDao.findBookInfo(id);
    }

    // 查询方法：查询返回集合
    public List<Book> findAll() {
        return bookDao.findAllBook();
    }
}
