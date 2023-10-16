package com.api.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
    // Define your secret key 
    private static final String SECRET_KEY = "your_secret_key_here";

    // Define token expiration time 
    private static final long EXPIRATION_TIME = 3600000; // 1 hour in milliseconds

    public static String generateToken(String subject) {
        // Create a secure signing key (you can also load it from a secure location)
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        // Build the JWT token
        String token = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    public static String getSubjectFromToken(String token) {
        try {
            // Parse the token and extract the subject
            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            // Handle token parsing exceptions
            return null;
        }
    }
}