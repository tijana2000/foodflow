package com.foodflow.user_management_service.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private static final String SECRET_KEY = "foodflow-super-secret-key-for-jwt-token-2026";
    private static final long EXPIRATION_TIME = 1000*60*60; //1HR

    public String generateToken(String email){
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .compact();
    }
    public String extractEmail(String token){
        return exctractAllClaims(token).getSubject();
    }
    public boolean isTokenValid(String token, String email){
        String tokenEmail = extractEmail(token);
        return tokenEmail.equals(email) && !isTokenExpired(token);
    }
    public boolean isTokenExpired(String token){
        return exctractAllClaims(token).getExpiration().before(new Date());
    }
    private Claims exctractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
