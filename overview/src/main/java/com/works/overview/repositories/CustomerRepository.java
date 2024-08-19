package com.works.overview.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import com.works.overview.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // select * from customer email = ?
    Optional<Customer> findByEmailEquals(String email);
    // select * from customer where email = ? and password = ?
    Optional<Customer> findByEmailEqualsAndPasswordEquals(String email, String password);
    // select * from customer where name like '%?%' 
    Page<Customer> findByNameContainsOrSurnameContainsAllIgnoreCase(String name, String surname, Pageable pageable);
}
