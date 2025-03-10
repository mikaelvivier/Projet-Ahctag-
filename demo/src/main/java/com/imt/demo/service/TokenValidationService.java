package com.imt.demo.service;

import com.imt.demo.dao.JwtTokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.naming.AuthenticationException;

@Service
public class TokenValidationService {

    @Autowired
    private JwtTokenDao jwtTokenDao;

    public boolean isTokenValid(String token) {
        return jwtTokenDao.findByToken(token)!=null;
    }

    public void authenticate(@RequestHeader("Authorization") String authHeader) throws AuthenticationException {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {

            throw new AuthenticationException("Invalid authentication method");
        }

        String token = authHeader.substring(7);
        if (isTokenValid(token)) {
            return;
        }
        throw new AuthenticationException("Invalid token");
    }
}