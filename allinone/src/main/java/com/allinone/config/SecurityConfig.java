package com.allinone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable();
        http.authorizeHttpRequests()
                .requestMatchers("/api/v1/users/**","/api/v1/accounts/**").permitAll()
                .anyRequest().authenticated();
        return http.build();

    }
}
