package com.gupta.JavaEEProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gupta.JavaEEProject.Response.AuthResponse;
import com.gupta.JavaEEProject.data.requestbody.AuthRequest;
import com.gupta.JavaEEProject.data.requestbody.UserRequest;
import com.gupta.JavaEEProject.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(authService.createUser(userRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(authService.authenticate(authRequest));
    }
}
