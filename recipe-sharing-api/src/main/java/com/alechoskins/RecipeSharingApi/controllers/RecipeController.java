package com.alechoskins.RecipeSharingApi.controllers;

import com.alechoskins.RecipeSharingApi.database.pojos.Recipe;
import com.alechoskins.RecipeSharingApi.global.constants.Endpoints;
import com.alechoskins.RecipeSharingApi.services.Recipes.IRecipeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    IRecipeServices recipeServices;

    //region Get
    @GetMapping(Endpoints.RECIPE_GET_ALL)
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        var data =  recipeServices.getAllRecipes();
        return ResponseEntity.ok(data);
    }

    @GetMapping(Endpoints.RECIPE_GET_BY_ID)
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        var data =  recipeServices.getRecipeById(id);
        return ResponseEntity.ok(data);
    }

    @GetMapping(Endpoints.RECIPE_GET_BY_NAME)
    public ResponseEntity<Recipe> getRecipeByName(@PathVariable String name) {
        var data =  recipeServices.getRecipeByName(name);
        return ResponseEntity.ok(data);
    }
    //endregion

    //region Post
    @PostMapping(Endpoints.RECIPE_SAVE)
    public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe recipe) {
        var data = recipeServices.saveRecipe(recipe);
        return ResponseEntity.ok(data);
    }
    //endregion

    //region Delete
    @DeleteMapping(Endpoints.RECIPE_DELETE)
    public ResponseEntity<Void> deleteRecipeById(@PathVariable Long id) {
        recipeServices.deleteRecipeById(id);
        return ResponseEntity.ok().build();
    }
    //endregion
}
