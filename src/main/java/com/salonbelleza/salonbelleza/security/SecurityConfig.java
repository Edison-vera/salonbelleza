package com.salonbelleza.salonbelleza.security;

import org.springframework.context.annotation.Bean;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf()
        .disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS).permitAll()
        .antMatchers(HttpMethod.GET).permitAll()
        .antMatchers(HttpMethod.POST).permitAll()
        .antMatchers(HttpMethod.PUT).permitAll()
        .antMatchers(HttpMethod.DELETE).permitAll()
        .anyRequest().authenticated()
        .and().formLogin().permitAll()
        .and().logout().permitAll();

    return http.build();
}
}
