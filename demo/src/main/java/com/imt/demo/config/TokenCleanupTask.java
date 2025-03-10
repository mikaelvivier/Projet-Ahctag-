package com.imt.demo.config;

import com.imt.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TokenCleanupTask {

    private final JwtService jwtService;

    @Autowired
    public TokenCleanupTask(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Scheduled(fixedRate = 3600000) // Exécute toutes les heures
    public void cleanOldTokens() {
        jwtService.cleanOldTokens();
    }
}