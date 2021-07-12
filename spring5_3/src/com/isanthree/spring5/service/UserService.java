package com.isanthree.spring5.service;

import com.isanthree.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * 在注解里面，value 属性值可以省略不写，默认值是类名称，首字母小写
 * UserService -- userService
 */
//@Component(value = "userService")  // 等价于 xml 配置：<bean id="userService" class="..." />
@Service
public class UserService {

    /*
     * @Value 普通类型属性值注入
     */
    @Value("stepByStep")
    private String name;

    /*
     * 定义 dao 类型属性，不需要添加 set 方法
     * 添加注入属性注解
     */
    @Autowired  // 根据属性类型进行自动装配
    @Qualifier(value = "userDaoImpl1")  // 根据名称注入，需要配合 @Autowired 一起使用
    private UserDao userDao;

    public void add() {
        System.out.println("service add.........." + name);
        userDao.add();
    }

    /*
     * 使用 @Resource 注解
     * 可以根据类型注入，或根据名称注入
     */
//    @Resource
    @Resource(name = "userDaoImpl1")
    private UserDao userDaoTestResource;

    public void addTestResource() {
        System.out.println("service addTestResource.........." + name);
        userDaoTestResource.add();
    }
}
