package com.isanthree.spring5;

/**
 * 使用有参构造注入
 * @author isanthree
 */
public class Orders {
    private String orderName;
    private String address;

    public Orders(String orderName, String address) {
        this.orderName = orderName;
        this.address = address;
    }

    public void ordersTest() {
        System.out.println(orderName + "::" + address);
    }
}
