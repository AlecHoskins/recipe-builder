<template>
    <RecipeForm :key="recipeFormKey" @recipe-form-saved="updateRecipeForm"></RecipeForm>
</template>

<script lang="ts" setup>
import RecipeForm from '@/components/forms/RecipeForm.vue'
import { ref } from 'vue';

let recipeFormKey = ref(0);

//#region Methods
function updateRecipeForm(){
    alert("updating")
    recipeFormKey.value += 1;
}
//#endregion

</script>