<template>
    <v-card>
        <v-tabs v-model="tab" bg-color="primary">
            <v-tab value="Recipe">Recipe</v-tab>
            <v-tab value="ingredients">Ingredients</v-tab>
            <v-tab value="steps">Steps</v-tab>
        </v-tabs>

        <v-card-text>
            <v-window v-model="tab">
                <v-window-item value="Recipe">
                    <VRow>
                        <VCol>
                            <VTextField label="Recipe Name" v-model="recipe.name"></VTextField>
                        </VCol>
                        <VCol>
                            <VTextField label="Price" v-model="recipe.price"></VTextField>
                        </VCol>
                        <VCol>
                            <VTextField type="number" label="Servings" v-model="recipe.servings"></VTextField>
                        </VCol>
                    </VRow>
                    <VRow>
                        <VCol>
                            <VTextField label="Cook Time (Minutes)" v-model="recipe.minutes"></VTextField>
                        </VCol>
                        <VCol>
                            <VTextField label="Link" v-model="recipe.link"></VTextField>
                        </VCol>
                        <VCol>
                            <VTextField label="Image Url" v-model="recipe.imageUrl"></VTextField>
                        </VCol>
                        <VCol>
                            <VSelect label="tags" multiple></VSelect>
                        </VCol>
                    </VRow>
                    <VRow>
                        <VCol>
                            <VTextarea label="Description" v-model="recipe.description"></VTextarea>
                        </VCol>
                    </VRow>
                </v-window-item>
                <v-window-item value="ingredients">
                    <div v-for="ingredient in recipe.ingredients">
                        <VRow >
                            <VCol>
                                <VSelect label="Sku"></VSelect>
                            </VCol>
                            <VCol>
                                <VSelect label="Product Name"></VSelect>
                            </VCol>
                            <VCol>
                                <VTextField label="Quantity" type="number"></VTextField>
                            </VCol>
                            <VCol>
                                <VCardText>
                                    Quantity to Purchase:
                                </VCardText>
                            </VCol>
                            <VCol>
                                <VCardText>
                                    Price:
                                </VCardText>
                            </VCol>
                        </VRow>
                    </div>

                    <!-- footer -->
                    <VRow>
                        <VCol>
                            <VDivider></VDivider>
                        </VCol>
                    </VRow>
                    <VRow>
                        <VCol>
                            <VBtn prepend-icon="mdi-plus" @click="addExistingIngredientLine()" >Add Existing Ingredient</VBtn>
                        </VCol>
                        <VCol>
                            <v-btn prepend-icon="mdi-plus">
                                Add New Ingredient
                                <v-dialog v-model="isIngredientFormShowing" activator="parent" width="auto">
                                    <v-card style="padding: 2rem;">
                                        <VRow>
                                            <VCol>
                                                <VCardTitle>New Ingredient</VCardTitle>
                                            </VCol>
                                        </VRow>
                                        <VRow>
                                            <VCol>
                                                <VDivider></VDivider>
                                            </VCol>
                                        </VRow>
                                        <VRow>
                                            <VCol>
                                                <IngredientForm></IngredientForm>
                                            </VCol>
                                        </VRow>
                                        <VRow>
                                            <VCol>
                                                <v-btn color="red" block
                                                    @click="isIngredientFormShowing = false">Cancel</v-btn>
                                            </VCol>
                                            <VCol>
                                                <v-btn color="blue" block
                                                    @click="isIngredientFormShowing = false">Save</v-btn>
                                            </VCol>
                                        </VRow>
                                    </v-card>
                                </v-dialog>
                            </v-btn>
                        </VCol>
                        <VCol></VCol>
                        <VCol></VCol>
                        <VCol>
                            <VCardText>Total:</VCardText>
                        </VCol>
                    </VRow>
                </v-window-item>
                <v-window-item value="steps">
                    <VRow>
                        <VCol>
                            <VCardTitle>Instructions</VCardTitle>
                        </VCol>
                    </VRow>
                </v-window-item>
            </v-window>
        </v-card-text>
    </v-card>
</template>

<script lang="ts" setup>
import RecipeDTO from '@/services/recipes/RecipeDto';
import { ref } from 'vue';
import IngredientForm from './IngredientForm.vue';
import IngredientDTO from '@/services/ingredients/IngredientDto';

let tab = ref(null);
const isIngredientFormShowing = ref(false);
//#region Form Data
let recipe = ref({} as RecipeDTO);
//#endregion

//#region Methods
function toggleIngredientForm() {
    isIngredientFormShowing.value = !isIngredientFormShowing.value;
}
function addExistingIngredientLine(){
    if(!recipe.value.ingredients){
        recipe.value.ingredients = [];
    }
    recipe.value.ingredients.push({} as IngredientDTO);
}
//#endregion
</script>