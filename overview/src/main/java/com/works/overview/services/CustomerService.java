package com.works.overview.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import com.works.overview.entities.Customer;
import com.works.overview.repositories.CustomerRepository;
import com.works.overview.utils.Util;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CustomerService {
    
    final CustomerRepository customerRepository;

    public ResponseEntity register( Customer customer ) {
        // sql -> insert
        Optional<Customer> optCustomer = customerRepository.findByEmailEquals(customer.getEmail());
        if (optCustomer.isPresent()) {
            return Util.fail("Unique index or primary key violation, email: " + customer.getEmail(), HttpStatus.BAD_REQUEST);
        }
        customerRepository.save(customer);
        return Util.ok(customer);
        /* 
        try {
            customerRepository.save(customer);
            return Util.ok(customer);
        } catch (Exception e) {
            return Util.fail("Unique index or primary key violation, email: " + customer.getEmail(), HttpStatus.BAD_REQUEST);
        }
        */
    }

    public ResponseEntity login (Customer customer) {
        Optional<Customer> optCustomer = customerRepository.findByEmailEqualsAndPasswordEquals(customer.getEmail(), customer.getPassword());
        if (optCustomer.isPresent()) {
            Customer dbCustomer = optCustomer.get();
            return Util.ok(dbCustomer);
        }
        return Util.fail("Email or Password Fail", HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity findAll(int page, int size) {
        int controlSize = 5;
        if (size < 6 && size > 0) {
            controlSize = size;
        }
        // select * from customer
        PageRequest pageable = PageRequest.of(page, controlSize);
        Page<Customer> customers = customerRepository.findAll(pageable);
        return Util.ok(customers);
    }

    public ResponseEntity search(String q, int page, int size) {
        int controlSize = 5;
        if (size < 6 && size > 0) {
            controlSize = size;
        }
        // select * from customer
        Pageable pageable = PageRequest.of(page, controlSize);
        Page<Customer> cusPage = customerRepository.findByNameContainsOrSurnameContainsAllIgnoreCase(q, q, pageable);
        return Util.ok(cusPage);
    }



}
