package com.example.instructure.dao;

import com.example.instructure.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseDao extends JpaRepository<Course, Long> {
    List<Course> findCoursesByCourseNameContains(String keyword);

    @Query(value = "select * from course where course.course_id in (select enrolled_in.course_id from enrolled_in where enrolled_in.student_id=:studentId)", nativeQuery = true)
    List<Course> getCoursesByStudentId(@Param("studentId") Long studentId);
 }


