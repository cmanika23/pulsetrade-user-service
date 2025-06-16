package com.pulsetrade.user_service.application.service;

import com.pulsetrade.user_service.api.dto.UserProfileRequest;
import com.pulsetrade.user_service.api.dto.UserProfileResponse;
import com.pulsetrade.user_service.domain.model.User;
import com.pulsetrade.user_service.domain.model.UserProfile;
import com.pulsetrade.user_service.infrastructure.repository.SpringUserJpaRepository;
import com.pulsetrade.user_service.infrastructure.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserProfileService {

    private final SpringUserJpaRepository userRepo;
    private final UserProfileRepository profileRepo;

    public UserProfileService(SpringUserJpaRepository userRepo, UserProfileRepository profileRepo) {
        this.userRepo = userRepo;
        this.profileRepo = profileRepo;
    }

    public UserProfileResponse getProfile(UUID userId){

        UserProfile profile = profileRepo.findByUserId(userId)
                .orElseThrow(()-> new RuntimeException("Profile not found"));

        return new UserProfileResponse(profile.getPhoneNumber(), profile.getAvatarUrl(), profile.getBio());
    }

    public void updateProfile(UUID userId, UserProfileRequest request){

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserProfile profile = profileRepo.findByUserId(userId)
                .orElse( new UserProfile(user,"","",""));

        profile.setPhoneNumber(request.getPhoneNumber());
        profile.setAvatarUrl(request.getAvatarUrl());
        profile.setBio(request.getBio());

        profileRepo.save(profile);
    }


}
