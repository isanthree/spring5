package com.isanthree.spring5.test;

import com.isanthree.spring5.aopanno.User;
import com.isanthree.spring5.aopxml.Book;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    /**
     * 测试基于注解方式的通知
     */
    @Test
    public void testAopAnno() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    /**
     * 测试基于 xml 配置文件的通知
     */
    @Test
    public void testAopXml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}
