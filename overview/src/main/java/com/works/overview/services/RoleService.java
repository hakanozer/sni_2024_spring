package com.works.overview.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.works.overview.entities.Role;
import com.works.overview.repositories.RoleRepository;
import com.works.overview.utils.Util;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {

    final RoleRepository roleRepository;

    public ResponseEntity save(Role role) {
        roleRepository.save(role);
        return Util.ok(role);
    }

    public ResponseEntity list() {
        List<Role> roles = roleRepository.findAll();
        return Util.ok(roles);
    }
    
}
