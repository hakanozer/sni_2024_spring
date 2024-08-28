package com.works.overview.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.works.overview.entities.Admin;
import com.works.overview.entities.Role;
import com.works.overview.repositories.AdminRepository;
import com.works.overview.utils.Util;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService implements UserDetailsService {

    final AdminRepository adminRepository;
    final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> optional = adminRepository.findByUsername(username);
        if (optional.isPresent()) {
            Admin admin = optional.get();
            return new User(
                admin.getUsername(),
                admin.getPassword(),
                admin.getEnable(),
                true,
                true,
                true,
                parseRole(admin.getRoles())
            );
        }
        throw new UsernameNotFoundException("Username not found!");
    }

    private Collection<? extends GrantedAuthority> parseRole(List<Role> roles) {
        throw new UnsupportedOperationException("Unimplemented method 'parseRole'");
    }

    public ResponseEntity save( Admin admin ) {
        String newPassword = encoder.encode(admin.getPassword());
        admin.setPassword(newPassword);
        adminRepository.save(admin);
        return Util.ok(admin);
    }

    public ResponseEntity list() {
        return Util.ok(adminRepository.findAll());
    }



    
}
