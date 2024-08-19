package com.works.overview.restcontrollers;

import org.springframework.web.bind.annotation.RestController;

import com.works.overview.entities.Customer;
import com.works.overview.services.CustomerService;
import com.works.overview.utils.Util;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerRestController {
    
    final CustomerService customerService;

    @GetMapping("findById/{id}/{catName}")
    public ResponseEntity findById(@PathVariable int id, @PathVariable String catName) {
        return Util.ok(id);
    }


    @GetMapping("search")
    public ResponseEntity search(
        @RequestParam(defaultValue = "") String name,
        @RequestParam(defaultValue = "") String surname,
        @RequestParam(defaultValue = "") String email
        ) {
            System.out.println(name);
            System.out.println(surname);
            System.out.println(email);
            return Util.ok(name);
    }


    @PostMapping("register")
    public ResponseEntity customerRegister(@RequestBody Customer customer) {        
        return customerService.register(customer);
    }

    @PostMapping("login")
    public ResponseEntity postMethodName(@RequestBody Customer customer) {        
        return customerService.login(customer);
    }

    @GetMapping("list")
    public ResponseEntity list(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    ) {
        return customerService.findAll(page, size);
    }

    @GetMapping("searchCustomer")
    public ResponseEntity getMethodName(
        @RequestParam(defaultValue = "") String q,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    ) {
        return customerService.search(q, page, size);
    }
    


}
