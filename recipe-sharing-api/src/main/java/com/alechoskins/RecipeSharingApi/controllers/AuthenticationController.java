package com.alechoskins.RecipeSharingApi.controllers;

import com.alechoskins.RecipeSharingApi.global.constants.Endpoints;
import com.alechoskins.RecipeSharingApi.global.constants.HasRole;
import com.alechoskins.RecipeSharingApi.security.dto.AuthenticationResponse;
import com.alechoskins.RecipeSharingApi.security.dto.LoginRequest;
import com.alechoskins.RecipeSharingApi.security.dto.RegisterRequest;
import com.alechoskins.RecipeSharingApi.services.Authentication.IAuthenticationServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RoleNotFoundException;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final IAuthenticationServices authenticationService;

    @GetMapping()
    @PreAuthorize(HasRole.USER)
    public ResponseEntity<Boolean> authenticate(HttpServletResponse httpServletResponse){
        return ResponseEntity.ok(true);
    }

    @PostMapping(Endpoints.AUTH_REGISTER)
    public ResponseEntity<AuthenticationResponse> register(
            @Valid
            @RequestBody
            RegisterRequest registerRequest
    ) throws RoleNotFoundException {
        var authResponse = authenticationService.register(registerRequest);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping(Endpoints.AUTH_CONFIRM_EMAIL)
    @PreAuthorize(HasRole.USER)
    public ResponseEntity<String> confirmEmail(String request, HttpServletRequest servletRequest, HttpServletResponse servletResponse){
        var reqCookies = servletRequest.getCookies();
        return ResponseEntity.ok("YOU ACCESSED THE ENDPOINT");
    }

    @PostMapping(Endpoints.AUTH_LOGIN)
    public ResponseEntity<AuthenticationResponse> login(
            @Valid
            @RequestBody
            LoginRequest loginRequest,
            HttpServletResponse servletResponse
    ) {
        var authResult = authenticationService.authenticate(loginRequest);
        return ResponseEntity.ok(authResult);
    }
    @GetMapping(Endpoints.AUTH_LOGOUT)
    public void logout(){
        authenticationService.logout();
    }
}
/*
https://stackoverflow.com/questions/63224760/i-cant-find-my-spring-boot-httponly-cookie-on-my-client-site
Since my client is on localhost which is non-https, the cookie's secured flag must be set to false like cookie.setSecure(false); so that the browser will store the cookie even if the protocol is not secured.
Secondly, my code was missing cookie.setPath(""); and cookie.setDomain("") which makes Spring automatically set the cookie's path to the api's mapping. Setting it's domain name and path to "/" makes the cookie sent in any requests.
*
* */