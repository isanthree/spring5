package com.isanthree.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    // 注入 JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 模拟银行转账
     * Mary 从 Lucy 那里得到 100元
     */
    @Override
    public void addMoney() {
        String sql = "update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql, 100, "Mary");
    }

    /**
     * 模拟银行转账
     * Lucy 转账 100元 给 Mary
     */
    @Override
    public void reduceMoney() {
        String sql = "update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql, 100, "Lucy");
    }
}
