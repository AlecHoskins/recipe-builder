package com.alechoskins.RecipeSharingApi.dto.recipe;

import com.alechoskins.RecipeSharingApi.dto.recipe_ingredients.Recipe_IngredientDto;
import java.util.List;

public class RecipeDto {

    //region PROPERTIES
    private Long id;
    private String name;
    private String description;
    private int minutes;
    private double servings;
    private Double lastRecordedPrice;
    private String link;
    private String imageUrl;
    //#endregion

    //#region NAV PROPERTIES
    private List<Recipe_IngredientDto> recipeIngredients;
    //#endregion

}
