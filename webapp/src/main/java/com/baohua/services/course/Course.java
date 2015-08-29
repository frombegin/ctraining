package com.baohua.services.course;

import java.util.Date;

public class Course {

    private int id;
    private int teacherId;
    private String title;
    private String description;
    private Date createdAt;

    enum Status {
        preparing,
        published,
        teaching,
        taught
    }
    Status status;

    String tags;

}
