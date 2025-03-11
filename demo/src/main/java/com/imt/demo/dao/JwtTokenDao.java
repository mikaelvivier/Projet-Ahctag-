package com.imt.demo.dao;

import com.imt.demo.model.JwtToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtTokenDao extends MongoRepository<JwtToken, String> {

    JwtToken findByToken(String token);
}
