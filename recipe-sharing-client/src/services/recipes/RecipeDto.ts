import IngredientDTO from "../ingredients/IngredientDto";
import InstructionDTO from "../instructions/InstructionDto";

export default interface RecipeDTO {
    id: number;
    name: string;
    description: string;
    ingredients: IngredientDTO[];
    instructions: InstructionDTO[];
    minutes: number;
    servings: number;
    price: number;
    link: string;
    imageUrl: string;
    tags: string[];
}