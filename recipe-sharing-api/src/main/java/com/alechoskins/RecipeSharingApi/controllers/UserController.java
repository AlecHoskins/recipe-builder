package com.alechoskins.RecipeSharingApi.controllers;

import com.alechoskins.RecipeSharingApi.database.pojos.AppUser;
import com.alechoskins.RecipeSharingApi.dto.User.response.UserDto;
import com.alechoskins.RecipeSharingApi.global.constants.Endpoints;
import com.alechoskins.RecipeSharingApi.services.Users.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping(Endpoints.USER)
    public ResponseEntity<UserDto> getUser(Authentication authentication) {
        try{
            var authorities = authentication.getAuthorities();
            var authenticationName = authentication.getName();
            var user = userServices.findByUsernameOrEmail(authentication.getName(), authentication.getName());

            var userDto = UserDto.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .roles(user.getUserRoles().stream().map(r-> r.getRole().getName()).collect(Collectors.toList()))
                    .build();

            return ResponseEntity.ok(userDto);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping(Endpoints.USER_GET_ALL)
    public AppUser getAllUsers(@PathVariable Long id) {
        return userServices.findById(id);
    }

    @GetMapping(Endpoints.USER_GET_BY_ID)
    public AppUser getUserById(@PathVariable Long id, Authentication authentication) {
        var authorities = authentication.getAuthorities();
        return userServices.findById(id);
    }

    /*
    @PutMapping("/{id}")
    public AppUser updateUser(@PathVariable String id, @RequestBody AppUser appUser) {
        return userService.updateUser(id, appUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @GetMapping("/")
    public List<AppUser> getAllUsers() {
        return userService.getAllUsers();
    }
    */
}
