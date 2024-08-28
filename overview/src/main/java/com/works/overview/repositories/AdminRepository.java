package com.works.overview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.works.overview.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
