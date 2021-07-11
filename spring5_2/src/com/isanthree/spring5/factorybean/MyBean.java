package com.isanthree.spring5.factorybean;

import com.isanthree.spring5.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean
 */
public class MyBean implements FactoryBean<Course> {
    @Override
    public boolean isSingleton() {
        return false;
    }

    /*
     * 定义返回 bean 的对象
     * 在 FactoryBean 下，定义的类型和返回的类型可以不一样，
     * 具体测试见测试类 testMyBean() 方法
     */
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("Java");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
