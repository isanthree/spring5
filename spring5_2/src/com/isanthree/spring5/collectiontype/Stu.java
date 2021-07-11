package com.isanthree.spring5.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * IOC 操作 Bean 管理（xml 注入集合属性）
 */
public class Stu {
    // 数组类型属性
    private String[] courses;
    // list 集合类型属性
    private List<String> list;
    private List<Course> courseList;  // 学生所学多门课程
    // map 集合类型属性
    private Map<String, String> maps;
    // set 集合类型属性
    private Set<String> sets;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void test() {
        System.out.println(Arrays.toString(courses));
        System.out.println(list);
        System.out.println(courseList);
        System.out.println(maps);
        System.out.println(sets);
    }
}
