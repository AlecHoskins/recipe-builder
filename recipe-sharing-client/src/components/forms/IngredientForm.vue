<template>
    <VForm>
        <VRow>
            <VCol>
                <VTextField v-model="ingredient.productName" label="Product Name"></VTextField>
            </VCol>
            <VCol>
                <VTextField v-model="ingredient.ingredientName" label="Ingredient Name"></VTextField>
            </VCol>
            <VCol>
                <VTextField v-model="ingredient.sku" label="SKU"></VTextField>
            </VCol>
        </VRow>
        <VRow>
            
        </VRow>
        <VRow>
            <VCol>
                <VTextField v-model="ingredient.oz" label="Oz each" type="number"></VTextField>
            </VCol>
            <VCol>
                <VTextField v-model="ingredient.price" label="Price per Unit" type="number"></VTextField>
            </VCol>
            <VCol>
                <VTextField v-model="ingredient.description" label="Description"></VTextField>
            </VCol>
        </VRow>
        <VTextField v-model="ingredient.link" label="Link"></VTextField>
        <VTextField v-model="ingredient.imageUrl" label="Image Link"></VTextField>
    </VForm>
</template>

<script setup lang="ts">
import IngredientDTO from '@/services/ingredients/IngredientDto';
import { ref } from 'vue';


//#region Form Data
const ingredient = ref({} as IngredientDTO);
//#endregion
</script>