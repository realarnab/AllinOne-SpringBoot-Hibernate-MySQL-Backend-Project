package com.allinone.service;

import com.allinone.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService { //JWT service class for token generation
    @Value("${jwt.algo.key}") //@Value--> used for fetch the value of the variable from properties file
    private String algoKey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.exp.time}")
    private int expTime;

    private Algorithm algorithm;

    private final static String USER_NAME = "username";

    @PostConstruct
    public void postConstruct(){
        algorithm=Algorithm.HMAC256(algoKey);
    }

    public String generateToken(User user){
        return JWT.create()
                .withClaim(USER_NAME,user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+expTime))
                .withIssuer(issuer)
                .sign(algorithm);
    }
}
