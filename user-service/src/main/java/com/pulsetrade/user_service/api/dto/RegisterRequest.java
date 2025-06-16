package com.pulsetrade.user_service.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;



}
