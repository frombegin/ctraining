package com.baohua.services.course;



public interface CourseService {

    int createCourse(int teacherId, String title, String description);

    void deleteCourse(int teacherId, int courseId);

    void publishCourse(int teacherId, int courseId);

    Course getCourse(int courseId);

    void updateCourse(int teacherId, int courseId, Object values);
}
