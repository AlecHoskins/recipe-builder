package com.alechoskins.RecipeSharingApi.database.repository.User;


import com.alechoskins.RecipeSharingApi.database.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM app_user WHERE username = :username or email = :email", nativeQuery = true)
    Optional<User> findByUsernameOrEmail(String username, String email);

    @Query(value = "SELECT exists(SELECT * FROM app_user WHERE username = :username or email = :email)", nativeQuery = true)
    boolean existsByUsernameOrEmail(String username, String email);
}
