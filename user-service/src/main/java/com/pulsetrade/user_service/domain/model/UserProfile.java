package com.pulsetrade.user_service.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

    @Id
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "bio")
    private String bio;

    public UserProfile(User user, String phoneNumber, String avatarUrl, String bio) {
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
    }

}
