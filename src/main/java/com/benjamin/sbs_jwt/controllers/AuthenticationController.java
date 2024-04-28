package com.benjamin.sbs_jwt.controllers;

import com.benjamin.sbs_jwt.dtos.RequestResponse;
import com.benjamin.sbs_jwt.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity <RequestResponse> signUp(@RequestBody RequestResponse signUpRequest){
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }
    @PostMapping("/signin")
    public ResponseEntity <RequestResponse> signIn(@RequestBody RequestResponse signInRequest){
        return ResponseEntity.ok(authService.signIn(signInRequest));
    }
    @PostMapping("/refresh")
    public ResponseEntity <RequestResponse> refreshToken(@RequestBody RequestResponse refreshTokenRequest){
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }

//    const storeTokens = async (accessToken, refreshToken) => {
//        try {
//            await AsyncStorage.setItem('accessToken', accessToken);
//            await AsyncStorage.setItem('refreshToken', refreshToken);
//        } catch (error) {
//            console.error("Error storing tokens:", error);
//        }
//    };

//    const logout = async () => {
//        try {
//            // Remove tokens from storage
//            await AsyncStorage.removeItem('accessToken');
//            await AsyncStorage.removeItem('refreshToken');
//
//            // Optionally clear other user data
//
//            // Update UI
//            // ...
//
//            // Navigate to Login Screen
//            navigation.navigate('Login');
//        } catch (error) {
//            console.error("Logout Error:", error);
//            // Handle errors appropriately, e.g., display an error message to the user
//        }
//    };
}
