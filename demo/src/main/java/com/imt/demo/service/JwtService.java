package com.imt.demo.service;

import com.imt.demo.model.JwtToken;
import com.imt.demo.repository.JwtTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtService {

    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    public void saveToken(String token) {
        JwtToken jwtToken = new JwtToken(token);
        jwtTokenRepository.save(jwtToken);
    }

    public boolean isTokenValid(String token) {
        return jwtTokenRepository.findByToken(token) != null;
    }

    public void cleanOldTokens() {
        jwtTokenRepository.deleteAll();
    }
}
