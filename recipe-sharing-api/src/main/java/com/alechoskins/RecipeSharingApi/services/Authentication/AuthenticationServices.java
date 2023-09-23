package com.alechoskins.RecipeSharingApi.services.Authentication;

import com.alechoskins.RecipeSharingApi.database.pojos.AppUser;
import com.alechoskins.RecipeSharingApi.database.pojos.UserRole;
import com.alechoskins.RecipeSharingApi.dto.User.response.UserDto;
import com.alechoskins.RecipeSharingApi.global.AppEnums;
import com.alechoskins.RecipeSharingApi.security.dto.AuthenticationResponse;
import com.alechoskins.RecipeSharingApi.security.dto.LoginRequest;
import com.alechoskins.RecipeSharingApi.security.dto.RegisterRequest;
import com.alechoskins.RecipeSharingApi.services.Jwt.JwtServices;
import com.alechoskins.RecipeSharingApi.services.Roles.IRoleServices;
import com.alechoskins.RecipeSharingApi.services.Users.IUserServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationServices implements IAuthenticationServices {

    @Autowired
    private IUserServices userServices;
    @Autowired
    private IRoleServices roleServices;
    private final PasswordEncoder passwordEncoder;
    private final JwtServices jwtServices;
    private final AuthenticationManager authManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) throws RoleNotFoundException {
        //get role/create if not exists
        var userRole = roleServices.findByName(AppEnums.RoleNames.USER.name());
        if(userRole == null) {
            roleServices.createUserRole();
            userRole = roleServices.findByName(AppEnums.RoleNames.USER.name());
        }

        String verificationCode = RandomStringUtils.random(0, true, true);
        //TODO finish this email verification functionality

        var user = AppUser.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isEnabled(true) //TODO change isEnabled to false if requiring email verification
                .emailVerificationCode(verificationCode)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isAccountNonExpired(true)
                .build();
        //create appUser role for new appUser
        ArrayList<UserRole> userRoles = new ArrayList<UserRole>();
        userRoles.add(
                UserRole.builder()
                        .role(userRole)
                        .appUser(user)
                        .build()
        );
        var createdUser = userServices.create(user);
        var jwtToken = jwtServices.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(LoginRequest request)  {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsernameOrEmail(),
                        request.getPassword()
                )
        );
        var user = userServices.findByUsernameOrEmail(request.getUsernameOrEmail(), request.getUsernameOrEmail());
        if(user == null){
            //TODO throw custom exception
            return null;
        }
        if(!user.isEnabled()){
            //TODO throw custom exception
            return null;
        }

        var jwtToken = jwtServices.generateToken(user);
        var userDto = UserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getUserRoles().stream().map( x-> x.getRole().getName() ).collect(Collectors.toList()))
                .build();
        return AuthenticationResponse.builder()
                .user(userDto)
                .accessToken(jwtToken)
                .build();
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        cookieClearingLogoutHandler.logout(request, response, null);
        securityContextLogoutHandler.logout(request, response, null);
    }
}
