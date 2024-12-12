package com.ebanking.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Public endpoints
                        .requestMatchers("/api/notices/**").permitAll()
                        .requestMatchers("/api/contact/**").permitAll()
                        .requestMatchers("/api/users/register").permitAll()

                        // Admin only endpoints
                        .requestMatchers("/api/users").hasRole("ADMIN")
                        .requestMatchers("/api/users/{username}").hasRole("ADMIN")
                        .requestMatchers("/api/users/{username}/updateRole").hasRole("ADMIN")

                        // User endpoints
                        .requestMatchers("/api/users/{username}").hasRole("USER")

                        // Authenticated endpoints
                        .requestMatchers("/api/myLoans/**").authenticated()
                        .requestMatchers("/api/myCards/**").authenticated()
                        .requestMatchers("/api/myAccount/**").authenticated()

                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> basic.realmName("Ebanking Security")) // Modern way to configure basic auth
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);
    }
}