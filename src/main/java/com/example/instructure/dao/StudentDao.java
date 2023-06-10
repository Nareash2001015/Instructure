package com.example.instructure.dao;

import com.example.instructure.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Long> {
    @Query(value = "select * from student where firstName like %:name% or lastName like %:name%", nativeQuery = true)
    List<Student> findStudentsByName(@Param("name") String name);

    @Query(value = "select student.* from student inner join user on user.user_id=student.user_id where instructor.email=:email", nativeQuery = true)
    Student findStudentByEmail(@Param("email") String email);
}
