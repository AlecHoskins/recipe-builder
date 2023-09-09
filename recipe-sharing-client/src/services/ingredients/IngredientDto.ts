import { StringLiteral } from "@babel/types";

export default interface IngredientDTO {
    id: number;
    sku: string;
    ingredientName: string;
    productName: string;
    description: string;
    oz: number;
    price: number;
    link: string;
    imageUrl: string;
}