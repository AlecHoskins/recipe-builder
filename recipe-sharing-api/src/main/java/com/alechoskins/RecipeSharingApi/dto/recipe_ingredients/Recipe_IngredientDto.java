package com.alechoskins.RecipeSharingApi.dto.recipe_ingredients;

import com.alechoskins.RecipeSharingApi.dto.Ingredient.IngredientDto;
import com.alechoskins.RecipeSharingApi.dto.recipe.RecipeDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Recipe_IngredientDto {
    private long RecipeId;
    private long IngredientId;

    private RecipeDto recipe;
    private IngredientDto ingredientDto;
}
