import RecipeTagDto from "@/services/recipeTags/RecipeTagDto";
import IngredientDTO from "../../ingredients/IngredientDto";
import InstructionDTO from "../../instructions/InstructionDto";

export default interface RecipeDTO {
    id: number;
    name: string;
    description: string;
    ingredients: IngredientDTO[];
    instructions: InstructionDTO[];
    minutes: number;
    servings: number;
    lastRecordedPrice: number | null;
    link: string;
    imageUrl: string;
    recipeTags: RecipeTagDto[];
}