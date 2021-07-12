package com.isanthree.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 增强的类（代理类）
 * 增强 「被增强的类」中的某个方法，将会配置不同类型的「通知」
 */
@Component
@Aspect  // 生成代理对象
public class UserProxy {

    /**
     * 对相同的切入点进行抽取
     */
    @Pointcut(value = "execution(* com.isanthree.spring5.aopanno.User.add(..))")
    public void pointDemo() {

    }

    /**
     * 前置通知
     * Before 注解表示作为前置通知，'*' 是权限修饰符
     */
    @Before(value = "pointDemo()")  // 相同切入点抽取示例，下同，均可换成 value = "pointDemo()"
    public void before() {
        System.out.println("before（前置通知）：add 方法前置通知.........");
    }

    /**
     * 后置通知（返回通知）：被增强的方法返回结果之后执行该通知，出现异常则不执行
     * AfterReturning 注解表示作为后置通知，'*' 是权限修饰符
     */
    @AfterReturning(value = "execution(* com.isanthree.spring5.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning（后置通知）：add 方法返回结果之后执行.........");
    }

    /**
     * 最终通知：不管是否异常都会执行
     * After 注解表示作为最终通知，'*' 是权限修饰符
     */
    @After(value = "execution(* com.isanthree.spring5.aopanno.User.add(..))")
    public void after() {
        System.out.println("after（最终通知）：add 方法最终通知.........");
    }

    /**
     * 异常通知：出现异常后执行，否则不执行
     * AfterThrowing 注解表示作为异常通知，'*' 是权限修饰符
     */
    @AfterThrowing(value = "execution(* com.isanthree.spring5.aopanno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing（异常通知）：add 方法异常通知.........");
    }

    /**
     * 环绕通知：被增强方法执行前后都会执行的通知。出现异常不执行
     * Around 注解表示作为环绕通知，'*' 是权限修饰符
     */
    @Around(value = "execution(* com.isanthree.spring5.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around（环绕通知）：环绕之前.........");
        // 执行被增强的方法
        proceedingJoinPoint.proceed();
        System.out.println("around（环绕通知）：环绕之后.........");
    }
}
