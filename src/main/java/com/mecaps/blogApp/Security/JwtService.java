package com.mecaps.blogApp.Security;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private static final long ACCESS_TOKEN_EXP_TIME = 1000 * 60 * 60;
    private static final long REFRESH_TOKEN_EXP_TIME = 1000 * 60 * 60 * 24 * 7;

    private static final String SECRET_KEY = "0123456789012345678901234567890123";

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String accessToken(String email, String role) {
        return buildToken(email, role, "accessToken", ACCESS_TOKEN_EXP_TIME);
    }

    public String refreshToken(String email, String role) {
        return buildToken(email, role, "refreshToken", REFRESH_TOKEN_EXP_TIME);
    }

    private String buildToken(String email, String role, String tokenType, long expTime) {
        return Jwts.builder()
                .subject(email)
                .claim("role", role)
                .claim("tokenType", tokenType)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expTime))
                .signWith(getSecretKey())
                .compact();
    }

    public String getEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String getRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public String getTokenType(String token) {
        return extractAllClaims(token).get("tokenType", String.class);
    }

    public boolean IsTokenValid(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getExpiration().after(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}