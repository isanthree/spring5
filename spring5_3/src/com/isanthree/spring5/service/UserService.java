package com.isanthree.spring5.service;

import org.springframework.stereotype.Component;

/*
 * 在注解里面，value 属性值可以省略不写，默认值是类名称，首字母小写
 * UserService -- userService
 */
@Component(value = "userService")  // 等价于 xml 配置：<bean id="userService" class="..." />
public class UserService {
    public void add() {
        System.out.println("service add.........");
    }
}
