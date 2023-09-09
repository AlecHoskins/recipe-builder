package com.alechoskins.RecipeSharingApi.services.Users;

import com.alechoskins.RecipeSharingApi.database.pojos.User;

public interface IUserServices {
    User create(User user) ;
    void delete(Long userId);

    //region QUERIES
    User findByUsernameOrEmail(String username, String email);
    User findById(Long userId);
    //endregion
}
