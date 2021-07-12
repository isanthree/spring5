package com.isanthree.spring5.test;

import com.isanthree.spring5.service.UserService;
import com.isanthree.spring5.service.UserServiceForXml;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void testAccount() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void testAccount1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserServiceForXml userServiceForXml = context.getBean("userServiceForXml", UserServiceForXml.class);
        userServiceForXml.accountMoney();
    }
}
