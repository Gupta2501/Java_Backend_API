package com.gupta.JavaEEProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.gupta.JavaEEProject.Response.AuthResponse;
import com.gupta.JavaEEProject.config.PasswordConfig;
import com.gupta.JavaEEProject.data.domain.User;
import com.gupta.JavaEEProject.data.enm.Role;
import com.gupta.JavaEEProject.data.requestbody.AuthRequest;
import com.gupta.JavaEEProject.data.requestbody.UserRequest;
import com.gupta.JavaEEProject.repository.UserRepository;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordConfig passwordConfig;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse createUser(UserRequest requestBody){
        User user = User.builder()
                .firstName(requestBody.getFirstName())
                .lastName(requestBody.getLastName())
                .email(requestBody.getEmail())
                .password(passwordConfig.bCryptEncoder().encode(requestBody.getPassword()))
                .role(Role.valueOf(requestBody.getRole()))
                .build();
        userRepository.save(user).getId();
        var jwtToken = jwtService.generateToken(new HashMap<>(),user);
        return AuthResponse.builder().token(jwtToken).build();
    }

    public AuthResponse authenticate(AuthRequest authRequest){
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
    var user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow();
    //todo - add email or id to payload
        var jwtToken = jwtService.generateToken(new HashMap<>(),user);
        return AuthResponse.builder().token(jwtToken).build();
    }
}
