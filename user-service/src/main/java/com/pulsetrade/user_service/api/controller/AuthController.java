package com.pulsetrade.user_service.api.controller;

import com.pulsetrade.user_service.api.dto.AuthResponse;
import com.pulsetrade.user_service.api.dto.LoginRequest;
import com.pulsetrade.user_service.api.dto.RegisterRequest;
import com.pulsetrade.user_service.application.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMe(Authentication authentication){
        return ResponseEntity.ok("Logged in user ID: " + authentication.getName());
    }

}
