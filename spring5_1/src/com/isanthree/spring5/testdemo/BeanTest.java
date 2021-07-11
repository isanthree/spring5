package com.isanthree.spring5.testdemo;

import com.isanthree.spring5.bean.Emp;
import com.isanthree.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    /**
     * 测试属性注入：外部 bean
     */
    @Test
    public void testBean1() {
        // 1.加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        // 2.获取配置文件创建的对象
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService);
        userService.add();
    }

    /**
     * 测试属性注入：内部 bean
     */
    @Test
    public void testBean2() {
        // 1.加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        // 2.获取配置文件创建的对象
        Emp emp = context.getBean("emp", Emp.class);

        System.out.println(emp);
        emp.add();
    }

    /**
     * 测试属性注入：级联赋值 第一种写法测试
     */
    @Test
    public void testBean3_1() {
        // 1.加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        // 2.获取配置文件创建的对象
        Emp emp = context.getBean("emp1", Emp.class);

        System.out.println(emp);
        emp.add();
    }

    /**
     * 测试属性注入：级联赋值 第二种写法测试
     */
    @Test
    public void testBean3_2() {
        // 1.加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        // 2.获取配置文件创建的对象
        Emp emp = context.getBean("emp2", Emp.class);

        System.out.println(emp);
        emp.add();
    }

}
