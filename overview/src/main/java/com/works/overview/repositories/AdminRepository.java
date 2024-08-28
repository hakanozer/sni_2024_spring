package com.works.overview.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.works.overview.entities.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUsername(String username);
    
}
