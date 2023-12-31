package com.alechoskins.RecipeSharingApi.database.repository.Role;

import com.alechoskins.RecipeSharingApi.database.pojos.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
