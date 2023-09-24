package com.alechoskins.RecipeSharingApi.controllers;

import com.alechoskins.RecipeSharingApi.database.pojos.Ingredient;
import com.alechoskins.RecipeSharingApi.global.constants.Endpoints;
import com.alechoskins.RecipeSharingApi.services.Ingredients.IIngredientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    IIngredientServices ingredientServices;

    //region Get
    @GetMapping(Endpoints.INGREDIENT_GET_ALL)
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        var data =  ingredientServices.getAllIngredients();
        return ResponseEntity.ok(data);
    }

    @GetMapping(Endpoints.INGREDIENT_GET)
    public ResponseEntity<Ingredient> getIngredient(@PathVariable Long id) {
        var data =  ingredientServices.getIngredientById(id);
        return ResponseEntity.ok(data);
    }
    //endregion

    //region Post
    @PostMapping(Endpoints.INGREDIENT_SAVE)
    public ResponseEntity<Ingredient> saveIngredient(Ingredient ingredient) {
        var data = ingredientServices.saveIngredient(ingredient);
        return ResponseEntity.ok(data);
    }
    //endregion

    //region Delete
    @DeleteMapping(Endpoints.INGREDIENT_DELETE)
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        ingredientServices.deleteIngredient(id);
        return ResponseEntity.ok().build();
    }
    //endregion
}
