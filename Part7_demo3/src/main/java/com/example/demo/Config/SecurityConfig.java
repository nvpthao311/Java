package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Cho phép H2 Console truy cập không cần login
                        .anyRequest().authenticated() // Các yêu cầu khác yêu cầu phải đăng nhập
                )
                .httpBasic(withDefaults()) //Bật HTTP Basic Auth
                .csrf(csrf -> csrf.disable()) //Tắt CSRF chỉ cho H2 Console
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));


        return http.build();
    }
}
