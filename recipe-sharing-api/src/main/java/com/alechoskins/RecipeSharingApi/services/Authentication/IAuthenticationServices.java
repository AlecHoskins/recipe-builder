package com.alechoskins.RecipeSharingApi.services.Authentication;

import com.alechoskins.RecipeSharingApi.security.dto.AuthenticationResponse;
import com.alechoskins.RecipeSharingApi.security.dto.LoginRequest;
import com.alechoskins.RecipeSharingApi.security.dto.RegisterRequest;

import javax.management.relation.RoleNotFoundException;

public interface IAuthenticationServices {

    AuthenticationResponse register(RegisterRequest request) throws RoleNotFoundException;

    AuthenticationResponse authenticate(LoginRequest request);

    void logout();
}
