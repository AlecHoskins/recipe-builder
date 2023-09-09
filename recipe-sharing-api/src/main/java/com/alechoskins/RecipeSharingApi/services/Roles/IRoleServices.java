package com.alechoskins.RecipeSharingApi.services.Roles;

import com.alechoskins.RecipeSharingApi.database.pojos.Role;

public interface IRoleServices {
    Role findByName(String username);
    void createUserAdminRoles();
}
