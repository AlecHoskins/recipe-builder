package com.alechoskins.RecipeSharingApi.database.repository.Recipe;

import com.alechoskins.RecipeSharingApi.database.pojos.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByName(String name);
}
