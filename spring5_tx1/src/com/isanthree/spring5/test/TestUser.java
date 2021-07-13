package com.isanthree.spring5.test;

import com.isanthree.spring5.config.TxConfig;
import com.isanthree.spring5.service.UserService;
import com.isanthree.spring5.service.UserServiceForTxConfig;
import com.isanthree.spring5.service.UserServiceForXml;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

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

    /**
     * 函数式风格创建对象，交给 spring 进行管理
     */
    @Test
    public void testGenericApplicationContext() {
        // 1.创建 GenericApplicationContext 对象
        GenericApplicationContext context = new GenericApplicationContext();
        // 2.调用 context 的方法进行对象注册
        context.refresh();
//        context.registerBean(UserService.class, UserService::new);  // 第一个参数拥有 Nullable 注解，表示可以为空
        context.registerBean("userService1", UserService.class, UserService::new);
        // 3.获取在 spring 注册的对象
//        UserService userService = (UserService)context.getBean("com.isanthree.spring5.service.UserService");
        UserService userService = (UserService)context.getBean("userService1");
        System.out.println(userService);
    }
}
