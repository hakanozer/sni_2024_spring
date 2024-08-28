package com.works.overview.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.works.overview.entities.Admin;
import com.works.overview.services.AdminService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminRestController {

    final AdminService adminService;

    @PostMapping("save")
    public ResponseEntity save(@RequestBody Admin admin) {
        System.out.println("admin save");
        System.out.println(admin);
        return adminService.save(admin);
    }

    @GetMapping("list")
    public ResponseEntity list() {
        return adminService.list();
    }
    
    
    
}
