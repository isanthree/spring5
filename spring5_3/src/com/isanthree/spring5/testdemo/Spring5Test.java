package com.isanthree.spring5.testdemo;

import com.isanthree.spring5.config.SpringConfig;
import com.isanthree.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring5Test {

    /**
     * 测试「基于注解方式实现属性注入」
     */
    @Test
    public void testService1() {
        // 加载 xml 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        // 获取注解方式创建的 UserService 对象
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();  // 测试 @autowire @Qualifier @Value 注解
        userService.addTestResource();  // 测试 @Resource @Value 注解
    }

    /**
     * 测试「完全注解开发」，此时不需要 xml 配置文件
     */
    @Test
    public void testService2() {
        // 加载配置类，而不是 xml 配置文件
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 获取注解方式创建的 UserService 对象
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();  // 测试 @autowire @Qualifier @Value 注解
        userService.addTestResource();  // 测试 @Resource @Value 注解
    }
}
