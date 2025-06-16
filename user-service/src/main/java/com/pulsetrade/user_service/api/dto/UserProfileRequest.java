package com.pulsetrade.user_service.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileRequest {

    private String phoneNumber;
    private String avatarUrl;
    private String bio;

}
