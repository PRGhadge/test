package com.example.dummy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll() // Allow public access to /api/*
                        .anyRequest().authenticated() // Require authentication for other endpoints
                )
                .csrf(csrf -> csrf.disable()) // Disable CSRF for testing
                .formLogin(login -> login.disable()) // Disable default login page
                .httpBasic(basic -> basic.disable()); // Disable Basic Auth

        return http.build();
    }
}
