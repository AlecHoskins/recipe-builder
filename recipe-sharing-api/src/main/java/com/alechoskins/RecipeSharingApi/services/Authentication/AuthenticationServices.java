package com.alechoskins.RecipeSharingApi.services.Authentication;

import com.alechoskins.RecipeSharingApi.database.pojos.Role;
import com.alechoskins.RecipeSharingApi.database.pojos.User;
import com.alechoskins.RecipeSharingApi.dto.User.response.UserDto;
import com.alechoskins.RecipeSharingApi.global.AppEnums;
import com.alechoskins.RecipeSharingApi.security.dto.AuthenticationResponse;
import com.alechoskins.RecipeSharingApi.security.dto.LoginRequest;
import com.alechoskins.RecipeSharingApi.security.dto.RegisterRequest;
import com.alechoskins.RecipeSharingApi.services.Jwt.JwtServices;
import com.alechoskins.RecipeSharingApi.services.Roles.IRoleServices;
import com.alechoskins.RecipeSharingApi.services.Users.IUserServices;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        var userRole = roleServices.findByName(AppEnums.RoleNames.USER.name());
        if(userRole != null) {
            ArrayList<Role> roles = new ArrayList<>();
            roles.add(userRole);
            String verificationCode = RandomStringUtils.random(0, true, true);
            //TODO finish this email verification functionality
            var user = User.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .isEnabled(true) //TODO change isEnabled to false if requiring email verification
                    .emailVerificationCode(verificationCode)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .isAccountNonExpired(true)
                    .roles(roles)
                    .build();
            var createdUser = userServices.create(user);
            var jwtToken = jwtServices.generateToken(user);
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .build();
        }
        else{
            roleServices.createUserAdminRoles();
            return null;
            //throw new RoleNotFoundException("Error, role not found in user creation."); TODO implement this if adding roles comes in later
        }
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
                .roles(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                .build();
        return AuthenticationResponse.builder()
                .user(userDto)
                .accessToken(jwtToken)
                .build();
    }

    @Override
    public void logout() {
        //TODO implement logout
    }
}
