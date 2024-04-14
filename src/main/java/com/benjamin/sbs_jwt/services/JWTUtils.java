package com.benjamin.sbs_jwt.services;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JWTUtils {
    private SecretKey secretKey;
    private static final long EXPIRATION_TIME = 86_400_000;  // 24 hours or 86400000 milli secs

    public JWTUtils (){
        String secretString = "rh9ih84948484839u4bf84h3i23028202080trv67rb5gw78ibv78w4b9789bwy347vb45yvb847y5v4y574y54y57y457465948394639bfr8vb837438";

    }
    
}
