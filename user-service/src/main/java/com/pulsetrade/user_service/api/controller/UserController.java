package com.pulsetrade.user_service.api.controller;

import com.pulsetrade.user_service.application.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final AuthService authService;

    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(Authentication authentication){
        String userId = authentication.getName();
        String role = authentication.getAuthorities().stream()
                .findFirst()
                .map(Object::toString)
                .orElse("UNKNOWN");
        return ResponseEntity.ok(Map.of(
                "userId", userId,
                "role", role
        ));

    }

    //method that can be accessed only by admins
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/dashboard")
    public ResponseEntity<?> getAdminDashboard() {
        return ResponseEntity.ok("Welcome Admin!");
    }
}
