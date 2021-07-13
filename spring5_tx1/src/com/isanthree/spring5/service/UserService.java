package com.isanthree.spring5.service;

import com.isanthree.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Transactional(propagation = Propagation.REQUIRED) 注解：为该类里面的所有方法都添加事务
 * transactionManager：值为 "transactionManager"，表示指定该事务管理器
 * Propagation：事务传播行为
 * Isolation：事务隔离级别（REPEATABLE_READ：可重复读）
 * timeout：超时时间（-1 是默认值，即不设置超时时间）
 * readOnly：是否只读（默认值为 false）
 * rollbackFor：回滚
 * noRollbackFor：不回滚
 */
@Service
@Transactional(transactionManager = "transactionManager",
        propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class UserService {
    // 注入 Dao
    @Autowired
    private UserDao userDao;

    // 转账的方法
    public void accountMoney() {
        // Lucy 少 100
        userDao.reduceMoney();

        // 模拟异常，用于测试事务管理
//        int a = 1 / 0;

        // Mary 多 100
        userDao.addMoney();
    }
}
