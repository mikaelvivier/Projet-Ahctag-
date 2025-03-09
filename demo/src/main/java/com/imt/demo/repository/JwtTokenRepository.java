package com.imt.demo.repository;

import com.imt.demo.model.JwtToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtTokenRepository extends MongoRepository<JwtToken, Long> {
    JwtToken findByToken(String token);
}