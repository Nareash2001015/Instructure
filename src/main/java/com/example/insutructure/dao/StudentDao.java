package com.example.insutructure.dao;

import com.example.insutructure.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Long> {
    @Query(value = "select * from Student where firstName like %:name% or lastName like %:name%")
    List<Student> findStudentsByName(@Param("name") String name);

    @Query(value = "select * from Student where Student.user.email=:email")
    Student findStudentByEmail(@Param("name") String email);



}
