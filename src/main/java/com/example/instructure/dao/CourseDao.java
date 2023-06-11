package com.example.instructure.dao;

import com.example.instructure.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseDao extends JpaRepository<Course, Long> {
    Page<Course> findCoursesByCourseNameContains(String keyword, Pageable pageable);

    @Query(value = "select * from course where course.course_id in (select enrolled_in.course_id from enrolled_in where enrolled_in.student_id=:studentId)", nativeQuery = true)
    Page<Course> getCoursesByStudentId(@Param("studentId") Long studentId, Pageable pageable);

    @Query(value = "select * from course where course.course_id not in (select enrolled_in.course_id from enrolled_in where enrolled_in.student_id=:studentId)", nativeQuery = true)
    Page<Course> getNotSubscribedCoursesByStudentId(@Param("studentId") Long studentId, Pageable pageable);

    @Query(value = "select * from Course where Course.Instructor.instructor_id=:instructorId")
    Page<Course> getCoursesByInstructorId(@Param("instructorId") Long instructorId, Pageable pageable);
 }


