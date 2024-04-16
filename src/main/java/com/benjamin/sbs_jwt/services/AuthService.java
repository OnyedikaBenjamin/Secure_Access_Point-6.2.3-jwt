package com.benjamin.sbs_jwt.services;

import com.benjamin.sbs_jwt.config.JWTUtils;
import com.benjamin.sbs_jwt.dtos.RequestResponse;
import com.benjamin.sbs_jwt.entities.OurUsers;
import com.benjamin.sbs_jwt.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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

    public RequestResponse signUp(RequestResponse registrationRequest){
        RequestResponse registrationResponse = new RequestResponse();
        try {
            OurUsers user = new OurUsers();
            user.setEmail(registrationRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            user.setRole(registrationRequest.getRole());
            OurUsers registration = userRepo.save(user);
            if(registration != null && registration.getId() > 0){
                registrationResponse.setOurUsers(registration);
                registrationResponse.setMessage("User saved successfully");
                registrationResponse.setStatusCode(200);
            }
        }
        catch (Exception e){
           registrationResponse.setStatusCode(500);
           registrationResponse.setError(e.getMessage());
        }
        return registrationResponse;
    }

    public RequestResponse signIn(RequestResponse signInRequest){
        RequestResponse signInResponse = new RequestResponse();
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signInRequest.getEmail(),
                            signInRequest.getPassword())
            );
            var user = userRepo.findByEmail(signInRequest.getEmail()).orElseThrow();
            System.out.println("OUR USER IS : "+ user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            signInResponse.setStatusCode(200);
            signInResponse.setToken(jwt);
            signInResponse.setRefreshToken(refreshToken);
            signInResponse.setExpirationTime("24hrs");
            signInResponse.setMessage("Successfully Signed In");
        }
        catch (Exception e){
            signInResponse.setStatusCode(500);
            signInResponse.setError(e.getMessage());
        }
        return signInResponse;
    }

    public RequestResponse refreshToken(RequestResponse refreshTokenRequest){
        RequestResponse response = new RequestResponse();
        String email = jwtUtils.extractUsername(refreshTokenRequest.getToken());
        OurUsers user = userRepo.findByEmail(email).orElseThrow();
        if(jwtUtils.isTokenValid(refreshTokenRequest.getToken(), user)){
            var jwt = jwtUtils.generateToken(user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenRequest.getRefreshToken());
            response.setExpirationTime("24 Hrs");
            response.setMessage("Successfully Refreshed token");
        }
        response.setStatusCode(500);
        return response;
    }

}
