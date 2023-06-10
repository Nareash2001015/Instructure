package com.example.instructure.dao;

import com.example.instructure.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {

    Role findRoleByName(String name);
}
