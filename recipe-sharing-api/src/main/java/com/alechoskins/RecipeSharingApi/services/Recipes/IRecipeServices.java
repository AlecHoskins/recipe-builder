package com.alechoskins.RecipeSharingApi.services.Recipes;

import com.alechoskins.RecipeSharingApi.database.pojos.Recipe;

import java.util.List;

public interface IRecipeServices {
    //region Get
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
    Recipe getRecipeByName(String name);
    //endregion

    //region Save
    Recipe saveRecipe(Recipe recipe);
    //endregion

    //region Delete
    void deleteRecipeById(Long id);
    //endregion
}
