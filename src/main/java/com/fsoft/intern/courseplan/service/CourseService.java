package com.fsoft.intern.courseplan.service;

import com.fsoft.intern.courseplan.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    Course getCourseById(int course);
    void addCourse(Course course);
    void updateCours(Course course);
    void deleteCours(int id);
}
