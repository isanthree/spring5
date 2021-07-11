package com.isanthree.spring5;

/**
 * 演示使用 set 方法进行属性注入
 * @author isanthree
 */
public class Book {

    /**
     * 创建属性
     */
    private String bName;
    private String bAuthor;

    /**
     * set 方法注入：创建属性对应的 set 方法
     * @param bName
     */
    public void setBName(String bName) {
        this.bName = bName;
    }

    public void setBAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.setBName("abc");
    }

    public void testDemo() {
        System.out.println(bName + "::" + bAuthor);
    }

}
