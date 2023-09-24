package com.alechoskins.RecipeSharingApi.dto.Ingredient;

import com.alechoskins.RecipeSharingApi.database.pojos.StoreLocation_Ingredient;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class IngredientDto {

    //region PROPERTIES
    @NotNull
    private Long id;
    @NotNull
    private String upc;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal ozPerUnit;
    //endregion

    //region RELATIONSHIPS
    private List<StoreLocation_Ingredient> storeLocation_ingredient;
    //endregion

}
