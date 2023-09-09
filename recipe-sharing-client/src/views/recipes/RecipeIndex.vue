<template>
    <VDataTable height="31.273rem" :headers="headers" :items="tableData" fixed-header>
        <template v-slot:top>
            <div style="display:flex; justify-content: end;">
                <VBtn flat prepend-icon="mdi-plus" @click="redirectToRecipeDetails()">
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

//#region VDataTable
const headers = [
    { title: "Name", key: "name" },
    { title: "Price", key: "price" },
    { title: "Servings", key: "servings" },
    { title: "Time", key: "time" },
    { title: "Description", key: "description" },
    { title: "Link", key: "link" }
];
const tableData = [
    {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    }, {
        name: "Recipe 1",
        price: 10.99,
        servings: 4,
        time: "1h 30min",
        description: "This is a sample description for Recipe 1",
        link: "www.somethingrecipes.com"
    },
];

//#endregion

//#region Methods
function redirectToRecipeDetails() {
    router.push("/recipe-details")
}
//#endregion


</script>