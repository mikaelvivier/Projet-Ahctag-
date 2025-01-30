package com.imt.demo.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/*
CSRF (Cross-Site Request Forgery) est une vulnérabilité de sécurité web qui permet à un
attaquant de réaliser des actions indésirables au nom d'un utilisateur authentifié sur une
autre application. Cela se produit lorsque l'utilisateur est authentifié sur une application
légitime et qu'une requête malveillante est envoyée à cette application sans son consentement.

Fonctionnement de CSRF Protection
La protection contre CSRF garantit que seulement les requêtes intentionnelles effectuées
 par les utilisateurs légitimes sont acceptées par les applications.
 */

@Configuration
@EnableWebSecurity
/**
 * Définit quel critère une requête à venir doit matcher avant d'être envoyée au
 * middleware (intergiciel) de l'appli.
 * Si une requête est envoyée à /auth/signup et /auth/login, l'auth n'est pas nécessaire
 * requête stateless
 * Doit utiliser l'authentication provider
 * Le Cross-Origin Resource Sharing (CORS) ne prend que les requêtes GET et POST
 */
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfiguration(
            JwtAuthenticationFilter jwtAuthenticationFilter,
            AuthenticationProvider authenticationProvider
    ) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("http://localhost:8005"));
        configuration.setAllowedMethods(List.of("GET","POST"));
        configuration.setAllowedHeaders(List.of("Authorization","Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**",configuration);

        return source;
    }
}