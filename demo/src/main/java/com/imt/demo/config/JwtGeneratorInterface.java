package com.imt.demo.config;

import com.imt.demo.model.User;

import java.util.Map;
public interface JwtGeneratorInterface {
    Map<String, String> generateToken(User user);
}