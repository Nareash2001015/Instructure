package com.example.insutructure.dao;

import com.example.insutructure.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseDao extends JpaRepository<Course, Long> {
    List<Course> findCoursesByCourseName(String keyword);

    @Query(value = "select * from course where course.course_id in (select courseId from enrolled_in where enrolled_in.studentId=:studentId)", nativeQuery = true)
    List<Course> getCoursesByStudentId(@Param("studentId") Long studentId);
 }
