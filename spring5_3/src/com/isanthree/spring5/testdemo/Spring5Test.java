package com.isanthree.spring5.testdemo;

import com.isanthree.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring5Test {

    @Test
    public void testService() {
        // 加载 xml 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        // 获取注解方式创建的 UserService 对象
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
