package com.alechoskins.RecipeSharingApi.database.repository.Ingredient;

import com.alechoskins.RecipeSharingApi.database.pojos.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByUpc(String upc);
}
