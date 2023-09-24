package com.alechoskins.RecipeSharingApi.services.Recipes;

import com.alechoskins.RecipeSharingApi.database.pojos.Recipe;
import com.alechoskins.RecipeSharingApi.database.repository.Recipe.IRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServices implements IRecipeServices{

    @Autowired
    private IRecipeRepository recipeRepository;

    //region Get
    public List<Recipe> getAllRecipes() { return recipeRepository.findAll(); }
    public Recipe getRecipeById(Long id) { return recipeRepository.findById(id).orElse(null); }
    public Recipe getRecipeByName(String name) { return recipeRepository.findByName(name).orElse(null); }
    //endregion

    //region Save
    public Recipe saveRecipe(Recipe recipe) { return recipeRepository.save(recipe); }
    //endregion

    //region Delete
    public void deleteRecipeById(Long id) { recipeRepository.deleteById(id); }
    //endregion

}
