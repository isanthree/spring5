package com.isanthree.spring5.testdemo;

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

    @Test
    public void testMyBean() {
        // 1.加载 spring 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        // 2.获取配置文件创建的对象
        Course course = context.getBean("myBean", Course.class);

        System.out.println(course);
    }
}
