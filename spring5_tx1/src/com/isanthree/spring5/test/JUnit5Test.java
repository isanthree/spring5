package com.isanthree.spring5.test;

import com.isanthree.spring5.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * spring5 整合 JUnit5 测试
 */
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean1.xml")
@SpringJUnitConfig(locations = "classpath:bean1.xml")  // 复合注解，替代上面两个注解，化二合一
public class JUnit5Test {
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.accountMoney();
    }
}
