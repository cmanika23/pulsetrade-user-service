package com.pulsetrade.user_service.api.controller;

import com.pulsetrade.user_service.api.dto.UserProfileRequest;
import com.pulsetrade.user_service.api.dto.UserProfileResponse;
import com.pulsetrade.user_service.application.service.UserProfileService;
import com.pulsetrade.user_service.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("api/profile")
public class UserProfileController {

    private final UserProfileService profileService;

    public UserProfileController(UserProfileService profileService) {
        this.profileService = profileService;
    }

    /**
     * GET /api/profile
     * Fetch the logged-in user's profile.
     */
    @GetMapping
    public ResponseEntity<UserProfileResponse> getProfile(Principal principal){
        UUID userId = UUID.fromString(principal.getName());
        return ResponseEntity.ok(profileService.getProfile(userId));
    }

    /**
     * PUT /api/profile
     * Update the logged-in user's profile.
     */
    @PutMapping
    public ResponseEntity<Void> updateProfile(@RequestBody UserProfileRequest request, Principal principal){
        UUID userId = UUID.fromString(principal.getName());
        profileService.updateProfile(userId, request);
        return ResponseEntity.ok().build();
    }

}

