package com.imt.demo.configs;

import com.imt.demo.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
/**
 * Configure le contexte d'authentification avec le JWT à la place de l'auth HTTP.
 * passwordEncoder chiffre le mdp utilisateur et authenticationProvider met en place la nouvelle stratégie d'authentification.
 * Effectue l'authentification en cherchant l'utilisateur dans la BDD
 * Génère le JWT quand l'authentification est bonne
 *
 */
public class ApplicationConfiguration {
    private final UserDao userDao;

    public ApplicationConfiguration(UserDao userDao) {
        this.userDao = userDao;
    }

    @Bean
    UserDetailsService userDetailsService() {
        return username -> userDao.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}