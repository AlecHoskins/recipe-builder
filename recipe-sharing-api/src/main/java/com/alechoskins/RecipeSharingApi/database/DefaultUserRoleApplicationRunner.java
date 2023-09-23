package com.alechoskins.RecipeSharingApi.database;

import com.alechoskins.RecipeSharingApi.global.AppEnums;
import com.alechoskins.RecipeSharingApi.services.Roles.IRoleServices;
import com.alechoskins.RecipeSharingApi.services.Users.IUserServices;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Data
public class DefaultUserRoleApplicationRunner implements ApplicationRunner {
    @Autowired
    private final IRoleServices roleServices;
    @Autowired
    private final IUserServices userServices;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createDefaultUserAdminRoles();
        createDefaultAdminUser();
    }

    private void createDefaultUserAdminRoles(){
        var allRoles = roleServices.findAll();
        if(allRoles == null || allRoles.size() == 0){
            roleServices.createUserRole();
            roleServices.createAdminRole();
        }
        else{
            if(allRoles.stream().noneMatch(x -> x.getName().equals(AppEnums.RoleNames.USER.name()))){
                roleServices.createUserRole();
            }
            if(allRoles.stream().noneMatch(x -> x.getName().equals(AppEnums.RoleNames.ADMIN.name()))){
                roleServices.createAdminRole();
            }
        }
    }

    private void createDefaultAdminUser(){
        try{
            var adminUser = userServices.existsByUsernameOrEmail("admin","admin@default.com");
            if(!adminUser){
                userServices.createDefaultAdminUser();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
