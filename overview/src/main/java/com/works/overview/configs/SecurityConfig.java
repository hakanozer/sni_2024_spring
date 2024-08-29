package com.works.overview.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.works.overview.services.AdminService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    final PasswordEncoder encoder;
    final AdminService adminService;

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
        return
        http
        .httpBasic(Customizer.withDefaults())
        .authorizeHttpRequests( auth ->
            auth
            .requestMatchers("/customer/**").permitAll()
            .requestMatchers("/role/**").permitAll()
            .requestMatchers("/info/**").permitAll()
            .requestMatchers("/product/**").hasRole("product")
            .requestMatchers("/note/**").hasRole("note")
        )
        .csrf(AbstractHttpConfigurer::disable)
        .formLogin(AbstractHttpConfigurer::disable)
        .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(encoder);
        daoAuthenticationProvider.setUserDetailsService(adminService);
        return daoAuthenticationProvider;
    }


    
}

/*
 * ali -> product
 * veli -> note
 * zehra -> product, note
 */
