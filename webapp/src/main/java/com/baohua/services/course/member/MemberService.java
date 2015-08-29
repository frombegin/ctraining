package com.baohua.services.course.member;


import com.baohua.common.paginator.Pagination;

public interface MemberService {

    Teacher getTeacher(int courseId);

    Pagination<Student> getStudents(int courseId, boolean applying, int pageNo, int pageSize);

    Pagination<Membership> getMemberships(int courseId, int pageNo, int pageSize);

}
