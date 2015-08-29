package com.baohua.services.course.member;


import com.baohua.common.paginator.Pagination;

public interface MemberService {

    Teacher getTeacher(int courseId);
    Pagination<Student> getStudents(int courseId, int pageNo, int pageSize);

}
