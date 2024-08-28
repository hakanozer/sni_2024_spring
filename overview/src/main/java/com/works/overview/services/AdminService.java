package com.works.overview.services;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.works.overview.entities.Admin;
import com.works.overview.repositories.AdminRepository;
import com.works.overview.utils.Util;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {

    final AdminRepository adminRepository;
    final PasswordEncoder encoder;

    public ResponseEntity save( Admin admin ) {
        String newPassword = encoder.encode(admin.getPassword());
        admin.setPassword(newPassword);
        adminRepository.save(admin);
        return Util.ok(admin);
    }

    
}
