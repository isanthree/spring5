package com.isanthree.spring5.aopanno;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)  // 针对有多个增强类的情况，此处设置执行的优先级，Order(1) 为第一优先级
public class PersonProxy {
    /**
     * 前置通知：被增强的方法返回结果之后执行该通知，出现异常则不执行
     * Before 注解表示作为前置通知，'*' 是权限修饰符
     */
    @Before(value = "execution(* com.isanthree.spring5.aopanno.User.add(..))")
    public void before() {
        System.out.println("PersonProxy.class before（前置通知）：add 方法前置通知.........");
    }
}
