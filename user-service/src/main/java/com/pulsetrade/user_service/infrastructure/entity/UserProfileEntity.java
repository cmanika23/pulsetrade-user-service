package com.pulsetrade.user_service.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "user_profiles")
public class UserProfileEntity {

    // Getters and setters
    @Id
    private UUID userId;

    @Column(length = 255)
    private String displayName;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 1000)
    private String bio;

    @Column(length = 255)
    private String location;

    @Column(length = 1024)
    private String profileImageUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column (name = "updated_at")
    private LocalDateTime updatedAt;

}
