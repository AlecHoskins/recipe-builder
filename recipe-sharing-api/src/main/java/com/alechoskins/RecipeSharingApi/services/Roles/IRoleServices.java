package com.alechoskins.RecipeSharingApi.services.Roles;

import com.alechoskins.RecipeSharingApi.database.pojos.Role;

import java.util.List;

public interface IRoleServices {
    Role findByName(String username);
    List<Role> findAll();
    void createUserRole();
    void createAdminRole();
}
