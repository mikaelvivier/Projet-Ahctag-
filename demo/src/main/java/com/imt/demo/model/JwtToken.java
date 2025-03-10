package com.imt.demo.model;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Document
public class JwtToken {

    @Id
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    public JwtToken() {
    }

    public void setToken(String token) {
        this.token = token;
    }
}