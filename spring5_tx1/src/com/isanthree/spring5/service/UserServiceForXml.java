package com.isanthree.spring5.service;

import com.isanthree.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceForXml {
    // 注入 Dao
    @Autowired
    private UserDao userDao;

    // 转账的方法
    public void accountMoney() {
        // Lucy 少 100
        userDao.reduceMoney();

        // 模拟异常，用于测试事务管理
        int a = 1 / 0;

        // Mary 多 100
        userDao.addMoney();
    }
}
