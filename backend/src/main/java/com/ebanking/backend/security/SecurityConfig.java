package com.ebanking.backend.security;

import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final Environment environment;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth
                // Public endpoints
                .requestMatchers(
                    "/api/notices/**",
                    "/api/contact/**",
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html"
                ).permitAll()

                // Authentication endpoints
                .requestMatchers(HttpMethod.POST,
                    "/api/users/register"
                ).permitAll()
                
                // Admin only endpoints
                .requestMatchers(HttpMethod.GET, "/api/users/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/users/{id}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/users/{id}/updateRole").hasRole("ADMIN")
                
                // User specific endpoints
                .requestMatchers(HttpMethod.PUT, "/api/users/{id}").hasRole("USER")
                
                // Authenticated endpoints (need any role)
                .requestMatchers(
                    "/api/myLoans/**",
                    "/api/myCards/**",
                    "/api/myAccount/**"
                ).authenticated()
                
                // Any other request needs authentication
                .anyRequest().authenticated()
            )
            .authenticationProvider(authenticationProvider())
            .httpBasic(basic -> {});

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                );
    }

    @Profile("!test")
    @Bean("authenticationProvider")
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Profile("test")
    @Bean("authenticationProvider")
    public DaoAuthenticationProvider testAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) {
                UserDetails user = userDetailsService.loadUserByUsername(
                        authentication.getName()
                );
                // Accept any password!
                return new UsernamePasswordAuthenticationToken(
                        user,
                        authentication.getCredentials(),
                        user.getAuthorities()
                );
            }
        };
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        // Get current active profiles
        String[] activeProfiles = environment.getActiveProfiles();

        boolean isTestProfile = Arrays.asList(activeProfiles).contains("test");

        return new ProviderManager(
                isTestProfile ? testAuthenticationProvider() : authenticationProvider()
        );
    }
}