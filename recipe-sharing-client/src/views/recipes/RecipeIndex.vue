<template>
    <VDataTable height="31.273rem" :headers="headers" :items="recipes" fixed-header @click:row="redirectToRecipeDetails">
        <template v-slot:top>
            <div style="display:flex; justify-content: end;">
                <VBtn flat prepend-icon="mdi-plus" @click="redirectToRecipeDetails">
                    New Recipe
                    <router-link :to="{ path: '/recipe-details' }" :replace="true"></router-link>
                </VBtn>
            </div>
        </template>
    </VDataTable>
</template>


<script lang="ts" setup>
import { VDataTable } from 'vuetify/lib/labs/components.mjs';
import BaseForm from '@/components/BaseForm.vue';
import RecipeDTO from '../../services/recipes/RecipeDto'
import { ref } from 'vue';
import IngredientDTO from '@/services/ingredients/IngredientDto';
import { VDialog } from 'vuetify/lib/components/index.mjs';
import router from '@/router';
import { RecipeServices } from '@/services/recipes/RecipeEndPoint';

//#region VDataTable
const headers = [
    {key: "id", align: " d-none"},
    { title: "Name", key: "name" },
    { title: "Price", key: "price" },
    { title: "Servings", key: "servings" },
    { title: "Time", key: "time" },
    // { title: "Description", key: "description" },
    { title: "Link", key: "link" }
];
const recipes = ref([] as RecipeDTO[]);

//#endregion

//#region Methods
function getRecipes(){
    RecipeServices.getAll()
    .then(res => {
        recipes.value = res;
    });
}
function redirectToRecipeDetails(e: any, item: any) {
    var clickedRecipeId = item?.item?.raw?.id;
    clickedRecipeId ? router.replace(`/recipe-details/${clickedRecipeId}`)  : router.replace(`/recipe-details`)
    
}
//#endregion
getRecipes();

</script>