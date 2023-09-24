package com.alechoskins.RecipeSharingApi.services.Ingredients;

import com.alechoskins.RecipeSharingApi.database.pojos.Ingredient;
import com.alechoskins.RecipeSharingApi.database.repository.Ingredient.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServices implements IIngredientServices{

    @Autowired
    IIngredientRepository ingredientRepository;

    //region Get
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }
    public String getIngredientByUpc(String upc) {
        var ingredient = ingredientRepository.findByUpc(upc);
        //todo ingredient not found exception
        return ingredient.map(Ingredient::getName).orElse(null);
    }
    //endregion

    //region Save
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
    //endregion

    //region Delete
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
    //endregion

}
