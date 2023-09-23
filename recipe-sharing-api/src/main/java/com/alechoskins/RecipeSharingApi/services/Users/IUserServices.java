package com.alechoskins.RecipeSharingApi.services.Users;

import com.alechoskins.RecipeSharingApi.database.pojos.AppUser;

public interface IUserServices {
    AppUser create(AppUser appUser) ;
    void delete(Long userId);
    void createDefaultAdminUser();
    //region QUERIES
    AppUser findByUsernameOrEmail(String username, String email);
    boolean existsByUsernameOrEmail(String username, String email);
    AppUser findById(Long userId);
    //endregion
}
