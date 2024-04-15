package com.benjamin.sbs_jwt.services;

import com.benjamin.sbs_jwt.dtos.RequestResponse;
import com.benjamin.sbs_jwt.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public RequestResponse signUp(RequestResponse registrationRequest){}
}
