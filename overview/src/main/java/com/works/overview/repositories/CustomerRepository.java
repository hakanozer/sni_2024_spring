package com.works.overview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.works.overview.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
