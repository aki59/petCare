package com.petOcare.security.repository;

import com.petOcare.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByroleName(String roles);
}
