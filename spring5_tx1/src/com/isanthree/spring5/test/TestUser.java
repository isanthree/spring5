package com.isanthree.spring5.test;

import com.isanthree.spring5.config.TxConfig;
import com.isanthree.spring5.service.UserService;
import com.isanthree.spring5.service.UserServiceForTxConfig;
import com.isanthree.spring5.service.UserServiceForXml;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void testAccount() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    /**
     * 事务操作：声明式事务管理（XML 方式）测试
     */
    @Test
    public void testAccount1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserServiceForXml userServiceForXml = context.getBean("userServiceForXml", UserServiceForXml.class);
        userServiceForXml.accountMoney();
    }

    /**
     * 事务操作：声明式事务管理（完全注解方式）测试
     */
    @Test
    public void testAccount2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserServiceForTxConfig userService = context.getBean("userServiceForTxConfig", UserServiceForTxConfig.class);
        userService.accountMoney();
    }
}
