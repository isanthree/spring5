package com.isanthree.spring5.testdemo;

import com.isanthree.spring5.autowire.Emp;
import com.isanthree.spring5.bean.Orders;
import com.isanthree.spring5.collectiontype.Book;
import com.isanthree.spring5.collectiontype.Course;
import com.isanthree.spring5.collectiontype.Stu;
import com.isanthree.spring5.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring5Test {
    @Test
    public void testCollection1() {
        // 1.加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        // 2.获取配置文件创建的对象
        Stu stu = context.getBean("stu", Stu.class);

        System.out.println(stu);
        stu.test();
    }

    @Test
    public void testCollection2() {
        // 1.加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        // 2.获取配置文件创建的对象
        Book book = context.getBean("book", Book.class);

        System.out.println(book);
        book.test();
    }

    /**
     * 测试 FactoryBean
     */
    @Test
    public void testMyBean() {
        // 1.加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        // 2.获取配置文件创建的对象
        Course course = context.getBean("myBean", Course.class);

        System.out.println(course);
    }

    /**
     * 演示 Bean 生命周期
     */
    @Test
    public void testBean3() {
        // 1.加载 spring 配置文件
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        // 2.获取配置文件创建的对象
        Orders orders = context.getBean("orders", Orders.class);

        System.out.println("第四步 获取创建 bean 实例对象");
        System.out.println(orders);

        // 手动让 bean 实例销毁
        context.close();
    }

    /**
     * 测试 xml 自动装配
     */
    @Test
    public void test4() {
        // 1.加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");

        // 2.获取配置文件创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
