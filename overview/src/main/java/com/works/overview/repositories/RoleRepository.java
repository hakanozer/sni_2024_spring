package com.works.overview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.works.overview.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
