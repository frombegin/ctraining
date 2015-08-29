package com.baohua.services.course.member;


import java.util.Date;

public class Membership {
    private int id;
    private int userId;
    private int courseId;

    enum Role {
        teacher,
        student
    }

    private Role role;

    private Date createdAt;

    enum Status {
        applying,
        approved,
        denied
    }

    private Status status;
}
