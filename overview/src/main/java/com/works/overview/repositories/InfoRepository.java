package com.works.overview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.works.overview.entities.Info;

public interface InfoRepository extends JpaRepository<Info, Long> {
    
}
