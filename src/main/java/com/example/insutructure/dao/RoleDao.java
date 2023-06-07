package com.example.insutructure.dao;

import com.example.insutructure.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
