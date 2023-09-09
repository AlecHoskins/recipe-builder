package com.alechoskins.RecipeSharingApi.services.Roles;

import com.alechoskins.RecipeSharingApi.database.pojos.Role;
import com.alechoskins.RecipeSharingApi.database.repository.Role.IRoleRepository;
import com.alechoskins.RecipeSharingApi.global.AppEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleServices implements IRoleServices {

    @Autowired
    IRoleRepository roleRepository;

    @Override
    public Role findByName(String username) {
        return roleRepository.findByName(username).orElse(null);
    }

    @Override
    //todo create migration for these roles instead of doing this manually
    public void createUserAdminRoles() {
        var roles = new ArrayList<Role>();
        roles.add( Role.builder().name( AppEnums.RoleNames.USER.name() ).build() );
        roles.add( Role.builder().name( AppEnums.RoleNames.ADMIN.name() ).build() );

        roleRepository.saveAll(roles);
    }
}
