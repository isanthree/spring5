package com.isanthree.spring5.bean;

/**
 * 部门类
 */
public class Dept {
    private String dName;

    public void setDName(String dName) {
        this.dName = dName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dName='" + dName + '\'' +
                '}';
    }
}
