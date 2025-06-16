package com.pulsetrade.user_service.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileRequest {

    private String displayName;
    private String phoneNumber;
    private String profileImageUrl;
    private String location;
    private String bio;

}
