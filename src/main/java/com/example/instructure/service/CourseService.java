package com.example.instructure.service;

import com.example.instructure.dto.CourseDTO;
import com.example.instructure.entity.Course;
import org.springframework.data.domain.Page;

public interface CourseService {

    Course loadCourseByID(Long courseId);
    CourseDTO createCourse(CourseDTO courseDTO);
    CourseDTO updateCourse(CourseDTO courseDTO);
    Page<CourseDTO> findCoursesByCourseName(String keyword, int page, int size);
    void assignStudentTOCourse(Long courseId, Long StudentId);
    Page<CourseDTO> fetchCoursesForStudent(Long studentId, int page, int size);
    Page<CourseDTO> fetchNonEnrolledInCourseForStudents(Long studentId, int page, int size);
    void deleteCourse(Long courseId);
    Page<CourseDTO> fetchCoursesForInstructor(Long instructorId, int page, int size);

}
