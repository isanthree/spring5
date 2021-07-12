package com.isanthree.spring5.service;

import com.isanthree.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // 注入 Dao
    @Autowired
    private UserDao userDao;

    // 转账的方法
    public void accountMoney() {
        // Lucy 少 100
        userDao.reduceMoney();

        // Mary 多 100
        userDao.addMoney();
    }
}
