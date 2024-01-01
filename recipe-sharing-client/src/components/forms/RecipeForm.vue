<template>
    <v-card>
        <v-tabs v-model="tab" bg-color="primary">
            <v-tab value="Recipe">Recipe</v-tab>
            <v-tab value="ingredients" v-if="queryHasIdParameter">Ingredients</v-tab>
            <v-tab value="steps" v-if="queryHasIdParameter">Steps</v-tab>
        </v-tabs>
        <v-card-text>
            <v-window v-model="tab">
                <v-window-item value="Recipe">
                    <VForm v-model="recipeFormValid" class="recipe-form" ref="recipeForm">
                        <VRow>
                            <VCol>
                                <VTextField v-model="recipe.name" :rules="[v => !!v || 'Recipe name is required']">
                                    <template #label>
                                        <p style="color:red">Recipe Name <span><strong>* </strong></span></p>
                                    </template>
                                </VTextField>
                            </VCol>
                            <!-- <VCol>
                                <VTextField v-model="recipe.price" :rules="[v => !!v || 'Price is required']" type="number">
                                    <template #label>
                                        <p style="color:red">Price (USD) <span><strong>* </strong></span></p>
                                    </template>
                                </VTextField>
                            </VCol> -->
                            <VCol>
                                <VTextField type="number" v-model="recipe.servings"
                                    :rules="[v => !!v || 'Servings is required']">
                                    <template #label>
                                        <p style="color:red">Servings <span><strong>* </strong></span></p>
                                    </template>
                                </VTextField>
                            </VCol>
                        </VRow>
                        <VRow>
                            <VCol>
                                <VTextField type="number" v-model="recipe.minutes"
                                    :rules="[v => !!v || 'Cook time is required']">
                                    <template #label>
                                        <p style="color:red">Cook Time (Minutes) <span><strong>* </strong></span></p>
                                    </template>
                                </VTextField>
                            </VCol>
                            <VCol>
                                <VTextField label="Link" v-model="recipe.link"></VTextField>
                            </VCol>
                            <VCol>
                                <VTextField label="Image Url" v-model="recipe.imageUrl"></VTextField>
                            </VCol>
                            <VCol>
                                <!-- <VSelect label="tags" multiple></VSelect> -->
                            </VCol>
                        </VRow>
                        <VRow>
                            <VCol>
                                <VTextarea label="Description" v-model="recipe.description"></VTextarea>
                            </VCol>
                        </VRow>
                        <VRow>
                            <VCol>
                                <VBtn color="blue" @click="saveRecipe">Save</VBtn>
                            </VCol>
                        </VRow>
                    </VForm>

                </v-window-item>
                <v-window-item value="ingredients" v-if="queryHasIdParameter">
                    <div v-for="ingredient in recipe.ingredients">
                        <VRow>
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
                            <VBtn prepend-icon="mdi-plus" @click="addExistingIngredientLine()">Add Existing Ingredient
                            </VBtn>
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
                <v-window-item value="steps" v-if="queryHasIdParameter">
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
import { RecipeServices } from '@/services/recipes/RecipeEndPoint'
import RecipeDTO from '@/services/recipes/dto/RecipeDto';
import { ref } from 'vue';
import IngredientForm from './IngredientForm.vue';
import IngredientDTO from '@/services/ingredients/IngredientDto';
import { VForm } from 'vuetify/lib/components/index.mjs';
import { useRouter } from 'vue-router';
const router = useRouter();
let tab = ref(null);
const isIngredientFormShowing = ref(false);
const queryHasIdParameter = ref(false);
const emit = defineEmits(["recipeFormSaved"]);

//#region Form Data
let recipe = ref({} as RecipeDTO);
const recipeFormValid = ref(false);
const recipeForm = ref(null as VForm | null);
//#endregion

//#region Methods
async function saveRecipe() {
    if (await recipeForm.value?.validate()) {
        RecipeServices.save(recipe.value)
            .then((res) => {
                router.replace({
                    path: `recipe-details/${res.id}`
                });
                emit("recipeFormSaved");
            })
            .catch((err) => {
            });
    }
}
function getRecipe(id: number) {
    RecipeServices.getById(id)
        .then((res) => {
            recipe.value = res;
        });
}
function toggleIngredientForm() {
    isIngredientFormShowing.value = !isIngredientFormShowing.value;
}
function addExistingIngredientLine() {
    if (!recipe.value.ingredients) {
        recipe.value.ingredients = [];
    }
    recipe.value.ingredients.push({} as IngredientDTO);
}
function setQueryHaveIdParameter(){
    router.currentRoute.value.params.id && parseInt(router.currentRoute.value.params.id) != 0 
    ? queryHasIdParameter.value = true
    : queryHasIdParameter.value = false;
}
//#endregion

if (router.currentRoute.value.params.id) {
    getRecipe(parseInt(router.currentRoute.value.params.id));
}
setQueryHaveIdParameter();

</script>