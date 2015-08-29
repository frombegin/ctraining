package com.baohua.services.course;


import com.baohua.common.paginator.Pagination;

public interface CourseService {

    int createCourse(int teacherId, String title, String description);

    void deleteCourse(int teacherId, int courseId);

    void publishCourse(int teacherId, int courseId);

    Course getCourse(int courseId);

    Pagination<Course> getTeacherCourses(int teacherId, int pageNo, int pageSize);

    Pagination<Course> getStudentCourses(int studentId, int pageNo, int pageSize);

    void updateCourse(int teacherId, int courseId, Object values);

    Pagination<Course> findCourse();
}
