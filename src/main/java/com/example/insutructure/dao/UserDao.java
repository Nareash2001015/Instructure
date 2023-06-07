package com.example.insutructure.dao;

import com.example.insutructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Long> {
//    User findByEmail(@Param("name") string email)
}
