package com.isanthree.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Aop 配置类，完全注解开发，替代 xml 配置文件
 * EnableAspectJAutoProxy 注解：替代 xml 配置文件中的「开启 Aspect 生成代理对象，
 * 即去扫描注解，若发现 @Aspect 注解，则生成一个代理对象」，<aop:aspectj-autoproxy></aop:aspectj-autoproxy>。
 */
@Configuration
@ComponentScan(basePackages = {"com.isanthree"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
