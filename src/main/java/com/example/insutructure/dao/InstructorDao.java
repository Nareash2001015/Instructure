package com.example.insutructure.dao;

import com.example.insutructure.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorDao extends JpaRepository<Instructor, Long> {
    @Query(value = "select * from Instructor where firstName like %:name% or lastName like %:name%")
    List<Instructor> findInstructorByName(@Param("name") String name);

    @Query(value = "select * from Instructor where Instructor.user.email=:email")
    Instructor findInstructorByEmail(@Param("email") String email);
}
