package com.baohua.services.course.member;


import java.util.Date;

public class Membership {
    private int id;
    private int userId;
    private int courseId;
    private Date createdAt;

    private MembershipRole role;
    private MembershipStatus status;
}
