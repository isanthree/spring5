package com.isanthree.spring5.aopanno;

import org.springframework.stereotype.Component;

/**
 * 被增强的类
 */
@Component
public class User {
    public void add() {
//        System.out.println(10 / 0);  // 测试异常通知
        System.out.println("User add.......");
    }
}
