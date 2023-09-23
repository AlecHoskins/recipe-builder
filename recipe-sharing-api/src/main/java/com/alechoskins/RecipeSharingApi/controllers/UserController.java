package com.alechoskins.RecipeSharingApi.controllers;

import com.alechoskins.RecipeSharingApi.database.pojos.AppUser;
import com.alechoskins.RecipeSharingApi.global.constants.Endpoints;
import com.alechoskins.RecipeSharingApi.services.Users.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping(Endpoints.USER_GET)
    public AppUser getUser(@PathVariable Long id, Authentication authentication) {
        var authorities = authentication.getAuthorities();
        return userServices.findById(id);
    }

    @GetMapping(Endpoints.USER_GET_ALL)
    public AppUser getAllUsers(@PathVariable Long id) {
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
