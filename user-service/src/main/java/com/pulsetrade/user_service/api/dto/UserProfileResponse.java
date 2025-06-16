package com.pulsetrade.user_service.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponse {
    private String displayName;
    private String phoneNumber;
    private String profileImageUrl;
    private String location;
    private String bio;
}
