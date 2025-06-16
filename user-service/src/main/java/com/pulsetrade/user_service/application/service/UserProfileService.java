package com.pulsetrade.user_service.application.service;

import com.pulsetrade.user_service.api.dto.UserProfileRequest;
import com.pulsetrade.user_service.api.dto.UserProfileResponse;
import com.pulsetrade.user_service.domain.model.UserProfile;
import com.pulsetrade.user_service.domain.repository.IUserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserProfileService {

    private final IUserProfileRepository profileRepo;

    public UserProfileService(IUserProfileRepository profileRepository) {
        this.profileRepo = profileRepository;
    }


    public UserProfileResponse getProfile(UUID userId) {
        UserProfile profile = profileRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User profile not found"));

        return new UserProfileResponse(
                profile.getDisplayName(),
                profile.getPhoneNumber(),
                profile.getProfileImageUrl(),
                profile.getLocation(),
                profile.getBio()
        );
    }


    public void updateProfile(UUID userId, UserProfileRequest request) {
        UserProfile profile = profileRepo.findByUserId(userId)
                .orElse(new UserProfile(userId, "", "", "", "", ""));

        profile.setDisplayName(request.getDisplayName());
        profile.setBio(request.getBio());
        profile.setLocation(request.getLocation());
        profile.setProfileImageUrl(request.getProfileImageUrl());
        profile.setPhoneNumber(request.getPhoneNumber());

        profileRepo.save(profile);
    }


}
