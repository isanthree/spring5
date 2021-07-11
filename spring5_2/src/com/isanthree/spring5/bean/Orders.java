package com.isanthree.spring5.bean;

/**
 * 演示 bean 的生命周期
 */
public class Orders {
    // 无参构造
    public Orders() {
        System.out.println("第一步 执行无参构造创建 bean 实例");
    }

    private String oName;

    public void setOName(String oName) {
        this.oName = oName;
        System.out.println("第二步 调用 set 方法设置属性值");
    }

    // 创建执行初始化的方法
    public void initMethod() {
        System.out.println("第三步 执行初始化的方法");
    }

    // 创建执行销毁的方法
    public void destroyMethod() {
        System.out.println("第五步 执行销毁的方法");
    }
}
