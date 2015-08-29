package com.baohua.services.course.lesson;


import java.util.Date;

public class Lesson {

    enum Status {
        preparing,
        taught
    }

    private int id;
    private Date startedAt;
    private int duration;
    private Status status;
    private int courseId;

}
