package com.alechoskins.RecipeSharingApi.security.dto;

import com.alechoskins.RecipeSharingApi.dto.User.response.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private UserDto user;
    private String accessToken;
    private String errorMessage;
}
