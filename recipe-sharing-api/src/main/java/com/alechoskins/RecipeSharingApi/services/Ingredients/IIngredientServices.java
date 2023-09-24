package com.alechoskins.RecipeSharingApi.services.Ingredients;

import com.alechoskins.RecipeSharingApi.database.pojos.Ingredient;

import java.util.List;

public interface IIngredientServices {
    List<Ingredient> getAllIngredients();
    Ingredient getIngredientById(Long id);
    String getIngredientByUpc(String upc);
    Ingredient saveIngredient(Ingredient ingredient);
    void deleteIngredient(Long id);
}
