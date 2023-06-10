package com.example.instructure.dao;

import com.example.instructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
