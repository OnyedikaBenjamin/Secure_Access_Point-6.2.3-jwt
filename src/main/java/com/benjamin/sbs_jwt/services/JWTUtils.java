package com.benjamin.sbs_jwt.services;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Component
public class JWTUtils {
    private static final long EXPIRATION_TIME = 86_400_000;  // 24 hours or 86400000 milli secs
    private SecretKey secretKey;

    public JWTUtils() {
        String secretString = "rh9ih84948484839u4bf84h3i23028202080trv67rb5gw78ibv78w4b9789bwy347vb45yvb847y5v4y574y54y57y457465948394639bfr8vb837438";
        byte[] keyBytes = Base64.getDecoder().decode(secretString.getBytes(StandardCharsets.UTF_8));
        this.secretKey = new SecretKeySpec(keyBytes, "HmacSHA256");
    }

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(secretKey)
                .compact();
    }

}
