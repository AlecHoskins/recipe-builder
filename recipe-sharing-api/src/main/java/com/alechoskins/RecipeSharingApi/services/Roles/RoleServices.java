package com.alechoskins.RecipeSharingApi.services.Roles;

import com.alechoskins.RecipeSharingApi.database.pojos.Role;
import com.alechoskins.RecipeSharingApi.database.repository.Role.IRoleRepository;
import com.alechoskins.RecipeSharingApi.global.AppEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServices implements IRoleServices {

    @Autowired
    IRoleRepository roleRepository;

    @Override
    public Role findByName(String username) {
        return roleRepository.findByName(username).orElse(null);
    }

    @Override
    public List<Role> findAll() { return roleRepository.findAll(); }

    @Override
    public void createUserRole() {
        var role = Role.builder().name( AppEnums.RoleNames.USER.name() ).build();
        roleRepository.save(role);
    }
    @Override
    public void createAdminRole() {
        var role = Role.builder().name( AppEnums.RoleNames.ADMIN.name() ).build();
        roleRepository.save(role);
    }
}
