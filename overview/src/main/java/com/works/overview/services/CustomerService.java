package com.works.overview.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        customerRepository.save(customer);
        return Util.ok(customer);
    }


}
