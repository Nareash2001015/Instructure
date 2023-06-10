package com.example.instructure.dao;

import com.example.instructure.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorDao extends JpaRepository<Instructor, Long> {
    @Query(value = "select * from instructor where firstName like %:name% or lastName like %:name%", nativeQuery = true)
    List<Instructor> findInstructorByName(@Param("name") String name);

    @Query(value = "select instructor.* from instructor inner join user on instructor.user_id=user.user_id where instructor.email=:email", nativeQuery = true)
    Instructor findInstructorByEmail(@Param("email") String email);
}
