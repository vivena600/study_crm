package org.ugatu.config;

/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> authz
                        // Разрешить доступ к OpenAPI и Swagger UI
                        .requestMatchers(
                                "/student-docs",               // ваш путь к JSON
                                "/sw/student.html",            // ваш путь к UI
                                "/webjars/**",                 // статические ресурсы Swagger
                                "/v3/api-docs/**",             // на всякий случай (если используется)
                                "/swagger-ui/**"               // на всякий случай
                        ).permitAll()

                        .requestMatchers("/students").hasRole("MANAGER")
                        .requestMatchers("/students/**").authenticated()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // Заглушка UserDetailsService (для корректной работы Security)
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            // В JWT-режиме этот метод почти не используется
            return User.withUsername(username).password("").roles("TEMP").build();
        };
    }
}
 */