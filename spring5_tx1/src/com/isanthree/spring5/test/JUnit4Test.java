package com.isanthree.spring5.test;

import com.isanthree.spring5.service.UserService;
import org.junit.Test;  // JUnit4
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring5 整合 JUnit4 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)  // 单元测试框架
@ContextConfiguration("classpath:bean1.xml")  // 加载配置文件
public class JUnit4Test {
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.accountMoney();
    }
}
