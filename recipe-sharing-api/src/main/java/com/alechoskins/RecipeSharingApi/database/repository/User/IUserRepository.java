package com.alechoskins.RecipeSharingApi.database.repository.User;


import com.alechoskins.RecipeSharingApi.database.pojos.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<AppUser,Long> {

    @Query("SELECT u FROM AppUser u LEFT JOIN FETCH u.userRoles ur LEFT JOIN FETCH ur.role WHERE u.username = :username OR u.email = :email")
    Optional<AppUser> findByUsernameOrEmail(@Param("username") String username, @Param("email") String email);

//    @Query(value = "SELECT exists(SELECT u.id FROM app_user u WHERE u.username = :username or u.email = :email)", nativeQuery = true)
    public boolean existsByUsernameOrEmail(String username, String email);
}
