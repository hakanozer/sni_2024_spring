package com.works.overview.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.works.overview.entities.Product;
import com.works.overview.entities.Role;
import com.works.overview.services.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("role")
public class RoleRestController {

    final RoleService roleService;

    @PostMapping("save")
    public ResponseEntity save(@RequestBody Role role) {        
        return roleService.save(role);
    }

    @GetMapping("list")
    public ResponseEntity list() {
        return roleService.list();
    }
    
}
