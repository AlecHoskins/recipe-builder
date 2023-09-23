package com.alechoskins.RecipeSharingApi.services.Users;

import com.alechoskins.RecipeSharingApi.database.pojos.AppUser;
import com.alechoskins.RecipeSharingApi.database.pojos.UserRole;
import com.alechoskins.RecipeSharingApi.database.repository.User.IUserRepository;
import com.alechoskins.RecipeSharingApi.global.AppEnums;
import com.alechoskins.RecipeSharingApi.global.ErrorHandling.exceptions.UsernameAlreadyExistsException;
import com.alechoskins.RecipeSharingApi.services.Roles.IRoleServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServices implements IUserServices{

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleServices roleServices;
    @Autowired
    private PasswordEncoder passwordEncoder;


    //region METHODS
    @Transactional
    public AppUser create(AppUser appUser) {
        var allUsers = userRepository.findAll();
        var userExists = userRepository.existsByUsernameOrEmail(appUser.getUsername(), appUser.getEmail());
        if(!userExists){
            return userRepository.save(appUser);
        }
        throw new UsernameAlreadyExistsException("AppUser already Exists");
    }
    @Transactional
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public void createDefaultAdminUser() {

        var user = AppUser.builder()
                .username("admin")
                .password(passwordEncoder.encode("123qwe"))
                .email("admin@default.com")
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .isDeleted(false)
                .build();

        var adminRole = roleServices.findByName(AppEnums.RoleNames.ADMIN.name());
        var adminUserRole = UserRole.builder()
                .role(adminRole)
                .appUser(user)
                .build();
        var userRoles = new ArrayList<UserRole>();
        userRoles.add(adminUserRole);
        user.setUserRoles(userRoles);

        userRepository.save(user);
    }
    //endregion

    //region QUERIES
    public AppUser findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public AppUser findByUsernameOrEmail(String username, String email) {
        try{
            return userRepository.findByUsernameOrEmail(username, email).orElse(null);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean existsByUsernameOrEmail(String username, String email) {
         var result = userRepository.existsByUsernameOrEmail(username, email);
         return result;
    }
    //endregion
}
