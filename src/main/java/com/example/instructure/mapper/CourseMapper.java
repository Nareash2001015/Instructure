package com.example.instructure.mapper;

import com.example.instructure.dao.CourseDao;
import com.example.instructure.dto.CourseDTO;
import com.example.instructure.entity.Course;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CourseMapper {

    private InstructorMapper instructorMapper;

    public CourseMapper(InstructorMapper instructorMapper) {
        this.instructorMapper = instructorMapper;
    }

    CourseDTO fromCourse(Course course){
        CourseDTO courseDTO = new CourseDTO();
        BeanUtils.copyProperties(course, courseDTO);
        courseDTO.setInstructor(instructorMapper.fromInstructor(course.getInstructor()));
        return courseDTO;
    }

    Course fromCourseDTO(CourseDTO courseDTO){
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO, course);
        return course;
    }
}
