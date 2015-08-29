package com.baohua.services.course.syllabus;

public class Node {

    enum Type {

        chapter,    // 章
        section,    // 节
        subject     // 主题
    }

    private int id;
    private Type type;
    private String title;
    private String description;
    private int parentId;
}
