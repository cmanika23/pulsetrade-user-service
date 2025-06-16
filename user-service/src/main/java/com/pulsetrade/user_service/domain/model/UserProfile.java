package com.pulsetrade.user_service.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
public class UserProfile {

    // Getters and setters
    private UUID userId;
    private String displayName;
    private String phoneNumber;
    private String bio;
    private String location;
    private String profileImageUrl;

    public UserProfile(UUID userId, String displayName, String phoneNumber, String bio, String location, String profileImageUrl) {
        this.userId = userId;
        this.displayName = displayName;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.location = location;
        this.profileImageUrl = profileImageUrl;
    }

}
